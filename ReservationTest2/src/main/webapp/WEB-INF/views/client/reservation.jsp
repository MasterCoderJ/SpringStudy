<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약페이지</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Calendar -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<input type="text" id="test1" name="test1" placeholder="예약시작일"> 
				<input type="text" id="test2" placeholder="예약종료일">
			</div>

			<div class="col-sm-6">
				<div>
					<button id="bt_regist">예약하기</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	
	

	function startDate() {
		$("#test1").datepicker({
			showOn : "both",
			changeMonth : false
		});

	}

	function endDate() {
		$("#test2").datepicker({
			showOn : "both",
			changeMonth : false
		});

	}
	
	function regist(){
		
	}

	$(function() {
		startDate();
		endDate();
		
		$("#bt_regist").click(function() {
			
		});
	});
</script>

</html>