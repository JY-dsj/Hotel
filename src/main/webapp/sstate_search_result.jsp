<%@ page import="bean.SState" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>搜索结果</title>
  <style>
    table {
      border-collapse: collapse;
      width: 50%;
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
  </style>
</head>
<body>
<div id="data-list">

  <h2>搜索结果</h2>
  <% List<SState> sStateList = (List<SState>) request.getAttribute("sStateList");
    if (sStateList != null && !sStateList.isEmpty()) { %>
  <table border="1" style="width:1200px ;border-collapse: collapse;">
    <tr>
      <th>宿舍楼</th>
      <th>宿舍号</th>
      <th>向阳/背光</th>
      <th>双人/四人</th>
      <th>有人/无人</th>
    </tr>
    <% for (SState sState : sStateList) { %>
    <tr>
      <td><%= sState.getFloor() %></td>
      <td><%= sState.getSid() %></td>
      <td><%= sState.getFeatures1() %></td>
      <td><%= sState.getFeatures2() %></td>
      <td><%= sState.getState() %></td>
    </tr>
    <% } %>
  </table>
  <% } else { %>
  <p>No results found for SID <%= request.getParameter("searchInput") %>.</p>
  <% } %>
</div>

</body>
</html>
