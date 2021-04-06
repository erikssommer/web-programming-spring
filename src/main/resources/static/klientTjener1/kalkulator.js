import { apiKlinetTjener1 as api} from "../apiurl.js"

$(() => {
    const tall1 = $("#tall1");
    const tall2 = $("#tall2");

    $("#pluss").click(() => {
        if (inputvalidering(tall1.val(), tall2.val())) {
            $.get(api + "/pluss?tall1=" + tall1.val() + "&tall2=" + tall2.val(), sum => {
                $("#output").html(tall1.val() + " + " + $("#tall2").val() + " = " + sum);
            });
        } else {
            $("#output").html("Du har ikke oppgitt to tall");
        }
    });

    $("#minus").click(() => {
        if (inputvalidering(tall1.val(), tall2.val())) {
            $.get(api + "/minus?tall1=" + tall1.val() + "&tall2=" + tall2.val(), sum => {
                $("#output").html(tall1.val() + " - " + $("#tall2").val() + " = " + sum);
            });
        } else {
            $("#output").html("Du har ikke oppgitt to tall");
        }
    });

    $("#gange").click(() => {
        if (inputvalidering(tall1.val(), tall2.val())) {
            $.get(api + "/gange?tall1=" + tall1.val() + "&tall2=" + tall2.val(), sum => {
                $("#output").html(tall1.val() + " * " + $("#tall2").val() + " = " + sum);
            });
        } else {
            $("#output").html("Du har ikke oppgitt to tall");
        }
    });

    $("#dele").click(() => {
        if (tall2.val() === "0") {
            $("#output").html("Du kan ikke dele på 0");
        } else if (inputvalidering(tall1.val(), tall2.val())) {
            $.get(api + "/dele?tall1=" + tall1.val() + "&tall2=" + tall2.val(), sum => {
                $("#output").html(tall1.val() + " / " + $("#tall2").val() + " = " + sum);
            });
        } else {
            $("#output").html("Du har ikke oppgitt to tall");
        }
    });

    const inputvalidering = (tall1, tall2) => {
        return !(isNaN(tall1) || isNaN(tall2) || tall1 === "" || tall2 === "");
    }
});