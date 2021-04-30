import validering from "./validering.js"
import {apiSikkerhet as api} from "../apiurl.js"

$(() => {  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();

    $("#regMotorvogn").click(() => {
        const motorvogn = {
            personnr: $("#personnr").val(),
            navn: $("#navn").val(),
            adresse: $("#adresse").val(),
            kjennetegn: $("#kjennetegn").val(),
            merke: $("#valgtMerke").val(),
            type: $("#valgtType").val(),
        };

        if (validering.ingenfeil()) {
            $.post(api + "/lagre", motorvogn, () => {
                window.location.href = "/sikkerhet/liste.html";
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

    addEventListeners(biler)
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


