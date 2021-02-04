const liste = [];
const objekter = [];

function beregn() {
    document.getElementById("melding").innerHTML = "";

    let input = document.getElementById("valg").value;
    document.getElementById("valg").value = "";

    liste.push(input);

    for (let i = 0; i < liste.length; i++) {
        document.getElementById("melding").innerHTML += liste[i] + "<br>";
    }

    for (let tekst of liste) {
        document.getElementById("melding").innerHTML += tekst + "<br>";
    }
}

function objekt() {
    document.getElementById("melding").innerHTML = "";

    const objekt1 = {
        navn: document.getElementById("objekt").value
    }

    objekter.push(objekt1);

    for (let i = 0; i < objekter.length; i++) {
        document.getElementById("melding").innerHTML += objekter[i].navn + "<br>";
    }

    for (let objekt of objekter) {
        document.getElementById("melding").innerHTML += objekt.navn + "<br>";
    }
}