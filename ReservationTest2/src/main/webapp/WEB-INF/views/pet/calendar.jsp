<%@page import="com.edu.reservation.domain.Calendar"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 페이지</title>

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- BootStrap -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- fullcalender -->
<link href='/resources/fullcalendar/lib/main.css' rel='stylesheet' />
<script src='/resources/fullcalendar/lib/main.js'></script>

<style>
#calendarBox {
	width: 1000px;
	padding-left: 15%;
}
</style>

<body>
	<div id="calendarBox">
		<div id="calendar"></div>
	</div>

	<!-- modal 추가 -->
	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">휴무일을 설정하세요</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" value="휴무" readonly class="form-control" id="calendar_content" name="calendar_content"> 
						<label for="taskId" class="col-form-label">시작 날짜</label> 
						<input type="date" class="form-control" id="calendar_start_date" name="calendar_start_date"> 
						<label for="taskId" class="col-form-label">종료 날짜</label> 
						<input type="date" class="form-control" id="calendar_end_date" name="calendar_end_date">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal"  id="addCalendar">등록</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal" id="sprintSettingModalClose">취소</button>
				</div>
			</div>
		</div>
	</div>
	
</body>

<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		var obj;
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			timeZone : 'UTC',
			locale:'ko',
			dayMaxEvents: true,
			defaultAllDay:true,
			initialView : 'dayGridMonth', // 홈페이지에서 다른 형태의 view를 확인할  수 있다.
			events : [ // 일정 데이터 추가 , DB의 event를 가져오려면 JSON 형식으로 변환해 events에 넣어주면된다.
			{
				title : '휴무',
				start : '2023-03-26',
				end : '2023-03-27',
				allDay:true
			// color 값을 추가해 색상도 변경 가능 자세한 내용은 하단의 사이트 참조
			},
			{
				title:'달콩이',
				start:'2023-03-28',
				end:'2023-03-29',
				allDay:true
			}
			],
			headerToolbar : {
				left : 'addEventButton', // headerToolbar에 버튼을 추가
				center:'title'
			},
			customButtons : {
				addEventButton : { // 추가한 버튼 설정
					text : "휴무 등록", // 버튼 내용
					click : function() { // 버튼 클릭 시 이벤트 추가
						$("#calendarModal").modal("show"); // modal 나타내기

						$("#addCalendar").click(
								function() { // modal의 추가 버튼 클릭 시
									var content = $("#calendar_content").val();
									var start_date = $("#calendar_start_date").val();
									var end_date = $("#calendar_end_date").val();

									//내용 입력 여부 확인
									if (start_date == ""|| end_date == "") {
										alert("날짜를 입력하세요.");
									} else if (new Date(end_date)- new Date(start_date) < 0) { // date 타입으로 변경 후 확인
										alert("종료일이 시작일보다 먼저입니다.");
									} else { // 정상적인 입력 시
										obj = {
											"title" : content,
											"start" : start_date,
											"end" : end_date,
											"allDay": true
										}//전송할 객체 생성
										calendar.addEvent(obj);
										console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능 
									}
								});
						}
				}
			},
			displayEventTime : false,	// 시간 표시 x
			selectable: true,
			eventClick:function(event){
				console.log("ㅎㅇ"+calendar.getEvents());
			}
		});
		calendar.render();
	});
</script>

</html>