<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//지금부터는 MVC로 철저히 나누어서 개발해야 하는 모델2로 구현해야 하지만, 
	//View(디자인)만을 담당해야 하는 jsp에 코드에 Controller로의 코드가 섞여 있으므로, 
	//디자인을 버리고 다른 디자인 소스로 대체할 경우, Controller가 함께 날아가 버린다..
	//즉 완전히 분리시키지 못한 상태 == 모델 1 방식이의 개발이라 함 	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//유저가 선택한 색상에 대한 결과 메시지 얻기!!
	function getResult(){
		$("#form1").attr({
			action:"/color",
			method:"POST"			
		});
		
		$("#form1").submit(); // 여기서 전송		
	}
	
	$(function(){
		$("#bt").click(()=>{
			getResult();
		});
	});

</script>
</head>
<body>
	<div class="container">
		<form id="form1">	
			<div class="form-group">
				<select class="form-control" name="color">
					<option>원하시는 색상을 선택하세요</option>
					<!-- selected 속성을 서버측에서 부여하여 브라우저에 보내야 하는데, 이때 사용자가 선택한 색상과 일치하는 
						option에 대해서만  selected를 부여하면 된다..
					 -->
					<option value="red">빨간색</option>
					<option value="blue">파란색</option>
					<option value="green">초록색</option>
					<option value="yellow">노란색</option>
				</select>
			</div>
			
			<button class="btn btn-info" id="bt">결과 보기</button>
		</form>
		
		<h3>
			선택 결과: <br>
			<!-- 개발자가 서버를 중지한 적이 없다면 msg 는 언제나 꺼내쓸 수 있다  -->
			<%=request.getAttribute("msg")%>
		</h3>		
	</div>
	
	
</body>
</html>






