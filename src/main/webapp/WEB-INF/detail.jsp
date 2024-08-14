<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>detail.html</title>
<style>
.content {
	margin: auto;
	width: 80%;
	padding: 20px;
	border: 1px solid lightgray;
	border-radius: 10px;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<div class="nav-bar">
		<div class="w3-bar w3-red w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
				href="javascript:void(0);" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home"
				class="w3-bar-item w3-button w3-padding-large w3-hover-white">Home</a>
			<a href="list"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-white">의뢰하기</a>
			<a href="partner"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">파트너</a>
			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green w3-right">회원님
				안녕하세요</a>
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
		</div>
	</div>


	<div class="content">
		<h2>의뢰 상세 내용</h2>
		<p>여기에서 해당 의뢰의 ID를 기반으로 상세 내용을 보여줍니다.</p>
		<p>예시: 작업유형, 작성자, 작업주소, 작업날짜, 의뢰내용 등</p>

		<!-- JavaScript to parse the query string and display the details based on the ID -->
		<script>
			const urlParams = new URLSearchParams(window.location.search);
			const id = urlParams.get('inquiryId');

			if (id) {
				document.write("<h3>의뢰 번호: " + inquirtId + "</h3>");
				document.write("<p>작업유형: 예초</p>"); // You can dynamically generate content based on the ID
				document.write("<p>작성자: 홍길동</p>");
				document.write("<p>작업주소: 서울시 강남구</p>");
				document.write("<p>작업날짜: 2024-01-24</p>");
				document.write("<p>의뢰내용: 이곳에 의뢰 내용을 표시합니다.</p>");
			} else {
				document.write("<p>유효한 의뢰 ID가 제공되지 않았습니다.</p>");
			}
		</script>
	</div>

</body>
</html>