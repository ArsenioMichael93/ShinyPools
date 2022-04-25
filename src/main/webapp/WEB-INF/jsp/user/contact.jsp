<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp"/>

<section id="contact">



    <div class="contact-wrapper" id="newfrost" style="margin-top: 50px">

        <!-- Left contact page -->

        <form id="contact-form" class="form-horizontal" role="form">

            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" id="name" placeholder="NAME" name="name" value="" required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <input type="email" class="form-control" id="email" placeholder="EMAIL" name="email" value="" required>
                </div>
            </div>

            <textarea class="form-control" rows="10" placeholder="MESSAGE" name="message" required></textarea>

            <button class="btn btn-primary send-button" id="submit" type="submit" value="SEND">
                <div class="alt-send-button">
                    <i class="fa fa-paper-plane"></i><span class="send-text">SEND</span>
                </div>

            </button>

        </form>

        <!-- Left contact page -->

        <div class="direct-contact-container" >

            <ul class="contact-list" >
                <li class="list-item" style="font-weight: bolder; color: black "><i class="fa fa-map-marker fa-2x"><span class="contact-text place" style="font-weight: bolder; color: black ">Chelmsford, Massachusetts</span></i></li>

                <li class="list-item" style="font-weight: bolder; color: black "><i class="fa fa-phone fa-2x"><span class="contact-text phone"><a href="tel:1-212-555-5555" title="Give me a call" style="font-weight: bolder; color: black ">(555) 555-5555</a></span></i></li>

                <li class="list-item" style="font-weight: bolder; color: black "><i class="fa fa-envelope fa-2x"><span class="contact-text gmail" ><a href="mailto:#" title="Send me an email" style="font-weight: bolder; color: black ">ShinyPools@gmail.com</a></span></i></li>

            </ul>

            <hr>
            <ul class="social-media-list">
                <li><a href="https://www.facebook.com/shinypools4u" target="_blank" class="contact-icon">
                    <i class="fa fa-facebook" aria-hidden="true"></i></a>
                </li>

            </ul>
            <hr>

            <div class="copyright">&copy; ALL OF THE RIGHTS RESERVED</div>

        </div>

    </div>

</section>



<jsp:include page="../include/footer.jsp"/>