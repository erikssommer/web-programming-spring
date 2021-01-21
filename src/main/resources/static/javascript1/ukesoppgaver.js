//Oppgave 1
function heiVerden() {
    document.write("Hei verden");
}

//Oppgave 2
function heiVerdenAlert() {
    alert("Hei verden");
}

//Oppgave 3
function skrivMelding(input) {
    document.write(input);
}

//Oppgave 4
function writeAlert(data) {
    alert(data);
}

//Oppgave 5
function writeConsole(data) {
    console.log(data);
}

//Oppgave 6
function skrivMeldingFarget(input) {
    document.write(input.fontcolor("red"));
}

//Oppgave 7
function tilStorBokstav(input) {
    document.write(input.toUpperCase());
}

//Oppgave 8
function skrivUtEn() {
    const ut = 1;
    console.log(ut);
}

//Oppgave 9
let ut = 0;

function tellOpp() {
    ut += 1;
    console.log(ut);
}

//Oppgave 10
let out = 0;

function tellOppMelding() {
    out += 1;
    let meldingP1 = "Du har trykket på knappen ";
    let meldingP2 = " ganger.";
    console.log(meldingP1 + out + meldingP2);
}
