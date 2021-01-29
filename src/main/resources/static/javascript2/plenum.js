function visPersonRegister(){
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

    liste.push(person1, person2);

    let ut = "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    for (let person of liste){
        ut += "<tr>";
        ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
        ut += "</tr>";
    }
    ut += "</table>";

    //document.getElementById("personregister").innerHTML = ut;

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

    //sorterNavn();

    function sorterNavn(){
        for (let i = 0; i < liste.length; i++){
            for (let j = i+1; j < liste.length; j++){
                if (liste[i].navn > liste[j].navn){
                    let tmp = liste[i].navn;
                    liste[i].navn = liste[j].navn;
                    liste[j].navn = tmp;
                }
            }
        }

        ut += "<br /><br />";
        ut += "Sortert liste med egen algoritme: <br />";
        ut += "<table><tr>" +
            "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
            "</tr>";

        for (let person of liste){
            ut += "<tr>";
            ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
            ut += "</tr>";
        }
        ut += "</table>";

        document.getElementById("personregister").innerHTML = ut;
    }

    ut += "<br /><br />";
    ut += "Usortert liste: <br />";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    for (let person of liste){
        ut += "<tr>";
        ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
        ut += "</tr>";
    }
    ut += "</table>";

    const sorterListe = liste.sort(compare);

    function compare(a, b){
        if (a.navn < b.navn){
            return -1;
        }
        if (a.navn > b.navn){
            return 1;
        }
        return 0;
    }

    ut += "<br /><br />";
    ut += "Sortert liste: <br />";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    for (let person of sorterListe){
        ut += "<tr>";
        ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
        ut += "</tr>";
    }
    ut += "</table>";

    //document.getElementById("personregister").innerHTML = ut;

    ut += "<br /><br />";
    ut += "Annenhver sort: <br />";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
        "</tr>";

    let teller = 0;
    for (let person of sorterListe){
        if (teller % 2 === 0){
            ut += "<tr>";
            ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" + person.telefonnr + "</td>";
            ut += "</tr>";
        }else {
            ut += "<tr>";
            ut += "<td><strong>"+person.navn + "</strong></td><td><strong>" + person.adresse +
                "</strong></td><td><strong>" + person.telefonnr + "</strong></td>";
            ut += "</tr>";
        }
        teller++;
    }
    ut += "</table>";

    //document.getElementById("personregister").innerHTML = ut;

    sorterListe[0].fnr = 12985678843;
    sorterListe[1].fnr = 89872387438;
    sorterListe[2].fnr = 66793980327;
    sorterListe[3].fnr = 24462417652;
    sorterListe[4].fnr = 43628976963;

    ut += "<br /><br />";
    ut += "Menn med fet skrift: <br />";
    ut += "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefonnr</th><th>Fødselsnummer</th>" +
        "</tr>";

    for (let person of sorterListe){
        if (person.fnr.toString()[8] % 2 === 0){
            ut += "<tr>";
            ut += "<td>" + person.navn + "</td><td>" + person.adresse + "</td><td>" +
                person.telefonnr + "</td><td>"+ person.fnr + "</td>";
            ut += "</tr>";
        } else {
            ut += "<tr>";
            ut += "<td><strong>"+person.navn + "</strong></td><td><strong>" + person.adresse +
                "</strong></td><td><strong>" + person.telefonnr + "</strong></td><td><strong>" +
                person.fnr + "</strong></td>";
            ut += "</tr>";
        }
    }
    ut += "</table>";

    document.getElementById("personregister").innerHTML = ut;

}