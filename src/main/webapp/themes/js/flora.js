/* carousel of home page animation */
$(function () {
    $('#myCarousel').carousel({
        interval: 4000
    })
    $('#featured').carousel({
        interval: 4000
    })
    $(function () {
        $('#gallery a').lightBox();
    });
})

/* sidebar */
$(function () {

    $('.subMenu > a').click(function (e) {
        e.preventDefault();
        var subMenu = $(this).siblings('ul');
        var li = $(this).parents('li');
        var subMenus = $('#sidebar li.subMenu ul');
        var subMenus_parents = $('#sidebar li.subMenu');
        if (li.hasClass('open')) {
            if (($(window).width() > 768) || ($(window).width() < 479)) {
                subMenu.slideUp();
            } else {
                subMenu.fadeOut(250);
            }
            li.removeClass('open');
        } else {
            if (($(window).width() > 768) || ($(window).width() < 479)) {
                subMenus.slideUp();
                subMenu.slideDown();
            } else {
                subMenus.fadeOut(250);
                subMenu.fadeIn(250);
            }
            subMenus_parents.removeClass('open');
            li.addClass('open');
        }
    });


    var ul = $('#sidebar > ul');

    $('#sidebar > a').click(function (e) {
        e.preventDefault();
        var sidebar = $('#sidebar');
        if (sidebar.hasClass('open')) {
            sidebar.removeClass('open');
            ul.slideUp(250);
        } else {
            sidebar.addClass('open');
            ul.slideDown(250);
        }
    });

});

/* add to cart */
function getProductJson(element) {

    var product = new Object();
    product.id = $(element).find('.product .productId').text();
    product.name = $(element).find('.icon-shopping-cart .product .productName').text();
    product.price = $(element).find('.icon-shopping-cart .product .productPrice').text();

    return JSON.stringify(product);
}


function sendProductToCart(url, productJson) {
    $.ajax({
        type: "post",
        url: url,
        data: {product: productJson},
        dataType: "json",
        success: function (data) {
            alert("Product added to cart");
            $(".totalAmountCart").text(data.totalAmount / 100);
            $(".totalItemsCart").text(data.totalItems);
        },
        error: function (jqxhr, status, errorMsg) {
            alert("Error: " + errorMsg);
        },
        complete: function () {
        }
    });
}

$(function () {

    $('.icon-shopping-cart').each(function () {
        $(this).parent().click(
            function (e) {
                e.preventDefault();
                sendProductToCart("/addProductToCart", getProductJson($(this)));
            });
    });

});