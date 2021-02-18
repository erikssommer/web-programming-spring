$(() => {
    $("#last").click(() => {
        $.post(apiKlinetTjener1 + "/load", (data, status) => {
            console.log(status)
            if (status === "success") {
                alert("Valutaene er lastet");
            } else {
                alert("Noe gikk galt, se consollen")
            }
        });
    });
});