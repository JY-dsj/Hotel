<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link type="text/css" rel="stylesheet" href="css/register.css">
    <style>
        html {
            height: 100%;
            width: 100%;
            overflow: hidden;
            margin: 0;
            padding: 0;
            background: url(blackground1.jpg) no-repeat 0px 0px;
            background-repeat: no-repeat;
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

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="user_login.jsp" class="log">登录</a>
    </div>
    <form id="reg-form" action="RegisterServlet" method="post">

        <table>

            <tr>
                <td class="big">教工号</td>
                <td class="inputs">
                    <input name="jid" type="text" id="jid">
                    <br>
                    <span id="jid_err" class="jid_msg">${register_msg}</span>

                </td>

            </tr>

            <tr>
                <td class="big">姓名</td>
                <td class="inputs">
                    <input name="name" type="text" id="name">
                    <br>
                    <span id="name_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>

            <tr>
                <td class="big">性别</td>
                <td class="gender">
                    <input type="radio" name="gender" id="nan" value="男"> <label for="nan" class="nan">男</label>
                    <input type="radio" name="gender" id="nv" value="女"> <label for="nv">女</label>
                </td>
            </tr>

            <tr>
                <td class="big">宿舍号</td>
                <td class="inputs">
                    <input name="sid" type="text" id="sid">
                    <br>
                    <span id="sid_err" class="err_msg" style="display: none">宿舍号格式有误</span>
                </td>
            </tr>

            <tr>
                <td class="big">联系电话</td>
                <td class="inputs">
                    <input name="telephone" type="text" id="telephone">
                    <br>
                    <span id="telephone_err" class="err_msg" style="display: none">电话号格式有误</span>
                </td>
            </tr>




            <tr>
                <td class="big">账号</td>
                <td class="inputs">
                    <input name="account" type="text" id="account">
                    <br>
                    <span id="account_err" class="err_msg" style="display: none">账号格式有误</span>
                </td>
            </tr>

            <tr>
                <td class="big">密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>
            <tr>
                <td class="big">验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/login/CheckCode">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>

<%-- 显示错误信息 --%>
<th>
<td align="center"><font color="red"><%=(error == null ? "" : error)%></font></td>
</th>

<%--
<script>
    /**
     * 验证码功能
     */
    //  给看不清添加点击事件
    document.getElementById("changeImg").onclick = function(){
        document.getElementById("checkCodeImg").src = "/login/CheckCode?"+ new Date().getMilliseconds();
    }
    // 给图片添加点击事件
    document.getElementById("checkCodeImg").onclick = function(){
        this.src = "/login/CheckCode?"+new Date().getMilliseconds();
    }

</script>
--%>

</body>

</html>

