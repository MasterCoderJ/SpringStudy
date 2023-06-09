<%@page import="com.edu.springboard.domain.ReBoard"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	ReBoard reboard = (ReBoard)request.getAttribute("reboard");
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
			$("#form1").attr({
				action : "/reboard/regist",
				method : "post"
			});
			$("#form1").submit();
		});

		$("#bt_list").click(function() {
			location.href = "/reboard/list";
		});

		$("#bt_del").click(function() {
			if (confirm("삭제 하시겠습니까?")) {
				$("#form1").attr({
					action : "/reboard/delete",
					method : "post"
				});
				$("#form1").submit();
			}
		});
		
		$("#bt_edit").click(function() {
			if (confirm("수정 하시겠습니까?")) {
				$("#form1").attr({
					action : "/reboard/edit",
					method : "post"
				});
				$("#form1").submit();
			}
		});
		
		$("#reply_section").hide();
		
		$("#bt_replyform").click(function(){
			//숨겨져있던 답변 등록 등장 show(), hide()
			$("#reply_section").show();
			
		});
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col mt-3">
				<form id="form1">
					<input type="hidden" name="reboard_idx" value="<%=reboard.getReboard_idx()%>">
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getTitle()%>" name="title">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getWriter()%>" name="writer">
					</div>
					<div class="form-group">
						<textarea class="form-control" name="content"><%=reboard.getContent()%></textarea>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-info" id="bt_edit">수정</button>
						<button type="button" class="btn btn-info" id="bt_del">삭제</button>
						<button type="button" class="btn btn-info" id="bt_list">목록</button>
						<button type="button" class="btn btn-info" id="bt_replyform">답변하기</button>
					</div>
				</form>
			</div>
		</div>
		
		<div class="row" id="reply_section">
			<div class="col mt-3">
				<form id="form2">
					<input type="hidden" name="reboard_idx" value="<%=reboard.getReboard_idx()%>">
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getTitle()%>" name="title">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getWriter()%>" name="writer">
					</div>
					<div class="form-group">
						<textarea class="form-control" name="content"><%=reboard.getContent()%></textarea>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-primary" id="bt_reply">답변등록</button>
					</div>
				</form>
			</div>
		</div>
	
		
	</div>
</body>
</html>