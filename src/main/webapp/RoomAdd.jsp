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

    .left1-box {
      flex: 1; /* 左边占据1份空间 */
      padding: 10px;
      border-right: 1px solid #ccc; /* 左右分隔线 */
    }

    .right1-bigBox {
      flex: 2; /* 右边占据2份空间 */
      padding: 20px;
    }

    /* 右边的预定信息样式 */
    .room-info {
      margin-bottom: 20px;
    }

    .booking-info {
      background-color: #f0f0f0;
      padding: 10px;
      border-radius: 5px;
    }

    .form-group {
      margin-bottom: 15px;
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


  </style>

</head>

<body class="big-box" >

<div class="left-box">
  <div class="customer-box">
    <a href="#">欢迎</a><br>
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
  <div class="right1-bigBox">
    <h2>添加宿舍信息</h2>

    <div class="booking-info">

      <form action="RoomAddServlet" method="get">
        <div class="booking-info">
          <div class="form-group">

            <div class="form-group">
              <label>楼号:</label>
              <input type="text" name="floor" placeholder="请输入楼号" required>
            </div>
            <div class="form-group">
              <label>宿舍号:</label>
              <input type="text" name="sid" placeholder="请输入宿舍号" required>
            </div>
            <div class="form-group">
              <label>向阳/背光:</label>
              <input type="text" name="features1" placeholder="请输入选择宿舍类型向阳/背光" required>
            </div>
            <div class="form-group">
              <label>双人/单人:</label>
              <input type="text" name="features2" placeholder="请输入选择宿舍类型双人/单人" required>
            </div>
            <div class="form-group">
              <label>有人/无人:</label>
              <input type="text"  name="state" placeholder="请输入选择宿舍有人/无人" required>
            </div>

          </div>
        </div>
        <div class="btn-group">
          <button type="submit">确定添加</button>
        </div>
      </form>

    </div>

  </div>
</div>
</body>
</html>