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
      <li class="li"><a href="AdminListServlet">首页</a></li>
      <li class="li"><a href="RoomListServlet">宿舍信息</a></li>
      <li class="li"><a href="JiaoGongNewServlet">教工信息</a></li>
      <li class="li"><a href="BookingServlet">预定信息</a></li>
      <li class="li"><a href="Admin_login.jsp">退出登录</a></li>
    </ul>
  </div>

</div>
<div class="right-bigBox">
  <div class="right-box1">
    <div class="border" id="information">


      <div id="data-list">
        <h2>教工搜索结果</h2>

        <% List<Jiaogong> jiaogongList = (List<Jiaogong>) request.getAttribute("jiaogongList");
          if (jiaogongList != null && !jiaogongList.isEmpty()) { %>


        <table border="1" style="width:1200px ;border-collapse: collapse;">
          <tr>
            <th>教工号</th>
            <th>名字</th>
            <th>性别</th>
            <th>宿舍号</th>
            <th>联系电话</th>
            <th>账号</th>
            <th>密码</th>
          </tr>
          <% for (Jiaogong jiaogong : jiaogongList) { %>
          <tr>
            <td><%= jiaogong.getJid() %></td>
            <td><%= jiaogong.getName() %></td>
            <td><%= jiaogong.getSex() %></td>
            <td><%= jiaogong.getSid() %></td>
            <td><%= jiaogong.getPhone() %></td>
            <td><%= jiaogong.getAccount() %></td>
            <td><%= jiaogong.getPassword() %></td>
          </tr>
          <% } %>
        </table>
        <% } else { %>
        <p>No results found for SID <%= request.getParameter("searchInput") %>.</p>
        <% } %>
      </div>




    </div>
  </div>
</div>
</body>
</html>






