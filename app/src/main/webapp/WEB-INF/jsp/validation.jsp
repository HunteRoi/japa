<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<body>
    <div class="full-center">
        <h1><spring:message code="proceedCheckout"/></h1>
        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="business"        value="business_merchant@hotmail.com">
            <input type="hidden" name="password"        value="EPGlSd0qDVL_qhhB98D7Vopq3OEOMnLzyoIgcgIQLl4dRfkvwEJjdHNO_NoABVduXz7xf20W93UH6yMv">
            <input type="hidden" name="cert_id"         value="ARhJ_3-YBAQHr2r4MhkdDR5TIURe1q2QLxuvFNs2zxruOSvgDbYBb8XhImoGv_E_KZlrVTHN-rXXrnty">

            <input type="hidden" name="amount"          value="${cart.getFormatedWithDiscountTotal()}">
            <input type="hidden" name="cmd"             value="_xclick">
            <input type="hidden" name="currency_code"   value="EUR">
            <input type="hidden" name="lc"              value="en_UK">

            <input type="hidden" name="return"          value='http://localhost:8082<spring:url value="/bought"/>'>
            <div style="text-align:center;">
                <input class="btn btn-primary ml-1" type="submit" name="submit" value='<spring:message code="yes"/>'>
                <a class="btn btn-primary" href='<spring:url value="/cart/checkout"/>'><spring:message code="no"/></a>
            </div>
        </form>
    </div>
</body>