<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Gardener - Gardening Website Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Header Start -->
<%@ include file="./inc/header_link.jsp"%>
<!-- Header End -->
</head>

<body>
	<!-- Spinner Start 로딩시 빙글빙글이라 따로 안뺌-->
	<div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary" role="status" style="width: 3rem; height: 3rem;"></div>
	</div>
	<!-- Spinner End -->

	<!-- Topbar Start 맨 윗칸 전화모양-->
	<%@ include file="./inc/topbar_link.jsp"%>
	<!-- Topbar End -->

	<!-- Navbar Start 카테고리부분-->
	<%@ include file="./inc/navbar_link.jsp"%>
	<!-- Navbar End -->

	<!-- Body -->
	<a class="skip-link sr-only" href="#skip-target">Skip to content</a>

	<div class="page-flex">

		<!--  Sidebar Start -->
		<%@ include file="./inc/sidebar_link.jsp"%>
		<!--  Sidebar End-->
		
		<div class="container m-5">

			<div class="row">
				<div class="col-3">
					<div class="dropdown">
						<button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">Dropdown button</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Link 1</a></li>
							<li><a class="dropdown-item" href="#">Link 2</a></li>
							<li><a class="dropdown-item" href="#">Link 3</a></li>
						</ul>
					</div>

				</div>

				<div class="col-3">
					<div class="dropdown">
						<button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">Dropdown button</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Link 1</a></li>
							<li><a class="dropdown-item" href="#">Link 2</a></li>
							<li><a class="dropdown-item" href="#">Link 3</a></li>
						</ul>
					</div>

				</div>
			</div>
			<div class="container mt-3 mb-3">
				<table class="table" style="table-layout: fixed">
					<thead>
						<tr>
							<th width="6%">No</th>
							<th width="6%">소분류</th>
							<th width="64%">제목</th>
							<th width="6%">작성자</th>
							<th width="6%">작성일</th>
							<th width="6%">조회수</th>
							<th width="6%">추천</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>John</td>
							<td>Doe</td>
							<td>john</td>
						</tr>
						<tr>
							<td>Mary</td>
							<td>Moe</td>
							<td>mary</td>
						</tr>
						<tr>
							<td>July</td>
							<td>Dooley</td>
							<td>july</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="container m-3">

				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="javascript:void(0);">Previous</a></li>
					<li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
					<li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
					<li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
				</ul>

			</div>

			<div class="container m-3">
				<div class="row" style="float: none; margin: 0 auto">
					<div class="col-3" style="float: none; margin: 0 auto">
						<div class="dropdown">
							<button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">선택하세요</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Link 1</a></li>
								<li><a class="dropdown-item" href="#">Link 2</a></li>
								<li><a class="dropdown-item" href="#">Link 3</a></li>
							</ul>
						</div>
					</div>
					<div class="col-6" style="float: none; margin: 0 auto">
						<form>
							<input type="text" class="form-control" placeholder="Enter email" name="email">
						</form>
					</div>
					<div class="col-3" style="float: none; margin: 0 auto">
						<button type="button" class="btn btn-primary">검색</button>
					</div>
				</div>

				<!-- Footer Start -->

				<!-- Footer End -->


				<!-- Copyright Start -->
				<%@ include file="./inc/copyright_link.jsp" %>
				<!-- Copyright End -->


				<!-- Back to Top -->
				<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
</body>

</html>