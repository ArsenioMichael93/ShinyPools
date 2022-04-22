<jsp:include page="../include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div id="test3" style="align-self: center; text-align: center;">

        <form action="/login/loginSubmit" method="POST">

            <h1>Please Log In Here</h1>

            Username : <input type="text" name="username">
            <br>
            <br>
            Password : <input type="text" name="password">
            <br>
            <br>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>