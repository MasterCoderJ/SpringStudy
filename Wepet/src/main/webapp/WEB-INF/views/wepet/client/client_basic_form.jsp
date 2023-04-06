<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>결제하기 페이지</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Header Start -->
<%@ include file="../../gardener/inc/header_link.jsp"%>
<!-- Header End -->

<script src="https://js.tosspayments.com/v1/payment"></script>

</head>

<body>
<!-- Spinner Start 로딩시 빙글빙글이라 따로 안뺌-->
<div id="spinner"
	class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
	<div class="spinner-border text-primary" role="status"
		style="width: 3rem; height: 3rem;"></div>
</div>
<!-- Spinner End -->

<!-- Topbar Start 맨 윗칸 전화모양-->
<%@ include file="../../gardener/inc/topbar_link.jsp"%>
<!-- Topbar End -->

<!-- Navbar Start 카테고리부분-->
<%@ include file="../../gardener/inc/navbar_link.jsp"%>
<!-- Navbar End -->

<!-- Body -->
<a class="skip-link sr-only" href="#skip-target">Skip to content</a>

<div class="page-flex">
<!--  Sidebar Start -->
<!--  Sidebar End-->

	<div class="container justify-content-center">
	
	
	
	
	


	<!-- Footer Start -->
	<!-- Footer End -->
	<!-- Copyright Start -->
	<%@ include file="../../gardener/inc/copyright_link.jsp"%>
	<!-- Copyright End -->
	</div>
</div>

	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
	
</body>

</html>