
<%@ page import="java.util.List" %>
<%@ page import="bean.Jiaogong" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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

    .border{
      position: relative;
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

    .search-container {
      display: flex;
      align-items: center;
      max-width: 800px; /* 容器最大宽度 */
      margin: 20px auto;
    }

    #search-input {
      width: 600px; /* 搜索框的具体长度 */
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px 0 0 4px;
      font-size: 16px;
    }

    #search-button {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 0 4px 4px 0;
      cursor: pointer;
    }
    #search-button1 {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 0 4px 4px 0;
      cursor: pointer;
    }
    #search-button:hover {
      background-color: #45a049;
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
    <p class="identity">管理员</p>
    <a href="#">欢迎登录</a><br>
  </div>
  <div class="list-box">
    <ul>
      <li class="li"><a href="AdminListServlet">首页</a></li>
      <li class="li"><a href="AdminListServlet">宿舍信息</a></li>
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
      <div class="search-container">
          <form action="JiaogongSearchServlet" method="GET">
            <input type="text" id="search-input" placeholder="请输入关键词" name="searchInput">
            <button type="submit" id="search-button" >搜索</button>
          </form>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="UserAdd.jsp" id="search-button1">添加</a>
      </div>

      <%
        // 获取用户列表
        List<Jiaogong> jiaogongs = (List<Jiaogong>) request.getAttribute("jiaogongs");

        // 调试输出，
        if (jiaogongs != null) {
          System .out.println("Jiaogong count: " + jiaogongs.size());
        } else {
          System .out.println("Jiaogong list is null.");
        }
      %>


      <h3>教工信息</h3>
      <table border="1" style="width:1200px ;border-collapse: collapse;" >
        <thead>
        <tr>
          <th>教工号</th>
          <th>名字</th>
          <th>性别</th>
          <th>宿舍号</th>
          <th>联系电话</th>
          <th>账号</th>
          <th>密码</th>
        </tr>
        </thead>
        <tbody>
        <%
          // 循环显示用户列表
          if (jiaogongs != null) {
            for (Jiaogong jiaogong : jiaogongs) {
        %>
        <tr>
          <td><%= jiaogong.getJid() %></td>
          <td><%= jiaogong.getName() %></td>
          <td><%= jiaogong.getSex() %></td>
          <td><%= jiaogong.getSid() %></td>
          <td><%= jiaogong.getPhone() %></td>
          <td><%= jiaogong.getAccount() %></td>
          <td><%= jiaogong.getPassword() %></td>
          <td>
            <a href="UserEditServlet?jid=<%= jiaogong.getJid()%>">修改</a>
          </td>
          <td>
            <a href="UserDeleteServlet?jid=<%= jiaogong.getJid()%>">删除</a>
          </td>
        </tr>
        <%
          }
        } else {
        %>
        <tr>
          <td colspan="7">No users found.</td>
        </tr>
        <%
          }
        %>
        </tbody>

      </table>

      </div>

    </div>
  </div>
</div>

</body>

<script>
  // 获取数据列表和数据容器
  const dataList = document.getElementById('data-list');
  const dataContainer = document.getElementById('data-container');

  // 添加滚轮事件监听器
  dataContainer.addEventListener('scroll', function() {
    // 检测是否滚动到了容器底部
    if (dataContainer.scrollTop + dataContainer.clientHeight >= dataContainer.scrollHeight) {
      // 加载更多数据
      appendMoreData();
    }
  });

  // 模拟加载更多数据的函数
  function appendMoreData() {
    // 在实际应用中，这里可以是异步加载数据的操作，例如使用 AJAX 请求获取数据
    // 这里用setTimeout模拟异步加载
    setTimeout(function() {
      const newDataItem = document.createElement('li');
      newDataItem.textContent = 'New Data Item'; // 替换为实际的数据

      dataList.appendChild(newDataItem); // 将新数据项添加到列表中
    }, 1000); // 假设异步加载需要1秒钟
  }
</script>

</html>

