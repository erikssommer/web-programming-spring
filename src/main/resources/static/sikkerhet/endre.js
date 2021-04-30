import validering from "./validering.js"
import {apiSikkerhet as api} from "../apiurl.js"

$(() => {  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();
    henteEnMotorvogn();

    $("#endreMotorvogn").click(() => {
        const motorvogn = {
            id: $("#id").val(),
            personnr: $("#personnr").val(),
            navn: $("#navn").val(),
            adresse: $("#adresse").val(),
            kjennetegn: $("#kjennetegn").val(),
            merke: $("#valgtMerke").val(),
            type: $("#valgtType").val(),
        };

        if (validering.ingenfeil()) {
            $.post(api + "/endre", motorvogn, () => {
                window.location.href = "/sikkerhet/liste.html";
            })
                .fail(jqXHR => {
                    const json = $.parseJSON(jqXHR.responseText);
                    $("#feil").html(json.message);
                });
        }
    })

    $("#personnr").on("change", () => validering.personnr());
    $("#navn").on("change", () => validering.navn());
    $("#adresse").on("change", () => validering.adresse());
    $("#kjennetegn").on("change", () => validering.kjennetegn());

});

const hentAlleBiler = () => {
    $.get(api + "/hentBiler", biler => {
        formaterBiler(biler);
    })
        .fail(jqXHR => {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

const formaterBiler = biler => {
    $("#valgtMerke").off();
    let ut = "<select id='valgtMerke'>";
    let forrigeMerke = "";
    ut += "<option>Velg merke</option>";
    for (const bil of biler) {
        if (bil.merke !== forrigeMerke) {
            ut += "<option>" + bil.merke + "</option>";
        }
        forrigeMerke = bil.merke;
    }
    ut += "</select>";
    $("#merke").html(ut);

    addEventListeners(biler);
}

const addEventListeners = biler => {
    for (const bil of biler) $("#valgtMerke").on("change", () => finnTyper());
}

const finnTyper = () => {
    const valgtMerke = $("#valgtMerke").val();
    $("#feilMerke").html("");
    $.get(api + "/hentBiler", biler => {
        formaterTyper(biler, valgtMerke);
    })
        .fail(jqXHR => {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

const formaterTyper = (biler, valgtMerke) => {
    let ut = "<select id='valgtType'>";
    for (const bil of biler) {
        if (bil.merke === valgtMerke) {
            ut += "<option>" + bil.type + "</option>";
        }
    }
    ut += "</select>";
    $("#type").html(ut);
}

const henteEnMotorvogn = () => {
    const id = window.location.search.substring(1); // kommer fra kallet i index.js
    const url = "/henteEnMotorvogn?id=" + id;
    $.get(api + url, enMotorVogn => {
        // overfør til input-feltene i skjemaet
        $("#id").val(enMotorVogn.id); // må ha med denne for å vite hvilken id
        $("#personnr").val(enMotorVogn.personnr);
        $("#navn").val(enMotorVogn.navn);
        $("#adresse").val(enMotorVogn.adresse);
        $("#kjennetegn").val(enMotorVogn.kjennetegn);
        $("#merke").val(enMotorVogn.merke);
        $("#type").val(enMotorVogn.type);
    })
        .fail(jqXHR => {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}


