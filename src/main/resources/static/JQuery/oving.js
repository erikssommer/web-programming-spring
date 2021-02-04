$(function () {
    $("#knapp").click(function () {
        $("#melding").html("<h2>Hallo " + $("#inn").val() + "</h2>");
    });

    $("#inn").change(function () {
        $("#navn").text($("#inn").val());
    })
});