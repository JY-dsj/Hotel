<%@ page import="bean.Jiaogong" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link href="css/header.css" rel="stylesheet">
  <!--    <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>-->
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

    .border{
      position: relative;
    }

    table{
      background-color: rgba(255, 255, 255, 0.4); /* 白色背景，绝对透明度 */
    }
    td ,tr{
      text-align:center;
      color: #333333;
      height: 60px;
    }
    #information {
      height: 800px; /* 定义容器的高度 */
      overflow-y: auto; /* 允许垂直滚动 */
      border: 1px solid #ccc; /* 边框样式 */
      padding: 10px; /* 内边距 */
    }

  </style>


</head>

<body class="big-box" background="blackground1.jpg">
<div class="left-box">
  <div class="customer-box">
    <a href="#">欢迎登录</a><br>
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
  <div class="right-box1">
    <div class="border" id="information">
      <div id="data-list">


        <h2>修改前信息</h2>
        <form action="MyselfUpdateServlet" method="POST">
          <input type="hidden" name="jid" value="${jid}"> <!-- 隐藏字段用于传递 jid -->
          <table>
            <tr>
              <td>教工号:</td>
              <td><input type="text" name="jid" value="${jid}"></td>
            </tr>
            <tr>
              <td>姓名:</td>
              <td><input type="text" name="name" value="${name}"></td>
            </tr>
            <tr>
              <td>性别:</td>
              <td><input type="text" name="sex" value="${sex}"></td>
            </tr>
            <tr>
              <td>宿舍号:</td>
              <td><input type="text" name="sid" value="${sid}"></td>
            </tr>
            <tr>
              <td>联系电话:</td>
              <td><input type="text" name="phone" value="${phone}"></td>
            </tr>
            <tr>
              <td>账号:</td>
              <td><input type="text" name="account" value="${account}"></td>
            </tr>
            <tr>
              <td>密码:</td>
              <td><input type="text" name="password" value="${password}"></td>
            </tr>
            <tr>
              <td><input type="submit" value="提交"></td>
            </tr>
          </table>
        </form>
      </div>

    </div>
  </div>
</div>
</body>
</html>

