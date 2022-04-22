<jsp:include page="include/header.jsp"/>
<div class="container" style="align-self: center; background-color: white" id="test">
    <div>
        <div id="test2">

            <h1>File Upload</h1>

            <form action="/upload" method="POST" enctype="multipart/form-data">

                Subject : <input type="text" name="subject"/>
                <br>
                Select File : <input type="file" name="file"/>
                <br>
                <input type="submit" value="Submit"/>

            </form>
        </div>
    </div>
</div>


<jsp:include page="include/footer.jsp"/>