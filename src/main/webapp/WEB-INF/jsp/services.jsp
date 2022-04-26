<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test4">
            <h1 style="text-align: center">Openings</h1>
            <br><br>

            <h4 style="margin-left: 10px; margin-right: 10px;">Your pool opening can set the standard for your summer fun! The last thing
                anyone wants to do is spend their spring battling their green pool.
                Allow Shiny Pools to bring the solution to your pool and busy life. We don't
                even require that you be at home. All we need is access to an outdoor source of water
                and power to your pool filter equipment. A Shiny Pools opening includes:
            </h4>
            <br>
            <br>


            <table class="table table-hover " style="left: auto !IMPORTANT; font-weight: bolder">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                <c:forEach
                        items="${serviceKey}" var="services">
                    <tr scope="row">
                        <td>${services.name}</td>
                        <td>${services.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


<jsp:include page="include/footer.jsp"/>