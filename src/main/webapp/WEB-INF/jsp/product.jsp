<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="include/header.jsp"/>

<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test2">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home"
                            type="button"
                            role="tab" aria-controls="home" aria-selected="true">Add Product
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile"
                            type="button"
                            role="tab" aria-controls="profile" aria-selected="false">Delete Product
                    </button>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <h1>Product Add</h1>

                    <form action="/product/productSubmit" method="get">
                        <table>
                            <tr>
                                <td align="right" style="text-align: left"> Name :</td>
                                <td align="left"><input type="text" name="productName" value="${form.productName}"></td>
                            </tr>
                            <tr>
                                <td align="right" style="text-align: left">Description :</td>
                                <td align="left"><input type="text" name="description" value="${form.description}"></td>

                            <tr>
                                <td align="right" style="text-align: left">Image URL :</td>
                                <td align="left"><input type="text" name="imageURL" value="${form.imageURL}"></td>
                            </tr>
                            <tr>
                                <td align="right" style="text-align: left">Price :</td>
                                <td align="left"><input type="text" name="price" value="${form.price}"><button type="submit">Submit</button></td>
                            </tr>

                        </table>
                    </form>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <form action="/product/delete" method="GET">
                        <br>
                        <br>
                        Product To Delete :

                        <select name="productId" id="productId">
                            <c:forEach items="${products}" var="product">
                                <option value="${product.id}">${product.name}</option>
                            </c:forEach>
                        </select>

                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>


            <c:if test="${bindingResult.hasErrors()}">
                <br>

                <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </c:if>

        </div>
    </div>
</div>
<jsp:include page="include/footer.jsp"/>