<%@ page import="bean.SState" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.SState" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>预定界面</title>
  <link href="css/header.css" rel="stylesheet">

  <style>

    body, html {
      margin: 0; /* 移除默认边距 */
      padding: 0; /* 移除默认内边距 */
      width: 100%; /* 宽度100% */
      height: 100%; /* 高度100% */
      overflow: hidden; /* 隐藏超出内容，可选，根据实际需求调整 */
    }
    .big-box{
      height: 150%;
      display: flex;
      background-size: 100% 100%;
      background-image: url("blackground1.jpg");}



    table {
      width: 50%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
    }
    .form-group input,
    .form-group textarea {
      width: 100%;
      padding: 10px;
      box-sizing: border-box;
    }
.aaa{
  text-align: center;
  font-size:100px;
  font-weight: bold;
  font-style:normal;
  color:red;
  margin-top: 250px;
}

  </style>

</head>

<body class="big-box" >

<div class="left-box">
  <div class="customer-box">
    <a href="#">欢迎</a><br>
  </div>


  <div class="list-box">

    <ul>
      <li class="li"><a href="UserHeaderServlet">首页</a></li>
      <li class="li"><a href="MyselfNewServlet">个人信息</a></li>
      <li class="li"><a href="UserBooking.jsp">预定</a></li>
      <li class="li"><a href="Admin_login.jsp">退出登录</a></li>
    </ul>
  </div>

</div>
<div class="right-bigBox">

<p class="aaa">恭喜你！预约成功</p>
</div>

</body>
</html>
