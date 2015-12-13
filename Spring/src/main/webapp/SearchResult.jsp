<%--
  Created by IntelliJ IDEA.
  User: shirlies
  Date: 15-5-14
  Time: 下午4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<p>这是搜索到的电影集合</p>
<br/>
<table>
  <tr><td>电影id</td><td>电影名字</td><td>电影首映时间</td><td>电影描述</td><td>导演</td><td>语言</td><td>时长</td></tr>
  <c:forEach var="movies" items="${findMovies}">
    <tr>
      <td><c:out value="${movies.id}"></c:out></td>
      <td><c:out value="${movies.name}"></c:out></td>
      <td><c:out value="${movies.time}"></c:out></td>
      <td><c:out value="${movies.description}"></c:out></td>
      <td><c:out value="${movies.director}"></c:out></td>
      <td><c:out value="${movies.language}"></c:out></td>
      <td><c:out value="${movies.mLong}"></c:out></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
