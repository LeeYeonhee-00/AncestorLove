<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Partner Detail</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif;
}

.header-container {
	padding-top: 20px;
}

.partner-detail-container {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 20px;
	border-bottom: 1px solid #ccc;
	margin-top: 60px;
}

.partner-info {
	max-width: 60%;
}

.partner-info h2 {
	margin-bottom: 10px;
}

.partner-info p {
	margin: 5px 0;
}

.partner-photo {
	max-width: 30%;
	text-align: center;
}

.partner-photo img {
	width: 150px;
	height: 150px;
	border-radius: 50%;
}

.reviews-section {
	padding: 20px;
}

.review {
	display: flex;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #eee;
}

.review img {
	width: 40px;
	height: 40px;
	border-radius: 50%;
	margin-right: 10px;
}

.review p {
	flex: 1;
}

.review .stars, .review .date {
	margin-left: 10px;
	text-align: right;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-red w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
				href="javascript:void(0);" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home"
				class="w3-bar-item w3-button w3-padding-large w3-white">Home</a> <a
				href="write"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">의뢰하기</a>
			<a href="partner"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">파트너</a>
			<a href="login.html"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">로그인</a>
		</div>
	</div>

	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
		<a href="inquiry.html" class="w3-bar-item w3-button w3-padding-large">의뢰하기</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
	</div>

	<!-- Partner Detail Section -->
	<div class="partner-detail-container">
		<div class="partner-info">
			<h1>
				<b>파트너 이름</b>
			</h1>
			<p>작업 지역 : 경기도 00시 00구</p>
			<p>평당 금액 : 000원</p>
			<p>분묘 금액 : 000원</p>
			<p>파트너 설명 : 어쩌구 저쩌구</p>
		</div>
		<div class="partner-photo">
			<h3>사장 사진</h3>
			<img src="images/boss.jpg" alt="사장 사진">
		</div>
	</div>

	<!-- Reviews Section -->
	<div class="reviews-section">
		<h3>후기</h3>
		<div class="review">
			<img src="images/profile.jpg" alt="프로필 사진">
			<p>아 좀 실망이네요</p>
			<div class="stars">★☆☆☆☆</div>
			<div class="date">2024.08.09</div>
		</div>
		<div class="review">
			<img src="images/profile.jpg" alt="프로필 사진">
			<p>아주 대만족 합니다</p>
			<div class="stars">★★★★★</div>
			<div class="date">2024.08.09</div>
		</div>
	</div>


</body>
</html>