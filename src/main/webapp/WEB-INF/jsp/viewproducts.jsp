<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="include/header.jsp"/>


<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test4">


            <table class="table">
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${productsKey}" var="product">
                    <option value="${product.id}"></option>
                    <tr scope="row">

                        <td><img src="../../../pub/img/${product.imageUrl}" style="height: 100px; width: 100px;"
                                 alt=""></td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <%--<td><a href="/AddCart/${product.id}">Add to Cart</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp" />