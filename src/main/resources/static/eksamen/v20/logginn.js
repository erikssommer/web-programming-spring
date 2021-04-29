$(() => {
    $("#loggInn").click(() => {
        const info = {
            epost: $("#e-post").val(),
            passord: $("#passord").val()
        }

        if (validerBrukernavn(info.epost) && validerPassord(info.passord)) {
            $.post("/api/eksamen/v20/logginn", info, OK => {
                $("#loggetInn").html("Verifisering gikk fint")
            })
        }
    })
})

const validerBrukernavn = brukernavn => {
    const regexp = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}/;
    const ok = regexp.test(brukernavn);
    if (!ok) {
        $("#loggetInn").html("Navnet må bestå av 2 til 20 bokstaver");
        return false;
    } else {
        $("#loggetInn").html("");
        return true;
    }
}

const validerPassord = passord => {
    const regexp = /(?=.*[A-ZÆØÅa-zæøå])(?=.*\d)[A-ZÆØÅa-zæøå\d]{6,}/;
    const ok = regexp.test(passord);
    if (!ok) {
        $("#loggetInn").html("Passordet må være minimum 8 tegn, minst en bokstav og et tall");
        return false;
    } else {
        $("#loggetInn").html("");
        return true;
    }
}