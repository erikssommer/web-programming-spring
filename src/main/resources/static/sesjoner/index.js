import {apiSesjoner as api} from "../apiurl.js"
import validering from "./validering.js"

$(() => {
    $("#loggInn").click(() => {
        if (validering.loginn()) {
            const url = "/loggInn?brukernavn=" + $("#brukernavn").val() + "&passord=" + $("#passord").val();
            $.get(api + url, OK => {
                if (OK) {
                    window.location.href = "/sesjoner/liste.html";
                } else {
                    $("#feil").html("Feil i brukernavn eller passord");
                }
            })
                .fail(jqXHR => {
                    const json = $.parseJSON(jqXHR.responseText);
                    $("#feil").html(json.message);
                });
        }
    });

    $("#brukernavn").on("change", () => validering.brukernavn());
    $("#passord").on("change", () => validering.passord());
});
