<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>
<!-- Header End====================================================================== -->
<div id="mainBody">
    <div class="container">
        <hr class="soften">
        <h1>Visit us</h1>
        <hr class="soften"/>
        <div class="row">
            <div class="span4">
                <h4>Contact Details</h4>
                <p> вулиця Смоленська, 31/33,<br/> Київ, 02000
                    <br/><br/>
                    myflora@itea.ua<br/>
                    ﻿Tel +38 (050) 599 4663<br/>
                    ﻿Tel +38 (050) 599 4663<br/>
                    web:myflora.herokuapp.com
                </p>
            </div>

            <div class="span4">
                <h4>Opening Hours</h4>
                <h5> Monday - Friday</h5>
                <p>09:00am - 09:00pm<br/><br/></p>
                <h5>Saturday</h5>
                <p>09:00am - 07:00pm<br/><br/></p>
                <h5>Sunday</h5>
                <p>12:30pm - 06:00pm<br/><br/></p>
            </div>
            <div class="span4">
                <h4>Email Us</h4>
                <form class="form-horizontal">
                    <fieldset>
                        <div class="control-group">

                            <input type="text" placeholder="name" class="input-xlarge"/>

                        </div>
                        <div class="control-group">

                            <input type="text" placeholder="email" class="input-xlarge"/>

                        </div>
                        <div class="control-group">

                            <input type="text" placeholder="subject" class="input-xlarge"/>

                        </div>
                        <div class="control-group">
                            <textarea rows="3" id="textarea" class="input-xlarge"></textarea>

                        </div>

                        <button class="btn btn-large" type="submit">Send Messages</button>

                    </fieldset>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="span12">
                <iframe
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2540.4616256838444!2d30.443190315790503!3d50.45112797947554!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cc2508bb8547%3A0xb15ba5c3a4a0c8e8!2sSmolenska+St%2C+31%2F33%2C+Kyiv%2C+Ukraine!5e0!3m2!1sen!2suk!4v1501625077323"
                        width="100%" height="300" frameborder="0" style="border:0" allowfullscreen>
                </iframe>
            </div>
        </div>
    </div>
</div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>
