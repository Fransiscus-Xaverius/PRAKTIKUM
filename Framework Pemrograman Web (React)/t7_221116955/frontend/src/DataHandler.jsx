import client from "./client";

const getAllData = async () => {
    const teams = await getAllTeams();
    const players = await getAllPlayers();
    const matches = await getAllMatches();

    return {
        teams: teams.data,
        players: players.data,
        matches: matches.data
    }
}

const getHomeData = async () => {   
    const lastmatch = await client.get("/last-match");
    const mostpoints = await client.get("/most-points");
    const mostgoals = await client.get("/most-goals");

    return {
        lastmatch: lastmatch.data,
        mostpoints: mostpoints.data,
        mostgoals: mostgoals.data
    }
}

const getAllPlayers = async () => { 
    return client.get("/players");
}

const getAllMatches = async () => {
    return client.get("/matches");
}

const getAllTeams = async () => {
    return client.get("/teams");
}

const getPlayersFromTeam = async (team_id) => {
    return client.get("/players?team_id=" + team_id);
}

const getTeamsDetails = async () => {
    const teams = await getAllTeams();
    const teamsDetails = [];
    for (const team of teams.data) {
        const players = await getPlayersFromTeam(team.id);
        teamsDetails.push({
            team: team,
            players: players.data
        });
    }
    return teamsDetails;
}

export default { getAllTeams, getPlayersFromTeam, getTeamsDetails, getAllPlayers, getAllMatches, getAllData, getHomeData };

