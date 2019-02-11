<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">고객 목록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>아이디</th>
	    <th>이름</th>
	    <th>주민등록번호</th>
	    <th>성별</th>
	     <th>핸드폰번호</th>
	     <th>우편번호</th>
	      <th>주소</th>
	       <th>상세주소</th>  
	  </tr>
	  <c:forEach items="${list}"  var="cus" >
	  <tr>
<!-- 	  
	  customerID,
				   customerName,
				   password,
				   ssn,
				   photo,
				   phone,
				   city,
				   address,
				   postalcode;	 -->
	    <td>1</td>
	    <td>${cus.customerID}</td>
	    <td>${cus.customerName}</td>
	    <td>${cus.ssn}</td>
	    <td>남</td>
	    <td>${cus.phone}</td>
	    <td>${cus.postalcode}</td>
	    <td>${cus.city}</td>
	    <td>${cus.address}</td>
	  </tr>
	   </c:forEach>
	
	</table>
	
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination">
	  <a href="#">&laquo;</a>
	  <a href="#" class="active">1</a>
	  <a href="#">2</a>
	  <a href="#">3</a>
	  <a href="#">4</a>
	  <a href="#">5</a>
	  <a href="#">&raquo;</a>
	  </div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>