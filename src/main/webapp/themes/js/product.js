$(function () {

    $('#sorting').change(function () {
        var parameter = location.href.substring("?");

        location = "/products/sort" + location.search + "&sort=" + $('#sorting').val();

    });

});


