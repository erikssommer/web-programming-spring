//Oppgave 1
function printInfo() {
    let navn = document.getElementById("navn").value;
    let alder = document.getElementById("alder").value;
    let output = document.getElementById("output");
    let alderTest = Number(alder);
    if (isNaN(alderTest) || alderTest < 1) {
        alert("Du må skrive inn et tall større enn 0!");
    } else {
        output.innerHTML = "Hei, " + navn + ". Du er " + alder + " år gammel.";
    }
}

//Oppgave 2
function fahrenheitToCelsius(f) {
    document.getElementById("celsius").value = (5 / 9) * (parseFloat(f) - 32);
}

function celsiusToFahrenheit(c) {
    document.getElementById("fahrenheit").value = (9 / 5) * parseFloat(c) + 32;

}

//Oppgave 3
function pluss() {
    let in_1 = parseFloat(document.getElementById("in_1").value);
    let in_2 = parseFloat(document.getElementById("in_2").value);
    let output = document.getElementById("kalk-output");
    if (isNaN(in_1) || isNaN(in_2)) {
        alert("Feil tallformat, prøv igjen.");
    } else {
        output.innerHTML = (in_1 + in_2).toString();
    }
}

function minus() {
    let in_1 = parseFloat(document.getElementById("in_1").value);
    let in_2 = parseFloat(document.getElementById("in_2").value);
    let output = document.getElementById("kalk-output");
    if (isNaN(in_1) || isNaN(in_2)) {
        alert("Feil tallformat, prøv igjen.");
    } else {
        output.innerHTML = (in_1 - in_2).toString();
    }
}

function gange() {
    let in_1 = +(document.getElementById("in_1").value);
    let in_2 = +(document.getElementById("in_2").value);
    let output = document.getElementById("kalk-output");
    if (isNaN(in_1) || isNaN(in_2)) {
        alert("Feil tallformat, prøv igjen.");
    } else {
        output.innerHTML = (in_1 * in_2).toString();
    }
}

function dele() {
    let in_1 = Number(document.getElementById("in_1").value);
    let in_2 = Number(document.getElementById("in_2").value);
    let output = document.getElementById("kalk-output");
    if (isNaN(in_1) || isNaN(in_2)) {
        alert("Feil tallformat, prøv igjen.");
    } else {
        output.innerHTML = (in_1 / in_2).toString();
    }
}

//Oppgave 4
const personRegister = [];

function visPersonRegister() {
    // skriv ut
    let ut = "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";
    for (let p of personRegister) {
        ut += "<tr>";
        ut += "<td>" + p.navn + "</td><td>" + p.adresse + "</td><td>" + p.telefonnr + "</td>";
        ut += "</tr>";
    }
    document.getElementById("personRegister").innerHTML = ut;
}

function registrer() {
    const navn = document.getElementById("objNavn").value;
    const adresse = document.getElementById("objAdresse").value;
    const telefonnr = document.getElementById("objTelefonnr").value;

    const person = {
        navn: navn,
        adresse: adresse,
        telefonnr: telefonnr
    };

    personRegister.push(person);
    //nullstill inputboksene
    document.getElementById("objNavn").value = "";
    document.getElementById("objAdresse").value = "";
    document.getElementById("objTelefonnr").value = "";
    visPersonRegister()
}

//Oppgave 5
const liste = document.getElementById("gjoremol");
const skrivInn = document.getElementById("skrivInn")

function leggTilGjoremol() {

    let ut;
    ut = "<li>"
    ut += '<input type="checkbox">'
    ut += "<span>" + skrivInn.value + "</span>"
    ut += "</li>"

    skrivInn.value = ""
    liste.insertAdjacentHTML('beforeend', ut);

}

//Oppgave 6
const uferdig = document.getElementById("uferdig");
const ferdig = document.getElementById("ferdig");
const skrivInn2 = document.getElementById("skrivInn2")
let id = 0;

function leggTilGjoremol2() {
    //Inkrementer id
    id++;
    let ut;
    ut = '<li id="rad-' + id + '">'
    ut += '<input id="sjekkboks-' + id + '" type="checkbox" onchange="veksleStatus(' + id + ')">'
    ut += "<span>" + skrivInn2.value + "</span>"
    ut += "</li>"

    //Tøm skriv inn feltet
    skrivInn2.value = ""

    //Print gjøremål til tabell
    uferdig.innerHTML += ut;
}

function veksleStatus(id) {
    //Hent raden og sjekkboksen basert på id'en
    const sjekkbox = document.getElementById("sjekkboks-" + id)
    const rad = document.getElementById("rad-" + id)

    //Flytt raden avhengig av om sjekkboksen er sjekket
    if (sjekkbox.checked) {
        rad.style.textDecoration = 'line-through'
        ferdig.appendChild(rad)
    } else {
        rad.style.textDecoration = 'none'
        uferdig.appendChild(rad)
    }
}

//Oppgave 7
const liste2 = document.getElementById('liste')
const oppgaver = []
const oppgave1 = {
    sporsmol: "Når er frist for oblig 1?",
    alternativer: ['1. Februar', '6. Februar', '12. Februar'],
    riktigIndex: 2
}

const oppgave2 = {
    sporsmol: "Hvor mange obliger er det i dette faget?",
    alternativer: ['3', '5', 'ingen', '2'],
    riktigIndex: 0
}

const oppgave3 = {
    sporsmol: "Hva står API for?",
    alternativer: ['App Program Instruction', 'Application Programming Interface', 'Det er ikke en forkortelse'],
    riktigIndex: 1
}

oppgaver.push(oppgave1)
oppgaver.push(oppgave2)
oppgaver.push(oppgave3)

function skrivUtOppgaver() {
    let ut = ""
    let id = 0
    let oppgaveIndex = 0
    for (let oppgave of oppgaver) {
        ut += "<li>"
        ut += "<h4>" + oppgave.sporsmol + "</h4>"
        ut += "<div>"
        for (let alternativ of oppgave.alternativer) {
            id++;
            ut += '<label for="' + id + '">' + alternativ + "</label>"
            ut += '<input id="' + id + '" type="radio" value="' + alternativ + '" name="oppgave-' + oppgaveIndex + '"><br>'
        }
        ut += "</div>"
        ut += "</li>"

        oppgaveIndex++;
    }
    ut += '<button onclick="sjekkSvar()">Sjekk svar</button>'
    liste2.innerHTML = ut;
}

function sjekkSvar() {
    let riktigeSvar = 0
    for (let oppgaveIndex = 0; oppgaveIndex < oppgaver.length; oppgaveIndex++) {
        const radioKnapper = document.querySelectorAll('[name="oppgave-' + oppgaveIndex + '"]');
        let svar
        for (let alternativ of radioKnapper) {
            if (alternativ.checked) {
                svar = alternativ.value;
                break;
            }
        }

        if (sjekkOmRiktig(oppgaveIndex, svar)) {
            riktigeSvar++;
        }
    }
    liste2.innerHTML = '';
    alert(riktigeSvar + " av " + oppgaver.length + " oppgaver er riktige")
}

function sjekkOmRiktig(oppgaveIndex, svar) {
    const oppgave = oppgaver[oppgaveIndex]
    if (oppgave.riktigIndex === oppgave.alternativer.indexOf(svar)) {
        return true;
    } else {
        return false;
    }
    //return oppgave.riktigIndex === oppgave.alternativer.indexOf(svar); Forkortet versjon
}