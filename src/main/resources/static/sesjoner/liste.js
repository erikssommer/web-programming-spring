import {apiSesjoner as api} from "../apiurl.js"

$(() => {  // kjøres når dokumentet er ferdig lastet
    hentAlle();

    $("#slettAlle").click(() => {
        $.get(api + "/slettAlle", () => {
            hentAlle();
        });
    });

    $("#loggUt").click(() => {
        $.get(api + "/loggUt", () => {
            window.location.href = "/sesjoner/index.html";
        });
    });
});

const hentAlle = () => {
    $.get(api + "/hentAlle", biler => {
        formaterData(biler);
    })
        .fail(jqXHR => {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

const formaterData = biler => {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th><th></th><th></th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td>" +
            "<td> <button class='btn btn-primary' id='" + bil.id + "'>Endre</button></td>" +
            "<td> <button class='btn btn-danger' id='" + bil.personnr + "'>Slett</button></td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#bilene").html(ut);

    addEventListeners(biler);
}

const addEventListeners = biler => {
    for (const {personnr, id} of biler) {
        $("#" + personnr).on("click", () => slettEnMotorvogn(personnr));
        $("#" + id).on("click", () => idTilEndring(id));
    }
}

const idTilEndring = id => {
    window.location.href = "/sesjoner/endre.html?" + id;
}

const slettEnMotorvogn = personnr => {
    const url = "/slettEnMotorvogn?personnr=" + personnr;
    $.get(api + url, () => {
        window.location.href = "/sesjoner/liste.html";
    });
}
