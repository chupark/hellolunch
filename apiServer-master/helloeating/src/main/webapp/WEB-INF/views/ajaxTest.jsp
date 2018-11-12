<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<body>
하이하이
<script>
 $(document).ready(function(){
	 $("#button").click(function(){
		 callAjax();
	 });
 });
 
 function callAjax(){

	 var obj = new Object();
	 obj.id = 'asdfa';
	 obj.password = 'asdfa';
	 var jsonData = JSON.stringify(obj);
	 console.log(jsonData);
 	 $.ajax({
		 type : "post",
		 dataType : "json",
		 contentType : "application/json",
		 url : "http://192.168.23.70:8080/user/eat2000",
		 data : jsonData,
		 success : whenSuccess,
		 error : whenError,
	 });
 }
 
 function whenSuccess(resdata){
	 console.log(resdata);
 }
 function whenError(request, status, error){
	 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 }
</script>

<input id="button" type="button" value="버튼">

</body>
</html>