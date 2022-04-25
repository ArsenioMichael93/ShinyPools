<jsp:include page="../include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test2">

        <form action="/login/loginSubmit" method="POST">

            <h1>Please Log In Here</h1>

            <table>
                <tr>
                    <td align="right" style="text-align: left">Username :</td>
                    <td align="left"><input type="text" name="username"></td>
                </tr>

                <tr>
                    <td align="right" style="text-align: left">Password :</td>
                    <td align="left"><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td align="right"></td>
                    <td align="center"><button type="submit">Submit</button>
                        </tr>
            </table>
        </form>
    </div>
</div>
</div>


<jsp:include page="../include/footer.jsp"/>