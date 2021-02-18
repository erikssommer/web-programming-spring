const apiUrl = "/api/klienttjener1";

$(() => {
    $("#beregn").click(() => {
        const maned = $("#maned").val();

        $.get(apiUrl + "/hentTemp?mnd=" + maned, temp => {
            if (temp !== 0) {
                $("#melding").html("Det var en gjennomsnittstemperatur " +
                    " på " + temp + " grader i " + maned);
            } else {
                $("#melding").html("Du har oppgitt ugyldig månedsnavn");
            }
        });
    });
});