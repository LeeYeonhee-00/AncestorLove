<%@ taglib uri="http://jakarta.apache.org/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<%@ page import="com.yourpackage.model.InquiryDTO, com.yourpackage.service.InquiryService" %>
<%@ page import="org.springframework.web.context.support.SpringBeanAutowiringSupport" %>
<%
    // Enable Spring to autowire beans in JSP
    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    
    // Get the InquiryService bean from the Spring context
    InquiryService inquiryService = (InquiryService) application.getAttribute("inquiryService");
    
    // Handle form submission
    String title = request.getParameter("inquiryTitle");
    String address = request.getParameter("inquiryAddress");
    String date = request.getParameter("inquiryDate");
    String content = request.getParameter("inquiryContent");
    String userId = request.getParameter("userId");
    String workId = request.getParameter("workId");

    if (title != null && address != null && date != null && content != null && userId != null && workId != null) {
        InquiryDTO inquiry = new InquiryDTO();
        inquiry.setInquiryTitle(title);
        inquiry.setInquiryAddress(address);
        inquiry.setInquiryDate(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        inquiry.setInquiryContent(content);
        inquiry.setUserId(Long.parseLong(userId));
        inquiry.setWorkId(Long.parseLong(workId));

        inquiryService.saveInquiry(inquiry);
        response.sendRedirect("list.jsp");
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>의뢰정보입력</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        table {
            margin: auto;
        }
        input[type="text"], textarea, select {
            border: 1.5px rgb(68, 136, 244) solid;
            width: 500px;
            height: 30px;
            border-radius: 5px;
            padding-left: 10px;
        }
        textarea {
            height: 400px;
            padding-top: 10px;
            resize: none;
        }
        .header {
            height: 30px;
        }
        input[type="submit"] {
            width: 100px;
            height: 40px;
            font-size: 15px;
            border: 0;
            outline: 1.5px rgb(68, 136, 244) solid;
            border-radius: 5px;
            background-color: rgb(164, 199, 255);
        }
        input[type="submit"]:active {
            background-color: rgb(68, 136, 244);
        }
    </style>
</head>

<body>
<!-- Navbar -->
<div class="nav-bar">
  <div class="w3-bar w3-red w3-card w3-left-align w3-large">
    <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-white">Home</a>
    <a href="list.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-white">의뢰하기</a>
    <a href="partner.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">파트너</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-green w3-right">회원님 안녕하세요</a>
  </div>
</div>

<!-- Form Section -->
<form action="write.jsp" method="post">
    <table> 
        <tr><td><h2>의뢰정보입력</h2></td></tr>
        <tr><td class="header">제목</td></tr>
        <tr><td><input type="text" placeholder="제목을 입력하세요" name="inquiryTitle"></td></tr>
        <tr><td class="header">작업주소</td></tr>
        <tr><td><input type="text" placeholder="작업 주소를 입력하세요" name="inquiryAddress"></td></tr>
        <tr><td class="header">작업날짜</td></tr>
        <tr><td><input type="text" placeholder="작업날짜를 입력하세요" name="inquiryDate"></td></tr>
        <tr><td class="header">작업유형</td></tr>
        <tr>
            <td>
                <select name="workId">
                    <option value="1">예초</option>
                    <option value="2">벌초</option>
                    <option value="3">정원관리</option>
                </select>
            </td>
        </tr>
        <tr><td class="header">사용자 ID</td></tr>
        <tr><td><input type="text" placeholder="사용자 ID를 입력하세요" name="userId"></td></tr>
        <tr><td class="header">의뢰내용</td></tr>
        <tr><td><textarea placeholder="의뢰내용을 입력하세요" name="inquiryContent"></textarea></td></tr>
        <tr><td style="text-align:right;"><input type="submit" value="게시하기"></td></tr>
    </table>
</form>

</body>
</html>
