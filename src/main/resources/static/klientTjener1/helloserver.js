$(function () {
    $("#call").click(function () {
        const url = "/helloserver?name=" + $("#name").val();

        $.get(url, function (data) {
            $("#hello").html(data);
        });
    });
});
