<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- Vue -->	
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>


<script type="text/javascript">
	function regist(){
		
		let formData= $("#form1").serialize();
		console.log(formData);
		
		//비동기로 등록요청
		$.ajax({
			url:"/rest/notices",
			type:"post",
			data: formData,
			success:function(result,status,xhr){
				location.href="/notice/list";
			}
		});
	}
	
	$(function(){
		$("#bt_regist").click(function(){
			regist();
		});
		
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<div class="col">
				<form id="form1">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Title" name="title">
					</div>

					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter writer" name="writer">
					</div>

					<div class="form-group">
						<textarea class="form-control" placeholder="Write Content" name="content"></textarea>
					</div>
					
					<div class="form-group">
						<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>