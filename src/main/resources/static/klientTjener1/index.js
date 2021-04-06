import { apiKlinetTjener1 as api} from "../apiurl.js"

$(() => {
    $("#hentBelop").click(() => {
        const sort = $("#sort").val();
        const verdi = $("#verdi").val();

        const belop = {
            sort: sort,
            verdi: verdi
        }

        $.get(api + "/beregnKurs", belop, nok => {
            if (nok !== 0.0) {
                const melding = verdi + " i " + sort + " blir: " + nok + "kr";
                $("#valuta").html(melding);
            } else {
                $("#valuta").html("Du skrev inn ugyldig valutasort");
            }
        });
    });
});