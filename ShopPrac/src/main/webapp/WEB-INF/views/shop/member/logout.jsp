<%@page import="com.jspshop.util.ResponseMessage"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%

	//로그아웃 처리는 기본 회원이 사용중이던 세션을 사용 못하게 비활성화 시키면 된다
	session.invalidate();
	out.print(ResponseMessage.getMsgURL("로그아웃되었습니다", "/"));


%>