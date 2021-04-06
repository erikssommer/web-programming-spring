$(() => {
    $("#call").click(() => {
        const url = "/helloserver?name=" + $("#name").val();

        $.get(url, data => $("#hello").html(data));
    });
});
