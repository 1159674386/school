<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link rel="stylesheet" type="text/css" href="css/Login.css"/>
  </head>
  
  <body>
    <div id="login">
        <h1>学员管理系统</h1><br>
        <h1>登陆</h1>
        <form action="userinfo_login.action" method="post">
            <input type="text" required="required" placeholder="用户名" name="uacc"></input>
            <input type="password" required="required" placeholder="密码" name="upwd"></input>
            <button class="but" type="submit">登录</button>
        </form>
    </div>
  </body>
</html>
