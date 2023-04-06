<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
요청하신 페이지를 찾을 수 없습니다
<p>
<%
	RuntimeException e= (RuntimeException)request.getAttribute("e");
	out.print(e.getMessage());
%>
<p>
<a href="/board/list">홈페이지 메인으로</a>

</body>
</html>