<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 일정관리</title>

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Callendar -->
<link href='/resources/lib/main.css' rel='stylesheet' />
<script src='/resources/lib/main.js'></script>
<script type="text/javascript">
	
	$(function() {

		var Calendar = FullCalendar.Calendar;
		var Draggable = FullCalendar.Draggable;

		var containerEl = document.getElementById('external-events');
		var calendarEl = document.getElementById('calendar');
		var checkbox = document.getElementById('drop-remove');

		// initialize the external events
		// -----------------------------------------------------------------

		new Draggable(containerEl, {
			itemSelector : '.fc-event',
			eventData : function(eventEl) {
				return {
					title : eventEl.innerText
				};
			}
		});

		// initialize the calendar
		// -----------------------------------------------------------------

		var calendar = new Calendar(calendarEl, {
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth'
			},
			locale : 'ko',
			editable : true,
			selectable:true,
			droppable : true,
			drop : function(arg) {
				if (checkbox.checked) {
					info.draggedEl.parentNode.removeChild(info.draggedEl);
				}
			},
			events:arg
		});
		calendar.render();
		console.log(arg);
	});
</script>
<style>
html, body {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#external-events {
	position: fixed;
	z-index: 2;
	width: 150px;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
}

.demo-topbar+#external-events { /* will get stripped out */
	top: 60px;
}

#external-events .fc-event {
	cursor: move;
	margin: 3px 0;
}

#calendar-container {
	position: relative;
	z-index: 1;
	margin-left: 200px;
}

#calendar {
	max-width: 1100px;
	margin: 20px auto;
}
</style>
</head>
<body>

	<div id='external-events'>
		<p>
			<strong>휴무일 설정</strong>
		</p>

		<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
			<div class='fc-event-main'>휴무</div>
		</div>
		<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
			<div class='fc-event-main'>My Event 2</div>
		</div>
		<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
			<div class='fc-event-main'>My Event 3</div>
		</div>
		<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
			<div class='fc-event-main'>My Event 4</div>
		</div>
		<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
			<div class='fc-event-main'>My Event 5</div>
		</div>

		<p>
			<input type='checkbox' id='drop-remove' /> <label for='drop-remove'>remove after drop</label>
		</p>
	</div>

	<div id='calendar-container'>
		<div id='calendar'></div>
	</div>
	
</body>
</html>