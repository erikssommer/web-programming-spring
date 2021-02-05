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