let time = 0;
let count = 0;
setInterval(counter,1000);
var takingorder = false;
let order = "";
let duit = 0;
let hargaMush = 5;
let hargaPepp = 5;
let cheated = false;
let upMush = 10;
let upPepp = 10;
let progbar1 = 0;
let progbar2 = 0;

function counter(){
    time++;
    console.log(time);
    if(time%5==0){
        if(count<3){
            let tipe = Math.floor(Math.random() * 10);
            if(tipe<6){
                createBtn(1);
            }
            else{
                createBtn(2);
            }
            count++;
        }
    }
}

function createBtn(mode){
    var map = document.getElementById("bawahanbang");
    var Pizza = document.createElement("button");
    Pizza.addEventListener("click",onClick);
    let randX = Math.floor(Math.random()* 600)+250;
    let randY = Math.floor(Math.random()* 550)+150;
    if(mode==1){
        Pizza.style.backgroundImage="url(assets/pepperoni.png)";
        Pizza.id ="pepperoni";
        console.log("halo");
    }
    else{
        Pizza.style.backgroundImage="url(assets/mushroom.png)";
        Pizza.id = "mushroom";
        console.log("halo1");
    }
    Pizza.style.left = randX + "px";
    Pizza.style.top = randY + "px";
    Pizza.classList.add("pizzabtn");
    map.appendChild(Pizza);
}

function onClick(e){
    var activePizza = document.getElementById("activeImg");
    console.log(activePizza.style.backgroundImage);

    if(e.target.id == "mushroom" && !takingorder){
        console.log("mushroom");
        activePizza.style.backgroundImage="url(assets/mushroom.png)";
        takingorder = true;
        order = "mushroom";
        e.target.remove();
        count--;
    }
    else if (e.target.id == "pepperoni" && !takingorder){
        console.log("pepperoni");
        activePizza.style.backgroundImage="url(assets/pepperoni.png)";
        takingorder = true;
        e.target.remove();
        order = "pepperoni";
        count--;
    }
}

function makeMushroom(){
    if(order=="mushroom"){
        takingorder = false;
        duit+=hargaMush;
        var activePizza = document.getElementById("activeImg");
        activePizza.style.backgroundImage="none";
    }
    else{
        duit-=(duit/2);
    }
    document.getElementById("nominal").innerHTML = duit;
}

function makePepperoni(){
    if(order=="pepperoni"){
        takingorder = false;
        duit+=hargaPepp;
        var activePizza = document.getElementById("activeImg");
        activePizza.style.backgroundImage="none";
    }
    else{
        duit-=(duit/2);
    }
    document.getElementById("nominal").innerHTML = duit;
}

function cheat(){
    if(!cheated){
        cheated = true;
        duit+=100;
        document.getElementById("nominal").innerHTML = duit;
    }
}

function upgradeMushroom(){
    console.log("upgrade mushroom")
    if(upMush<=30&&duit>=upMush){
        console.log("mushroom diupgrade..")
        hargaMush+=2;
        duit-=upMush;
        upMush+=10;
        if(upMush==40){
            document.getElementById("money1").innerHTML = "Max Upgrade";
        }
        else{
            document.getElementById("money1").innerHTML = "$"+upMush;
        }
        document.getElementById("nominal").innerHTML = duit;
        progbar1+=33.3;
        var bar = document.getElementById("mushProg").style.width=progbar1+"%";
    }
}

function upgradePepperoni(){
    console.log("upgrade Pepp")
    if(upPepp<=30&&duit>=upPepp){
        hargaPepp+=2;
        duit-=upPepp;
        upPepp+=10;
        if(upPepp==40){
            document.getElementById("money2").innerHTML = "Max Upgrade";
        }
        else{
            document.getElementById("money2").innerHTML = "$"+upPepp;
        }
        document.getElementById("nominal").innerHTML = duit;
        progbar2+=33.3;
        var bar = document.getElementById("peppProg").style.width=progbar2+"%";
    }
}