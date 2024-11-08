<%--
  Created by IntelliJ IDEA.
  User: 2022
  Date: 2024/6/19
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>管理员登录</title>
  <link type="text/css" rel="stylesheet" href="css/Admin.css">
  <style>
    html {
      height: 100%;
      width: 100%;
      overflow: hidden;
      margin: 0;
      padding: 0;
      background: url(blackground1.jpg) no-repeat 0px 0px;
      background-size: 100% 100%;
      -moz-background-size: 100% 100%;
    }
  </style>
</head>

<body>

<%
  request.setCharacterEncoding("utf-8");
  response.setContentType("text/html; charset=UTF-8");
  //获取登录操作转发的信息
  Object error = request.getAttribute("error");
%>

<div id="loginDiv">
  <form  method="post" action="AdminServlet" id="form">
    <h1 id="loginMsg">管理员登录</h1>
    <div class="mag" style="display:inline-block;"><a href="user_login.jsp">用户登录</a></div>
    <div id = "errorMsg"></div>
    <p>用户名:<input id="account" name="account" type="text"></p>

    <p>密码: <input id="password" name="password" type="password"></p>

    <div id="subDiv">
      <input type="reset" class="button" value="重置">
      <input type="submit" class="button" value="登录">&nbsp;&nbsp;&nbsp;
    </div>
  </form>
</div>



<%-- 显示错误信息 --%>
<th>
<td align="center"><font color="red"><%=(error == null ? "" : error)%></font></td>
</th>

</body>
</html>
