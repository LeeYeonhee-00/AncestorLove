<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Lato", sans-serif
}

.w3-bar, h1, button {
	font-family: "Montserrat", sans-serif
}

</style>
</head>
<body>

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-light-green w3-card w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
				href="javascript:void(0);" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home" class="w3-bar-item w3-button w3-padding-large w3-green">Home</a>
			<a href="list"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-light-green">의뢰하기</a>
			<!-- Updated link -->
			<a href="/partner"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-light-green">파트너</a>
			<a href="login.html"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green w3-right">로그인</a>
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
			<a href="inquiry.html" class="w3-bar-item w3-button w3-padding-large">의뢰하기</a>
			<!-- Updated link -->
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
			<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 4</a>
		</div>
	</div>

	<!-- Header -->
	<header class="w3-container w3-light-green w3-center"
		style="padding: 128px 16px">
		<h1 class="w3-margin w3-jumbo">조상사랑</h1>
		<p class="w3-xlarge">예초 및 벌초 의뢰 매칭 서비스</p>
		<button
			class="w3-button w3-black w3-padding-large w3-large w3-margin-top"
			onclick="location.href='/write'">의뢰하기</button>
	</header>

	<!-- First Grid -->
	<div class="w3-row-padding w3-padding-64 w3-container">
		<div class="w3-content">
			<div class="w3-twothird">
				<h1>조상사랑</h1>
				<h5 class="w3-padding-32">조상사랑을 방문해주셔서 감사합니다. 조상사랑은 예초, 벌초 또는
					정원관리하는 업체와 매칭을 해주는 서비스로, 고객과 업체를 매칭함으로써 모두가 만족하는 서비스를 누릴 수 있도록 노력하고
					있습니다.</h5>

				<p class="w3-text-grey"
					style="margin-bottom: 20px; line-height: 1.6;">저희 조상사랑은 조상에 대한
					깊은 존경과 사랑을 바탕으로, 전통을 지키고 후손들에게 건강한 자연환경을 물려주기 위해 최선을 다하고 있습니다. 오랜
					세월 동안 우리 민족이 중요하게 여겨온 벌초와 예초는 단순한 작업이 아닌, 조상과의 연결을 유지하고 자연을 보호하는
					소중한 의식입니다.</p>

				<p class="w3-text-grey"
					style="margin-bottom: 20px; line-height: 1.6;">조상사랑은 전문적인 장비와
					숙련된 인력을 통해, 고객님의 소중한 묘소를 깨끗하고 안전하게 관리해 드립니다. 현대의 바쁜 생활 속에서도 조상에 대한
					예의를 지킬 수 있도록, 저희는 언제나 믿고 맡기실 수 있는 서비스를 제공합니다.</p>

				<p class="w3-text-grey"
					style="margin-bottom: 20px; line-height: 1.6;">조상의 은혜를 기억하며,
					고객님의 마음을 담아 정성껏 서비스를 제공하겠습니다. 여러분의 소중한 시간을 절약하고, 그 시간을 가족과 함께 보내실 수
					있도록 도와드리겠습니다.</p>

				<p class="w3-text-grey"
					style="margin-bottom: 20px; line-height: 1.6;">조상을 사랑하는 마음으로,
					조상사랑은 항상 최선을 다하겠습니다.</p>

			</div>

			<div class="w3-third w3-center">
				<img
					src="https://github.com/user-attachments/assets/b242cbad-51e7-401f-9599-85069eac1b16"
					style="width: 400px; height: 500px;"
					class="w3-padding-64 w3-text-red w3-margin-left" alt="Round_Logo">
			</div>
		</div>
	</div>


	<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
		<h1 class="w3-margin w3-xlarge">조상을 사랑하는 마음 : 조상사랑</h1>
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-padding-64 w3-center w3-opacity">

		<p>
			Powered by <a href="https://github.com/LeeYeonhee-00/AncestorLove"
				target="_blank">체큇아웃</a>
		</p>
	</footer>

	<script>
		// Used to toggle the menu on small screens when clicking on the menu button
		function myFunction() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>

</body>
</html>
