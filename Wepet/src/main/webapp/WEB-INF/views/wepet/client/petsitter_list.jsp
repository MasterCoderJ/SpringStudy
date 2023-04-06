<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>펫시터 리스트</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Header Start -->
<%@ include file="../../gardener/inc/header_link.jsp"%>
<!-- Header End -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/juso.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.13/vue.js"></script>
</head>

<body>
	<!-- Topbar Start 맨 윗칸 전화모양-->
	<%@ include file="../../gardener/inc/topbar_link.jsp"%>
	<!-- Topbar End -->

	<!-- Navbar Start 카테고리부분-->
	<%@ include file="../../gardener/inc/navbar_link.jsp"%>
	<!-- Navbar End -->

	<!-- Body -->
	<a class="skip-link sr-only" href="#skip-target">Skip to content</a>

	<div class="container-fluid page-header py-5 mb-5 wow fadeIn" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeIn;">
		<div class="container text-center py-5">
			<h1 class="display-3 text-white mb-4  slideInDown">펫시터 선생님들을 소개합니다</h1>
			<nav aria-label="breadcrumb animated slideInDown">
				<ol class="breadcrumb justify-content-center mb-0">
					<li class="breadcrumb-item">지역/ 성별/ 경력 조건에 맞는 선생님을 선택해 보세요</li>
				</ol>
			</nav>
		</div>
	</div>

	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px; visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
				<p class="fs-5 fw-bold text-primary">카테고리를 선택해 주세요</p>
				<div class="row" style="margin-top: 50px;">
					<div class="col">
						<div>
							<label for="addressRegion1" class="form-label">전역</label> <select name="addressRegion" id="addressRegion1" style="width: 100px;"></select>
						</div>
					</div>

					<div class="col">
						<div>
							<label for="addressDo1" class="form-label">시/군</label> <select name="addressDo" id="addressDo1" style="width: 100px;"></select>
						</div>
					</div>

					<div class="col">
						<div>
							<label for="addressSiGunGu1" class="form-label">구</label> <select name="addressSiGunGu" id="addressSiGunGu1" style="width: 100px;"></select>
						</div>
					</div>

					<div class="col">
						<button type="button" class="btn btn-primary">검색</button>
					</div>
				</div>
			</div>
			<div class="row" style="margin-top: 60px;" id="app1">
				
				<template v-for="item in items">
					<petcard/>
				</template>

				<tr>
					<td class="text-center" colspan="8" id="paging-area"></td>
				</tr>
			</div>
		</div>
	</div>

	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
</body>

<script type="text/javascript">

let app1;
let key = 0;

const petcard = {
    template: `
	<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
		<div class="team-item rounded">
			<img class="img-fluid" src="../../../resources/gardener/img/team-1.jpg" style="height: 400px; width: 300px">
			<div class="team-text" style="width: 290px;">
				<h4 class="mb-0">{{item.name}}</h4>
				<p class="text-primary">{{item.job}}</p>
				<div class="team-social d-flex">
					<a class="btn btn-primary" href="/reservation" style="margin-top: 5px;"><i>예약</i></a>
				</div>
			</div>
		</div>
	</div>
	`,
	data(){
		
	},
   	 methods: {
    	
    	}
	};
	
app1=new Vue({
	el:"#app1",
	components:{
		petcard
	},
	data:{
		items: [
		      { message: 'Foo' },
		      { message: 'Bar' }
		    ]
	}
});


function paging() {
	//넘버링 출력
	$("#paging-area *").remove();
	for(let i=pager.firstPage; i<pager.lastPage; i++){
		if(i>pager.totalPage)break; 
		$("#paging-area").append("<a href='javascript:pageLink("+i+")' style='margin:3px'>"+i+"</a>");
	}       	

}

function init() {
    app1 = new Vue({
        el: "#app1",
        components: {
            product
        },
        data: {
            count: 5,
            salesList: [], //전체 배열
            currentList: [], //페이지당 보여질 배열
            num: 0 //페이지당 시작 번호를 뷰 컴포넌트에서 접근할 수 있도록
        }
    });
}


</script>


</html>