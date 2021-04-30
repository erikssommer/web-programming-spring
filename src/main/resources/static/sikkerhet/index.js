import validering from "./validering.js"
import {apiSikkerhet as api} from "../apiurl.js"

$(() => {
    $("#loggInn").click(() => {
        if (validering.loginn()) {
            const url = "/loggInn?brukernavn=" + $("#brukernavn").val() + "&passord=" + $("#passord").val();
            $.get(api + url, OK => {
                if (OK) {
                    window.location.href = "/sikkerhet/liste.html";
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

    $("#registrer").click(() => {
        window.location.href = "/sikkerhet/nybruker.html";
    });

    $("#krypterAllePassord").click(() => {
        $.get(api + "/krypterAllePassord", OK => {
            if (OK) {
                $("#feil").html("Kryptering utført!");
            } else {
                $("#feil").html("Feil i kryptering!");
            }
        })
            .fail(jqXHR => {
                const json = $.parseJSON(jqXHR.responseText);
                $("#feil").html(json.message);
            });
    });

    $("#brukernavn").on("change", () => validering.brukernavn());
    $("#passord").on("change", () => validering.passord());
});