$(function () {

    $('#sorting').change(function () {

        var param = location.search;
        var url = "/products/sort"
            + param
            + (param.indexOf("?") === -1 ? "?" : "&")
            + "sort=" + $('#sorting').val();

        location = url
    });

});


