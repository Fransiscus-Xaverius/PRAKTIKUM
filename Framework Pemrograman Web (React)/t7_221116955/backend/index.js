const express = require('express');
const app = express();
const cors = require('cors');
app.use(express.json());
app.use(cors());  

const { MongoClient, ObjectId } = require('mongodb');

const url = 'mongodb://localhost:27017';

const dbName = 'football';

const client = new MongoClient(url);

async function run() {
    try {
      // Connect the client to the server	(optional starting in v4.7)
      await client.connect();
      // Send a ping to confirm a successful connection
      await client.db("admin").command({ ping: 1 });
      console.log("Pinged your deployment. You successfully connected to MongoDB!");
    } finally {
      // Ensures that the client will close when you finish/error
      await client.close();
    }
}
run().catch(console.dir);

app.post('/teams', async (req, res) => {
    const {nama, coach} = req.query;
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('teams');
    const result = await collection.insertOne({nama: nama, coach: coach, win: 0, lose: 0, draw: 0});
    return res.status(201).send({msg:"Team berhasil ditambahkan", id: result.insertedId});
});

app.post('/players', async (req, res) => {
    const {nama, nomor, position, nationality, team_id} = req.query;
    console.log(nama);
    console.log(position);
    console.log(team_id);
    const no = parseInt(nomor);
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('players');
    const result = await collection.insertOne({nama: nama, nomor: no, position: position, nationality:nationality ,team_id: team_id});
    console.log(result);
    return res.status(201).send({msg:"Player berhasil ditambahkan", id: result.insertedId});
});

app.post('/newTeam', async (req,res) => {
    const {nama, coach} = req.query;
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('teams');
    const result = await collection.insertOne({name: nama, coach: coach, record:{win: 0, lose: 0, draw: 0}, players: []});
    return res.status(201).send({msg:"Team berhasil ditambahkan", id: result.insertedId});
});

app.get('/teams', async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('teams');
    const result = await collection.find({}).toArray();
    return res.status(200).send(result);
});

app.get('/players', async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('players');
    const players = await collection.find({}).toArray();
    const teams = await db.collection('teams').find({}).toArray();
    let data = [];
    for (let i = 0; i < players.length; i++) {
        const team = await db.collection('teams').findOne({ players:{$in:[new ObjectId(players[i]._id)]} });
        data.push({
            name: players[i].name,
            team: team.name,
            age: players[i].age,
            number: players[i].number,
            nationality: players[i].nationality,
            position: players[i].position
        });
    }
    console.log(data);
    return res.status(200).send(data);
});

app.post('/player', async(req,res) => {
    const {name, age, nationality, number, position, team_id} = req.query;
    const no = parseInt(number);
    const Age = parseInt(age);
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('players');
    const add = await collection.insertOne({name:name, age:Age, position:position, nationality:nationality, number:no })
    const collection2 = db.collection('teams');
    console.log(team_id);
    console.log(add.insertedId);
    const result = await collection2.updateOne({_id: new ObjectId(team_id)}, {$push: {players: add.insertedId}})
    console.log(result);
    return res.status(201).send({message:"Berhasil"})
})

app.get("/matches", async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection("matches");
    const result = await collection.find({}).toArray();
    return res.status(200).send(result);
});

app.get('/most-points', async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('teams');
    const result = await collection.find({}).toArray();
    let sortedTeams = result.sort((a, b) => {
        const pointsA = a.record.win * 5 + a.record.draw * 2;
        const pointsB = b.record.win * 5 + b.record.draw * 2;
        return pointsB - pointsA;
    });
    let top3Teams = sortedTeams.slice(0, 3);
    return res.status(200).send(top3Teams);
});

app.get('/most-goals', async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('players');
    const result = await collection.find({}).toArray();
    const playerMap = new Map();
    result.forEach(player => {
        playerMap.set(player._id.toString(), 0);
    });
    const matches = await db.collection('matches').find({}).toArray();
    matches.forEach(match => {
       let logs = match.logs;
         logs.forEach(log => {
              if (log.event === 'goal') {
                playerMap.set(log.player.toString(), playerMap.get(log.player.toString()) + 1);
              }
         });
    });

    let sortedPlayers = Array.from(playerMap).sort((a, b) => b[1] - a[1]);
    let topPlayer = sortedPlayers.slice(0, 3);
    console.log(playerMap);

    let data = [];
    for (let i = 0; i < topPlayer.length; i++) {
        const player = await db.collection('players').findOne({ _id: new ObjectId(topPlayer[i][0]) });
        const team = await db.collection('teams').findOne({ _id: new ObjectId(player.team_id) });
        data.push({
            name: player.name,
            goals: topPlayer[i][1]
        });
    }

    return res.status(200).send(data);
});

app.get('/last-match', async (req, res) => {
    client.connect();
    const db = client.db(dbName);
    const collection = db.collection('matches');
    const result = await collection.findOne({}, { sort: { _id: -1 } });
    const teamhome = await db.collection('teams').findOne({ _id: new ObjectId(result.team_home) });
    const teamaway = await db.collection('teams').findOne({ _id: new ObjectId(result.team_away) });

    const match = {
        team_home: teamhome.name,
        team_away: teamaway.name,
        score_home: result.score_home,
        score_away: result.score_away,
    };

    return res.status(200).send(match);
});

app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
