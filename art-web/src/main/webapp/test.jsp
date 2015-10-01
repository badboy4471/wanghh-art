<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
        <title>Admin Home Page</title>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/admin/art/file/upload.form" method="post"  enctype="multipart/form-data">
    	<input type="file" name="file"/>
    	<input type="submit" value="提交"/>
    </form>
     </body>

</html>