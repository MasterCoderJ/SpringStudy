<%@ page contentType="text/html; charset=UTF-8"%>
<%
// 	List boardList=(List)request.getAttribute("boardList");
	
// 	out.print("게시물 수는"+boardList.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script type="text/javascript">

	$(function() {
		$("#bt_regist").click(function() {
			location.href = "/client/gallery/registform";
		});
		
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>NO</th>
							<th>Title</th>
							<th>Writer</th>
							<th>Content</th>
							<th>Regdate</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
						</tr>
					</tbody>
							<tr>
							<td colspan="5">
								<button type="button" class="btn btn-info" id="bt_regist">등록</button>
							</td>
						</tr>
				</table>

			</div>
		</div>
	</div>
</body>
</html>