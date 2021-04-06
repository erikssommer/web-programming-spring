import { apiKlinetTjener1 as api} from "../apiurl.js"

$(() => {
    $("#beregn").click(() => {
        const maned = $("#maned").val();

        $.get(api + "/hentTemp?mnd=" + maned, temp => {
            if (temp !== 0) {
                $("#melding").html("Det var en gjennomsnittstemperatur " +
                    " på " + temp + " grader i " + maned);
            } else {
                $("#melding").html("Du har oppgitt ugyldig månedsnavn");
            }
        });
    });
});