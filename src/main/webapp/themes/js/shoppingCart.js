$(function () {

    $('.icon-minus').each(function () {
        $(this).parent().click(
            function () {
                minus($(this).parent());
            });
    });
    $('.icon-plus').each(function () {
        $(this).parent().click(
            function () {
                plus($(this).parent());
            });
    });
    $('.icon-remove').each(function () {
        $(this).parent().click(
            function () {
                remove($(this).parent());
            });
    });

    $('#order').click(
        function (e) {
            e.preventDefault();
            createOrder();
        });

});


function plus(element) {

    var tr = $(element).closest('tr');

    var productQuantity = $(tr).find('.productQuantity');
    var productPrice = $(tr).find('.productPrice');
    var productDiscount = $(tr).find('.productDiscount');
    var productTotalAmount = $(tr).find('.productTotalAmount');

    var quantity = parseFloat(productQuantity.val()) + 1;
    if (quantity < 0) {
        quantity = 0;
    }
    productQuantity.val(quantity);

    var discount = 0;
    if (quantity >= 10) {
        discount = 5;
    }
    productDiscount.text(discount);
    var price = parseFloat(productPrice.text());
    productTotalAmount.text((quantity * price) - (quantity * price * discount / 100));
    recountShoppingCart();
}

function minus(element) {

    var tr = $(element).closest('tr');

    var productQuantity = $(tr).find('.productQuantity');
    var productPrice = $(tr).find('.productPrice');
    var productDiscount = $(tr).find('.productDiscount');
    var productTotalAmount = $(tr).find('.productTotalAmount');

    var quantity = parseFloat(productQuantity.val()) - 1;
    if (quantity < 0) {
        quantity = 0;
    }
    productQuantity.val(quantity);

    var discount = 5;
    if (quantity < 10) {
        discount = 0;
    }
    productDiscount.text(discount);
    var price = parseFloat(productPrice.text());
    productTotalAmount.text((quantity * price) - (quantity * price * discount / 100));
    recountShoppingCart();
}

function remove(element) {

    var tr = $(element).closest('tr');
    tr.remove();
    recountShoppingCart();
}

function recountShoppingCart() {

    var productsTotalAmount = 0;
    $('.productTotalAmount').each(function () {
        productsTotalAmount += parseFloat($(this).text());
    })
    $('#productsTotalAmount').text(productsTotalAmount);

    var cartDelivery = 0;

    if (productsTotalAmount < 1000 && productsTotalAmount != 0) {
        cartDelivery = 50.0;
    }
    $('#cartDelivery').text(cartDelivery);

    $('#cartTotalAmount').text(productsTotalAmount + cartDelivery);
}

function createOrder() {

    var cartTotalAmount = parseInt($('#cartTotalAmount').text()) * 100;
    var url = "/order?totalAmount=" + cartTotalAmount;
    location = url;
}

