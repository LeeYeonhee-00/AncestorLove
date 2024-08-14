<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Partner List</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif;
}

.header-container {
	padding-top: 70px;
} /* Adjust this value if necessary */
.partner-card {
	border: 1px solid #ddd;
	border-radius: 5px;
	padding: 16px;
	text-align: center;
	margin-bottom: 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.partner-card img {
	width: 80%; /* Increase the image width */
	max-width: 250px; /* Limit the maximum width */
	height: auto; /* Maintain aspect ratio */
	margin-bottom: 20px;
	border-radius: 10px; /* Match the card's border radius */
}

.partner-card h3 {
	margin-bottom: 10px;
	text-align: center; /* Center align the text */
}

.partner-card p {
	margin: 5px 0;
	text-align: center; /* Center align the text */
}

.partner-card a {
	text-decoration: none;
	color: inherit;
}

.partner-card a:hover {
	text-decoration: underline;
	color: #0073e6; /* Optional: Change color on hover */
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
				href="home" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
			<a href="list"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">의뢰하기</a>
			<a href="partner"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">파트너</a>
			<a href="login.html"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green w3-right">로그인</a>
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link1</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
		</div>
	</div>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- Header -->
	<header id="PartnerList" class="header-container">
		<a href="#"><img src="/w3images/avatar_g2.jpg"
			style="width: 65px;"
			class="w3-circle w3-right w3-margin w3-hide-large w3-hover-opacity"></a>
		<span class="w3-button w3-hide-large w3-xxlarge w3-hover-text-grey"
			onclick="w3_open()"><i class="fa fa-bars"></i></span>
		<div class="w3-container">
			<h1>
				<b>제휴 파트너 리스트</b>
			</h1>
			<div class="w3-section w3-bottombar w3-padding-16">
				<span class="w3-margin-right">Filter:</span>
				<button class="w3-button w3-black">ALL</button>
			</div>
		</div>
	</header>

	<!-- Partner List -->
	<div class="w3-row-padding">
		<!-- Partner card start -->
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="그린 파머스">
				<h3>
					<a href="partnerdetail?id=1">그린 파머스</a>
				</h3>
				<p>작업 지역: 전국</p>
				<p>평점: ★★★★★</p>
			</div>
		</div>
		<!-- Repeat this block for each partner -->
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="온누리 벌초">
				<h3>
					<a href="partnerdetail?id=2">온누리 벌초</a>
				</h3>
				<p>작업 지역: 수도권</p>
				<p>평점: ★★★</p>
			</div>
		</div>
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="벌초 닷컴">
				<h3>
					<a href="partnerdetail?id=3">벌초 닷컴</a>
				</h3>
				<p>작업 지역: 전국</p>
				<p>평점: ★★★★</p>
			</div>
		</div>
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="다온 벌초대행">
				<h3>
					<a href="partnerdetail?id=4">다온 벌초대행</a>
				</h3>
				<p>작업 지역: 영남</p>
				<p>평점: ★★★</p>
			</div>
		</div>
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="벌초 청년">
				<h3>
					<a href="partnerdetail?id=5">벌초 청년</a>
				</h3>
				<p>작업 지역: 제주</p>
				<p>평점: ★★★★</p>
			</div>
		</div>
		<div class="w3-col l4 m6">
			<div class="partner-card w3-card-2">
				<img src="images/yecho.jpg" alt="예초 닷컴">
				<h3>
					<a href="partnerdetail.html?id=6">예초 닷컴</a>
				</h3>
				<p>작업 지역: 전국</p>
				<p>평점: ★★</p>
			</div>
		</div>
		<!-- Partner card end -->
	</div>

	<!-- Pagination -->
	<div class="w3-center w3-padding-32">
		<div class="w3-bar">
			<a href="#" class="w3-bar-item w3-button w3-hover-black">«</a> <a
				href="#" class="w3-bar-item w3-black w3-button">1</a> <a href="#"
				class="w3-bar-item w3-button w3-hover-black">2</a> <a href="#"
				class="w3-bar-item w3-button w3-hover-black">3</a> <a href="#"
				class="w3-bar-item w3-button w3-hover-black">4</a> <a href="#"
				class="w3-bar-item w3-button w3-hover-black">»</a>
		</div>
	</div>

</body>
</html>