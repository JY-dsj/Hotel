
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
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
      background-image: url("blackground1.jpg");
    }

    .big-box{
      height: 150%;
      display: flex;
      background-size: 100% 100%;
      background-image: url("blackground1.jpg");
    }
    .right-bigBox{
      text-align: center;
    }

    table{
      background-color: rgba(255, 255, 255, 0.4); /* 白色背景，绝对透明度 */
    }
    td ,tr{
      text-align:center;
      color: #333333;
      height: 60px;
    }
  </style>

</head>

<body class="big-box" background="blackground1.jpg">
<div class="left-box">
  <div class="customer-box">
    <a href="#">个人信息</a><br>
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
  <h1>修改后的信息</h1>
  <table border="1" style="width:1200px ;border-collapse: collapse;" >
    <tbody>

    <tr>
      <th>教工号</th>
      <th>名字</th>
      <th>性别</th>
      <th>宿舍号</th>
      <th>联系电话</th>
      <th>账号</th>
      <th>密码</th>
    </tr>

    <tr>

      <td>${jid}</td>

      <td>${name}</td>

      <td>${sex}</td>

      <td>${sid}</td>

      <td>${phone}</td>

      <td>${account}</td>

      <td>${password}</td>
    </tr>
    </tbody>
  </table>

</div>

</body>

</html>
