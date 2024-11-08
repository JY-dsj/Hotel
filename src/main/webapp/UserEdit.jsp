
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
        .right-bigBox{
            text-align: center;
        }
        .big-box{
            height: 150%;
            display: flex;
            background-size: 100% 100%;
            background-image: url("blackground1.jpg");
        }


        table{
            background-color: rgba(255, 255, 255, 0.4); /* 白色背景，绝对透明度 */
        }
        td ,tr{
            text-align:center;
            color: #333333;
            height: 60px;
        }
        input{

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
            <li class="li"><a href="RoomListServlet">宿舍信息</a></li>
            <li class="li"><a href="JiaoGongNewServlet">教工信息</a></li>
            <li class="li"><a href="BookingServlet">预定信息</a></li>
            <li class="li"><a href="Admin_login.jsp">退出登录</a></li>
        </ul>
    </div>

</div>
<div class="right-bigBox">

<h2>修改前信息</h2>
            <form action="UserUpdateServlet" method="POST">
                <input type="hidden" name="jid" value="${jid}"> <!-- 隐藏字段用于传递 jid -->
                <table border="1" style="width:1200px ;border-collapse: collapse;" >

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
                        <td><input type="text" style="height: 35px"  name="jid" value="${jid}"></td>

                        <td><input type="text" style="height: 35px"  name="name" value="${name}"></td>

                        <td><input type="text" style="height: 35px"  name="sex" value="${sex}"></td>

                        <td><input type="text" style="height: 35px"  name="sid" value="${sid}"></td>

                        <td><input type="text" style="height: 35px"  name="phone" value="${phone}"></td>

                        <td><input type="text" style="height: 35px"  name="account" value="${account}"></td>

                        <td><input type="text" style="height: 35px"  name="password" value="${password}"></td>

                    <td><input type="submit" value="提交"></td>
                    </tr>
                </table>
            </form>
</div>

</body>

</html>