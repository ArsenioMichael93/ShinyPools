<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div style="align-self: center; text-align: center;">

        <h1>Search</h1>

        <br>
        <form action="/user/search" method="GET">
            First Name : <input type="text" name="firstName" value="${firstName}">
            <button type="submit">Submit</button>
        </form>

        <br>

        <c:if test="${not empty firstName}">
            <h5>Search Results Found ${usersModelKey.size()}</h5>
            <br>
        </c:if>


        <table class="table">
            <tr scope="row">
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${usersModelKey}" var="user">
                <tr scope="row">
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td><a href="/user/edit/${user.id}">Edit</a></td>
                    <td><a href="/user/delete/${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>