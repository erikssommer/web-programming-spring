const apiUrl = "/api/klienttjener1";

$(() => {
    $("#last").click(() => {
        $.post(apiUrl + "/load", (data, status) => {
            console.log(status)
            if (status === "success") {
                alert("Valutaene er lastet");
            } else {
                alert("Noe gikk galt, se consollen")
            }
        });
    });
});