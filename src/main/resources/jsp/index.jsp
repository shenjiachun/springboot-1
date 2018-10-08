<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function send(){
        $.post("demo_test.html",function(data,status){
            alert("Data: " + data + "nStatus: " + status);
        });
    }

</script>
<body>
    <h1>欢迎${user.username }光临!请选择你的操作:</h1><br>
    <ul>
        <shiro:hasPermission name="add"><li>增加</li></shiro:hasPermission>
        <shiro:hasPermission name="delete"><li>删除</li></shiro:hasPermission>
        <shiro:hasPermission name="update"><li>修改</li></shiro:hasPermission>
        <shiro:hasPermission name="query"><li>查询</li></shiro:hasPermission>
    </ul>
    <button value="点击" onclick="send()"></button>
</body>
</html>