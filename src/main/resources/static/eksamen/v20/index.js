$(() => {
    $("#registrer").click(() => {
        const skiloper = {
            fornavn: $("#fornavn").val(),
            etternavn: $("#etternavn").val(),
            klubb: $("#klubb").val(),
            epost: $("#e-post").val(),
            passord: $("#passord").val()
        }

        $.post("/langrenn", skiloper, OK => {
            if (OK) {
                skrivUt();
            } else {
                $("#feil").html("Feil i insetting i database")
            }
        })
    })
})

const skrivUt = () => {
    // Kalle på databasen for aa få tak i data lagret og formatere det ut.
}