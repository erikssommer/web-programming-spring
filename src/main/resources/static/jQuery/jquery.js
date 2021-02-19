$(function () {
    //Oppgave 1
    $("#printInfo").click(function () {
        const navn = $("#navn").val();
        const alder = $("#alder").val();
        const output = $("#output");
        if (!(alder > 0)) {
            alert("Du må skrive inn en alder større enn 0!");
        } else {
            output.html("Hei, " + navn + ". Du er " + alder + " år gammel.")
        }
    });

    //Oppgave 2
    $("#fahrenheit").change(function (){
        const c = (5 / 9) * (Number($("#fahrenheit").val()) - 32);
        const el = $("#celsius");
        el.val(c);
    });

    $("#celsius").change(function (){
        const f = (9 / 5) * Number($("#celsius").val()) + 32;
        const el = $("#fahrenheit");
        el.val(f);
    })

    //Oppgave 3
    $("#pluss").click(function () {
        const in_1 = Number($("#in_1").val());
        const in_2 = Number($("#in_2").val());
        const output = $("#kalk-output");
        if (isNaN(in_1) || isNaN(in_2)) {
            alert("Feil tallformat, prøv igjen.");
        } else {
            output.html(in_1 + in_2);
        }
    });

    $("#minus").click(function () {
        const in_1 = Number($("#in_1").val());
        const in_2 = Number($("#in_2").val());
        const output = $("#kalk-output");
        if (isNaN(in_1) || isNaN(in_2)) {
            alert("Feil tallformat, prøv igjen.");
        } else {
            output.html(in_1 - in_2);
        }
    });

    $("#gange").click(function () {
        const in_1 = Number($("#in_1").val());
        const in_2 = Number($("#in_2").val());
        const output = $("#kalk-output");
        if (isNaN(in_1) || isNaN(in_2)) {
            alert("Feil tallformat, prøv igjen.");
        } else {
            output.html(in_1 * in_2);
        }
    });

    $("#dele").click(function () {
        const in_1 = Number($("#in_1").val());
        const in_2 = Number($("#in_2").val());
        const output = $("#kalk-output");
        if (isNaN(in_1) || isNaN(in_2)) {
            alert("Feil tallformat, prøv igjen.");
        } else {
            output.html(in_1 / in_2);
        }
    });

    //Oppgave 4
    const personRegister = [];

    $("#registrer").click(function () {
        const navn = $("#objNavn").val();
        const adresse = $("#objAdresse").val();
        const telefonnr = $("#objTelefonnr").val();

        const person = {
            navn: navn,
            adresse: adresse,
            telefonnr: telefonnr
        };

        personRegister.push(person);

        //nullstill inputboksene
        $('input').val('');

        visPersonRegister()
    });

    function visPersonRegister() {

        let ut = "<table><tr>" +
            "<th>Navn</th><th>Adresse</th><th>Telefonnr</th>" +
            "</tr>";

        for (let p of personRegister) {
            ut += "<tr>";
            ut += "<td>" + p.navn + "</td><td>" + p.adresse + "</td><td>" + p.telefonnr + "</td>";
            ut += "</tr>";
        }
        $("#personRegister").html(ut);
    }

    //Oppgave 5
    $("#skrivInn").change(function (){
        let ut;
        ut = "<li>"
        ut += "<input type='checkbox'>"
        ut += "<span>" + $("#skrivInn").val() + "</span>"
        ut += "</li>";

        $("#gjoremol").append(ut);
        $("input").val('');
    });

    //Oppgave 6
    let uferdig= $("#uferdig");
    let ferdig = $("#ferdig");
    let skrivInn2 = $("#skrivInn2");

    let id = 0;

    $("#skrivInn2").change(function (){
        //Inkrementer id
        id++;
        let ut;
        ut = '<li id="rad-' + id + '">'
        ut += '<input id="sjekkboks-' + id + '" type="checkbox" onchange="veksleStatus(' + id + ')">'
        ut += "<span>" + skrivInn2.val() + "</span>"
        ut += "</li>"

        //Tøm skriv inn feltet
        skrivInn2.val('');

        //Print gjøremål til tabell
        uferdig.append(ut);

        function veksleStatus(id) {
            //Hent raden og sjekkboksen basert på id'en
            const sjekkbox = $("#sjekkboks-" + id);
            const rad = $("#rad-" + id);

            //Flytt raden avhengig av om sjekkboksen er sjekket
            if (sjekkbox.is(':checked')) {
                rad.css({'text-decoration': 'line-through'});
                ferdig.append(rad);
            } else {
                rad.css({'text-decoration': 'none'});
                uferdig.append(rad);
            }
        }
    });

    //Oppgave 7
    const liste = $("#liste"); //document.getElementById('liste')
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

    $("#skrivUtOppgaver").click(function (){
        let ut = "";
        let id = 0;
        let oppgaveIndex = 0;
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
        ut += '<button id="sjekkSvar">Sjekk svar</button>'
        liste.html(ut);

        $("#sjekkSvar").click(function (){
            let riktigeSvar = 0;
            for(let oppgaveIndex = 0; oppgaveIndex < oppgaver.length; oppgaveIndex++) {
                const radioKnapper = document.querySelectorAll('[name="oppgave-' + oppgaveIndex + '"]');
                let svar;
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
            liste.html('');
            alert(riktigeSvar + " av " + oppgaver.length + " oppgaver er riktige");
        });

        function sjekkOmRiktig(oppgaveIndex, svar) {
            const oppgave = oppgaver[oppgaveIndex];
            return oppgave.riktigIndex === oppgave.alternativer.indexOf(svar);
        }
    });
});