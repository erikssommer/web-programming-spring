import validering from "./validering.js"
import {apiSikkerhet as api} from "../apiurl.js"

$(() => {
    $("#registrer").click(() => {
        const brukernavn = $("#brukernavn").val();
        const passord = $("#passord").val();

        const kunde = {
            brukernavn: brukernavn,
            passord: passord
        }

        if (validering.loginn()) {
            $.post(api + "/nybruker", kunde, () => {
                const url = "/loggInn?brukernavn=" + $("#brukernavn").val() + "&passord=" + $("#passord").val();
                $.get(api + url, OK => {
                    if (OK) {
                        window.location.href = "/sikkerhet/liste.html";
                    } else {
                        $("#feil").html("Feil i brukernavn eller passord");
                    }
                }).fail(jqXHR => {
                    const json = $.parseJSON(jqXHR.responseText);
                    $("#feil").html(json.message);
                });
            }).fail(jqXHR => {
                const json = $.parseJSON(jqXHR.responseText);
                $("#feil").html(json.message);
            });
        }
    });
});