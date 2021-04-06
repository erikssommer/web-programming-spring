import { apiKlinetTjener1 as api} from "../apiurl.js"

$(() => {
    $("#last").click(() => {
        $.post(api + "/load", (data, status) => {
            console.log(status)
            if (status === "success") {
                alert("Valutaene er lastet");
            } else {
                alert("Noe gikk galt, se consollen")
            }
        });
    });
});