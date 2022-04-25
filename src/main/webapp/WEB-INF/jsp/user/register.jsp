<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test2">
            <!-- rewrite this as a case statement using c:choose -->
            <c:if test="${empty form.id}">
                <h1>Sign Up</h1>
            </c:if>

            <c:if test="${not empty form.id}">
                <h1>Edit User</h1>
            </c:if>

            <form action="/user/registerSubmit" method="get">
                <input type="hidden" name="id" value="${form.id}">

                <table>
                    <tr>
                        <td align="right" style="text-align: left"> Email</td>
                        <td align="left"><input type="text" name="email" id="emailId" placeholder="Email@email.com"
                                                value="${form.email}">
                            <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left"> First Name</td>
                        <td align="left"><input type="text" name="firstName" id="firstNameId" placeholder="John"
                                                value="${form.firstName}">
                            <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Last Name</td>
                        <td align="left"><input type="text" name="lastName" id="lastNameId" placeholder="Barty"
                                                value="${form.lastName}">
                            <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Address</td>
                        <td align="left"><input type="text"
                                                name="confirmPassword" id="confirmPasswordId"
                                                placeholder="Password here...again"
                                                value="${form.confirmPassword}">
                            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Phone Number</td>
                        <td align="left"><input type="text"
                                                name="confirmPassword" id="confirmPasswordId"
                                                placeholder="Password here...again"
                                                value="${form.confirmPassword}">
                            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Password</td>
                        <td align="left"><input type="text" name="password" id="passwordId" placeholder="Password here"
                                                value="${form.password}">
                            <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Confirm Password</td>
                        <td align="left"><input type="text"
                                                name="confirmPassword" id="confirmPasswordId"
                                                placeholder="Password here...again" value="${form.confirmPassword}">
                            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td align="right" style="text-align: left">Check Box</td>
                        <td align="center"><input type="checkbox" name="checkbox"></td>
                    </tr>


                    <tr>
                        <td align="right"></td>
                        <td align="center">
                            <button type="submit">Submit</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>


        <c:if test="${bindingResult.hasErrors()}">
            <br>

            <c:forEach items="${bindingResult.getAllErrors()}" var="error">
                <div style="color:red;">${error.getDefaultMessage()}</div>
            </c:forEach>
        </c:if>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>

