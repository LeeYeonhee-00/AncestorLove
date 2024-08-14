<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>list.html</title>
<style>
    table {
        margin: auto;
        width: 800px; /* Width increased to accommodate new column */
        border-radius: 5px;
        border-collapse: collapse;
        border-top: none;
    }
    .header {
        background-color: rgb(218, 231, 255);
        text-align: center;
    }
    .table td, .table th {
        border-bottom: 1px lightgray solid; 
        height: 30px;
        font-size: 14px;
    }
    .num {
        width: 50px;
    }
    .title {
        width: 400px;
    }
    .type {
        width: 150px; /* New column for 작업종류 */
    }
    .body {
        text-align: center;
    }
    .body .title {
        text-align: left;
    }
    button {
        width: 100px;
        height: 40px;
        font-size: 15px;
        border: 0;
        outline: 1.5px rgb(68, 136, 244) solid;
        border-radius: 5px;
        padding-left: 10px;
        background-color: rgb(164, 199, 255);
    }
    button:active {
        width: 100px;
        height: 40px;
        font-size: 15px;
        border: 0;
        border-radius: 5px;
        outline: 1.5px rgb(27, 76, 155) solid;
        padding-left: 10px;
        background-color: rgb(68, 136, 244);
    }
</style>
</head>
<body>

<!-- Navbar -->
<div class="nav-bar">
  <div class="w3-bar w3-red w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="home" class="w3-bar-item w3-button w3-padding-large w3-hover-white">Home</a>
    <a href="list" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-white">의뢰하기</a>
    <a href="partner" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">파트너</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green w3-right">회원님 안녕하세요</a>
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
    <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
  </div>
</div>

<table class="table">
    <tr><td colspan="5"><h2>의뢰게시판</h2></td></tr>
    <tr class="header">
        <td class="num">번호</td>
        <td class="title">제목</td>
        <td class="type">작업종류</td> <!-- New header for 작업종류 -->
        <td>작성자</td>
        <td>작성날짜</td>
    </tr>
    <script>
        var i, day = 20;
        var types = ["예초", "벌초", "정원관리", "예초", "벌초", "정원관리", "예초", "벌초", "정원관리", "예초"];
        for (i = 1; i < 10; i++) {
            document.write("<tr class='body'>");
            document.write("<td>" + i +"</td>");
            document.write("<td class='title'><a href='detail?id=" + i + "'>제목입니다.</a></td>"); 
            document.write("<td class='type'>" + types[10-i] + "</td>"); // New data for 작업종류
            document.write("<td>작성자</td>"); 
            document.write("<td>24-01-" + day-- + "</td>");
            document.write("</tr>");
        }
       </script>
</table>
<br>
<table>
    <tr>
        <td><button onclick="location.href='/write'">글쓰기</button></td>
    </tr>
</table>
</body>
</html>