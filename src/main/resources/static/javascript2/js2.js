function visPersonRegister() {
    const personregister = [];

    const person1 = {
        navn: "Åge Pedersen",
        adresse: "Å 22",
        telefonnr: "29439232"
    }

    const person2 = {
        navn: "Ole Olsen",
        adresse: "Trondheimsvegen 22",
        telefonnr: "56789357"
    }

    const person3 = {
        navn: "Erik Sommer",
        adresse: "Lillehammer 22",
        telefonnr: "6582384"
    }

    const person4 = {
        navn: "Amalie Bakken",
        adresse: "Bærum 23",
        telefonnr: "56789357"
    }

    const person5 = {
        navn: "Line Nilsen",
        adresse: "Osloveien 22",
        telefonnr: "43565872"
    }

    personregister.push(person1, person2, person3, person4, person5);

    for (let person of personregister) {
        console.log(person.navn + " " + person.adresse + " " + person.telefonnr);
    }

    console.log("");

    function compare(a, b) {
        if (a.navn < b.navn) {
            return -1;
        }

        if (a.navn > b.navn) {
            return 1;
        }
        return 0;
    }

    const sortertListe = personregister.sort(compare);

    for (let person of sortertListe) {
        console.log(person.navn + " " + person.adresse + " " + person.telefonnr);
    }

    console.log("");

    // Egen algoritme for sortering basert på navn. O(n^2) -> lite effektiv når listen med navn blir større.
    // Vokser eksponensielt
    for (let i = 0; i < personregister.length; i++) {
        for (let j = i + 1; j < personregister.length; j++) {
            if (personregister[i].navn > personregister[j].navn) {
                let tmp = personregister[i].navn;
                personregister[i].navn = personregister[j].navn;
                personregister[j].navn = tmp;
            }
        }
    }

    for (let person of personregister) {
        console.log(person.navn + " " + person.adresse + " " + person.telefonnr);
    }

    console.log("");

    const regpersonnr = [];

    const personnr1 = {
        navn: "Line Nilsen",
        adresse: "Osloveien 22",
        telefonnr: "43565872",
        personnr: "23049858435"
    }

    const personnr2 = {
        navn: "Ole Olsen",
        adresse: "Trondheimsvegen 22",
        telefonnr: "56789357",
        personnr: "12096654762"
    }

    regpersonnr.push(personnr1, personnr2);

    for (let person of regpersonnr){
        if (person.personnr[8] % 2 === 0){
            console.log("Jente: " + person.navn + " " + person.adresse + " " + person.telefonnr);
        }
    }

}