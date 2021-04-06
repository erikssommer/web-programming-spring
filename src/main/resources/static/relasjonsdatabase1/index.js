import { apiRelasjonsdatabase1 as api} from "../apiurl.js"

$(() => {  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();
    hentAlle();

    $("#regMotorvogn").click(() => {
        const personnr = $("#personnr");
        const navn = $("#navn");
        const adresse = $("#adresse");
        const kjennetegn = $("#kjennetegn");
        const valgtMerke = $("#valgtMerke");
        const valgtType = $("#valgtType");

        const motorvogn = {
            personnr: personnr.val(),
            navn: navn.val(),
            adresse: adresse.val(),
            kjennetegn: kjennetegn.val(),
            merke: valgtMerke.val(),
            type: valgtType.val(),
        };

        $.post(api + "/lagre", motorvogn, () => hentAlle());

        personnr.val("");
        navn.val("");
        adresse.val("");
        kjennetegn.val("");
        valgtMerke.val("");
        valgtType.val("");
    });

    $("#slettAlle").click(() => {
        $.ajax(api + "/slettAlle", {
            type: 'DELETE',
            success: () => hentAlle(),
            error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
        });
    });
});

const hentAlleBiler = () => $.get(api + "/hentBiler", biler => formaterBiler(biler));

const formaterBiler = biler => {
    let ut = "<select id='valgtMerke' onchange='finnTyper()'>";
    let i = 0;
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
}

const finnTyper = () => {
    const valgtMerke = $("#valgtMerke").val();
    $.get(api + "/hentBiler", biler => formaterTyper(biler, valgtMerke))
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

const hentAlle = () => $.get(api + "/hentAlle", biler => formaterData(biler));

const formaterData = biler => {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th><th></th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td>" +
            "<td> <button class='btn btn-danger' onclick='slettEnMotorvogn(" + bil.personnr + ")'>Slett</button></td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#bilene").html(ut);
}

const slettEnMotorvogn = personnr => {
    const url = "/slettEnMotorvogn?personnr=" + personnr;
    $.ajax(api + url, {
        type: 'DELETE',
        success: () => window.location.href = "/relasjonsdatabase1/index.html",
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    });
}