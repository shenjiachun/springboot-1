<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎登录!${user.username }</h1>
    <form action="${pageContext.request.contextPath }/loginUser" method="post">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="提交">
</form>
</body>
</html>