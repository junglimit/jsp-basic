<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<%--
<%
    String name = (String) request.getAttribute("name");
    String crew = (String) request.getAttribute("crew");
%>
--%>
    <h1>댄서 등록 결과페이지 입니다.</h1>
    <h2>${d.getName()}님(소속:${d.getCrewName()})이 정상 등록되었습니다</h2>
    <h2>댄스 수준: ${d.getDanceLevel()}</h2>
    <a href="/chap04/dancer/form">새로운 댄서 등록하러 가기</a> <br>
    <a href="/chap04/show-list">댄서 목록 조회하기</a> <br>

</body>
</html>