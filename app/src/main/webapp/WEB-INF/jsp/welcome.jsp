<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="./include/importTags.jsp" %>
<!DOCTYPE HTML>
<html>
    <body>
        <header class="business-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="display-3 text-center text-white mt-4 donttouch"><spring:message code="moto"/></h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <h2 class="mt-4"><spring:message code="whatwedo" /></h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis optio neque consectetur consequatur magni in nisi, natus beatae quidem quam odit commodi ducimus totam eum, alias, titi adipisci nesciunt voluptate. Voluptatum.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis optio neque consectetur consequatur magni in nisi, natus beatae quidem quam odit commodi ducimus totam eum, alias, titi adipisci nesciunt voluptate. Voluptatum.</p>
                </div>
                <div class="col-sm-4">
                    <h2 class="mt-4"><spring:message code="contactus"/></h2>
                    <address>
                        <strong><spring:message code="incorporationName"/></strong>
                        <br>3481 Some Place
                        <br>Some Address, CA 90810
                        <br>
                    </address>
                    <address>
                        <abbr title="Phone">P:</abbr>
                        (123) 456-7890
                        <br>
                        <abbr title="Email">E:</abbr>
                        <a href="mailto:contactus@java.com">contactus@java.com</a>
                    </address>
                </div>
            </div>
        </div>
    </body>
</html>