<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="include/header.jsp" />

<h1>Conversation</h1>

<form action="/conversation/conversationSubmit" method="get">

    Name : <input type="text" name="productName" value="${form.productName}">

    <br>
    Description : <input type="text" name="description" value="${form.description}">
    <br>
    Image URL : <input type="text" name="imageURL" value="${form.imageURL}">
    <br>
    Price : <input type="text" name="price" value="${form.price}">

    <button type="submit">Submit</button>
</form>

<c:if test="${bindingResult.hasErrors()}">
    <br>

    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
</c:if>


<jsp:include page="include/footer.jsp" />