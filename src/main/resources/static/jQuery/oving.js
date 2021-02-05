const liste = [];

$(function () {
    $("#knapp").click(function () {
        $("#melding").html("<h2>Hallo " + $("#inn").val() + "</h2>");
    });

    $("#inn").change(function () {
        $("#navn").text($("#inn").val());
    })

    $("#beregn").click(function () {
        liste.push(lagObjekt("Erik", 22, "Male"));

        for (let person of liste) {
            console.log(person.navn + " " + person.alder + " " + person.kjonn);
        }
    })
});

function lagObjekt(navn, alder, kjonn) {
    return {
        navn,
        alder,
        kjonn
    };
}