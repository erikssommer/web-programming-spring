let ut = "";

function visPersonRegister() {
    const liste = [];

    const person1 = {
        navn: "Ole Olsen",
        adresse: "Osloveien 22",
        telefonnr: "78654678"
    }

    const person2 = {
        navn: "Nina From",
        adresse: "Trondheimsveien 32",
        telefonnr: "69834234"
    }

    /*
    const person10 = {
        navn: document.getElementById("navn").value,
        adresse: document.getElementById("adresse").value,
        telefonnr: document.getElementById("telefonnr").value
    }
     */

    liste.push(person1, person2);

    formaterUt(liste);

    const person3 = {
        navn: "Markus Berg",
        adresse: "Bergenveien",
        telefonnr: "78045321"
    }

    const person4 = {
        navn: "Amalie Lier",
        adresse: "Lierveien 23",
        telefonnr: "67954223",
    }

    const person5 = {
        navn: "Henriette Moren",
        adresse: "Lillehammerveien 54",
        telefonnr: "894532435"
    }

    liste.push(person3, person4, person5);

    ut += "<br><br>";
    ut += "Usortert liste: <br>";

    formaterUt(liste);

    sorterNavn(liste);

    const sorterListe = liste.sort(compare);

    function compare(a, b) {
        if (a.navn < b.navn) {
            return -1;
        }
        if (a.navn > b.navn) {
            return 1;
        }
        return 0;
    }

    ut += "<br><br>";
    ut += "Sortert liste med metoden sort(compare): <br>";

    formaterUt(sorterListe);

    ut += "<br><br>";
    ut += "Annenhver sort: <br>";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    let teller = 0;
    for (let person of sorterListe) {
        if (teller % 2 === 0) {
            ut += "<tr>";
            ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
            ut += "</tr>";
        } else {
            ut += "<tr>";
            ut += "<td><strong>" + person.navn + "</strong></td><td><strong>" + person.adresse +
                "</strong></td><td><strong>" + person.telefonnr + "</strong></td>";
            ut += "</tr>";
        }
        teller++;
    }
    ut += "</table>";

    sorterListe[0].fnr = 12985678843;
    sorterListe[1].fnr = 89872387438;
    sorterListe[2].fnr = 66793980327;
    sorterListe[3].fnr = 24462417652;
    sorterListe[4].fnr = 43628976963;

    ut += "<br><br>";
    ut += "Menn med fet skrift: <br>";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th><th>Fødselsnummer</th>" +
        "</tr>";

    for (let person of sorterListe) {
        if (person.fnr.toString()[8] % 2 === 0) {
            ut += "<tr>";
            ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" +
                person.telefonnr + "</td><td>" + person.fnr + "</td>";
            ut += "</tr>";
        } else {
            ut += "<tr>";
            ut += "<td><strong>" + person.navn + "</strong></td><td><strong>" + person.adresse +
                "</strong></td><td><strong>" + person.telefonnr + "</strong></td><td><strong>" +
                person.fnr + "</strong></td>";
            ut += "</tr>";
        }
    }
    ut += "</table>";

    skrivUt();

}

function sorterNavn(array) {
    for (let i = 0; i < array.length; i++) {
        for (let j = i + 1; j < array.length; j++) {
            if (array[i].navn > array[j].navn) {
                let tmp = array[i].navn;
                array[i].navn = array[j].navn;
                array[j].navn = tmp;
            }
        }
    }

    ut += "<br><br>";
    ut += "Sortert liste med egen algoritme: <br>";

    formaterUt(array);
}

function formaterUt(array) {
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    for (let person of array) {
        ut += "<tr>";
        ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
        ut += "</tr>";
    }
    ut += "</table>";
}

function skrivUt(){
    document.getElementById("personregister").innerHTML = ut;
}