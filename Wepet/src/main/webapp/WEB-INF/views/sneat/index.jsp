
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<!-- beautify ignore:start -->
<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="../assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>어드민 메인 페이지</title>

    <meta name="description" content="" />
    
	<%@ include file="./inc/sneat_header_link.jsp"%>
  </head>

  <body>
     <!-- navbar 카테고리부분 -->
	<%@ include file="./inc/sneat_navbar_link.jsp"%>
  <!-- navbar end -->

        <!-- Layout container -->
        <div class="layout-page">
          <!-- Navbar -->
	
	<!-- 상단, 서치바처럼 생긴 곳 -- 어드민 로그인상태 나오는 곳 아직 더 꾸밀필요가 있는듯 -->
		<%@ include file="./inc/sneat_searchbar_link.jsp" %>
		<!-- 서치바인듯 아닌듯 End -->
		
	<!-- 아무것도 안했으니까영.....흑흑...리스트 없네여....하하하하
	이제 여기가 뭐 나올 곳들이랍니다! content 마구마구마구 채우기~~~ 
	내용채우기 start-->
	
			<div class="container mt-3 mb-3">
				<table class="table" style="table-layout: fixed">
					<thead>
						<tr>
							<th>No</th>
							<th>야쌉~</th>
							<th>가능~</th>
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

					</tbody>
				</table>
			</div>

	<!-- 내용채우기 end -->



        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->


	<!-- head_link 2 : 헤드랑 비슷한데, 위아래 나눠져있길래 그냥 나눴슴당.. -->
	<%@ include file="./inc/sneat_header_link2.jsp" %>
	<!-- head_link 2  End -->
	
  </body>
</html>
