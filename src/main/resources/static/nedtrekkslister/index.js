let biltyper = []
let personnr, navn, adresse, kjennetegn, merke, type

$(() => {
    personnr = $("#personnr");
    navn = $("#navn");
    adresse = $("#adresse");
    kjennetegn = $("#kjennetegn");

    $("#regMotorvogn").click(() => {
        registrerMotorvogn()
    });

    $("#slettAlle").click(() => {
        api.slettMotorvogner()
    });

    api.hentBilmerker()
    api.hentMotorvogner()
});

/* Snakker med api'en */
const api = {
    hentMotorvogner: () => $.get(apiNedtrekkslister + "/motor", motorvogner => formater(motorvogner)),
    opprettMotorvogn: motorvogn => $.post(apiNedtrekkslister + "/motor", motorvogn, () => api.hentMotorvogner()),
    slettMotorvogner: () => $.ajax(apiNedtrekkslister + "/motor", {
        type: 'DELETE',
        success: () => api.hentMotorvogner(),
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    }),
    hentBilmerker: () => $.get(apiNedtrekkslister + "/bil", biler => fyllInnBilmerker(biler))
}

const registrerMotorvogn = () => {
    merke = $("#valgtMerke");
    type = $("#valgtType");

    const motorvogn = {
        personnr: personnr.val(),
        navn: navn.val(),
        adresse: adresse.val(),
        kjennetegn: kjennetegn.val(),
        merke: merke.val(),
        type: type.val()
    };

    if (inputval(motorvogn)) {
        api.opprettMotorvogn(motorvogn)
        resetFelter()
    } else {
        console.log("Mangler input");
    }
}

const inputval = motorvogn => {
    if (motorvogn.personnr === "") return false
    else if (motorvogn.navn === "") return false
    else if (motorvogn.adresse === "") return false
    else if (motorvogn.kjennetegn === "") return false
    else if (motorvogn.merke === "") return false
    else return motorvogn.type !== "";
}

const resetFelter = () => {
    personnr.val("");
    navn.val("");
    adresse.val("");
    kjennetegn.val("");
    merke.val("");
    type.val("");
}

const fyllInnBilmodeller = () => {
    const valgtMerke = $("#valgtMerke").val()
    const filtrerteBiler = biltyper.filter((bil) => bil.merke === valgtMerke)

    let ut = `
    <select id="valgtType" class="form-control">
        ${filtrerteBiler.map(bil => `<option>${bil.type}</option>`)}
    </select>
    `

    $("#type").html(ut)
}

const fyllInnBilmerker = biler => {
    biltyper = biler
    let unikeMerker =  biler.map(bil => bil.merke).filter((merke, index, array) => array.indexOf(merke) === index)

    // her kan vi gjøre det mer avansert med å bruke event listeners, men det er et tema for en senere dag.
    let ut = `
    <select id="valgtMerke" onclick="fyllInnBilmodeller()" class="form-control">
        ${unikeMerker.map(merke => `<option>${merke}</option>`)}
    </select>
    `
    $("#merke").html(ut)
}

const formater = motorvogner => {
    let ut = `
    <table class="table table-striped">
        <tr>
            <th>Personnr</th>
            <th>Navn</th>
            <th>Adresse</th>
            <th>Kjennetegn</th>
            <th>Merke</th>
            <th>Type</th>
        </tr>
        ${motorvogner.map(motorvogn => {
        return `
            <tr>
                <td>${motorvogn.personnr}</td>
                <td>${motorvogn.navn}</td>
                <td>${motorvogn.adresse}</td>
                <td>${motorvogn.kjennetegn}</td>
                <td>${motorvogn.merke}</td>
                <td>${motorvogn.type}</td>
            </tr>`
    })}
    </table>
    `
    $("#bilene").html(ut);
}