<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>
<!-- Header End====================================================================== -->
<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9" id="mainCol">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Delivery</li>
                </ul>
                <h3> Оплата і доставка </h3>
                <hr class="soft"/>

                <h4> Способи оплати </h4>
                <br/>

                <h5>Готівкою</h5>
                <p>
                    Оплата приймається виключно в гривнях. Оплата готівкою можлива при всіх способах
                    доставки і самовивозі. При отриманні замовлення ви отримаєте товарний чек і гарантійний
                    талон.
                    <br/>
                    Оплата замовлень дорожче 50 тис. гривень можлива тільки картою, за рахунком через банк
                    або на відділенні Перевізника (Згідно постанови НБУ №407 від 25/11/16)
                </p>
                <h5>
                    Оплата по безготівковому розрахунку з ПДВ
                </h5>
                <p>
                    Наша компанія є платником ПДВ. При отриманні замовлення, Ви отримаєте пакет необхідних
                    документів - рахунок-фактура, видаткова накладна, податкова накладна, гарантійні талони.
                    <br/>
                    Для отримання рахунку зробіть замовлення через сайт або зателефонуйте за номером вказаним на
                    сайті.
                </p>
                <h5>
                    Оплата по безготівковому розрахунку для фіз. осіб(фіз. осіб-підприємців)
                </h5>
                <p>
                    Оплата за нашим рахунком-фактурою (через касу будь-якого банку банківським переказом)
                </p>
                <br/>

                <h4>Способи доставки</h4>
                <br/>

                <h5>
                    Самовивіз із офіса
                </h5>
                <p>
                    Можливість самовивозу вказана на картці товару.
                    Оплата: при отриманні замовлення.
                    Дата видачі: 1-2 дні з дати замовлення (точна дата обов'язково вказана на картці товару і в кошику,
                    при оформленні замовлення).
                </p>
                <h5>
                    Кур'єром
                </h5>
                <p>
                    Вартість доставки вказана на картці товару і в кошику, при оформленні замовлення.
                    Оплата: при отриманні замовлення.
                    Термін доставки: 1-2 доби (точна дата вказана на картці товару і в кошику).
                </p>
            </div>
        </div>
    </div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>