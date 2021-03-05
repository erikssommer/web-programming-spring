$(() => {
    $("#regMotorvogn").click(() => {
        const personnr = $("#personnr");
        const navn = $("#navn");
        const adresse = $("#adresse");
        const kjennetegn = $("#kjennetegn");
        const merke = $("#merke");
        const type = $("#type");

        const motorvogn = {
            personnr: personnr.val(),
            navn: navn.val(),
            adresse: adresse.val(),
            kjennetegn: kjennetegn.val(),
            merke: merke.val(),
            type: type.val()
        };

        if (inputval(motorvogn)) {
            $.post(apiLagringServer + "/motor", motorvogn, () => hent());
            /*
            $.post("/lagre", motorvogn, function (){
                $.get("/hentAlle", function (biler) {
                    formater(biler);
                });
            });
             */
            personnr.val("");
            navn.val("");
            adresse.val("");
            kjennetegn.val("");
            merke.val("");
            type.val("");
        } else {
            console.log("Mangler input");
        }
    });

    $("#slettAlle").click(() => {
        $.ajax({
            url: apiLagringServer + "/motor",
            type: "DELETE",
            success: () => hent()
        });
    });
});

const hent = () => $.get(apiLagringServer + "/motor", biler => formater(biler));

const inputval = motorvogn => {
    if (motorvogn.personnr === "") return false
    else if (motorvogn.navn === "") return false
    else if (motorvogn.adresse === "") return false
    else if (motorvogn.kjennetegn === "") return false
    else if (motorvogn.merke === "") return false
    else return motorvogn.type !== "";
}

const formater = biler => {
    let ut = "<table><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";

    for (let bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td></tr>";
    }

    ut += "</table>";

    $("#bilene").html(ut);
}















