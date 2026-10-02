<%@page import="com.hexagon.mvc.model.ColorManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! ColorManager colorManager = new ColorManager(); %>
<%
	//클라이언트가 전송한 색상 파라미터 받기!!
	String color = request.getParameter("color");
	if(color==null)color=""; //최초에는 전송된 파라미터가 없으므로, 디폴트값을 강제로 부여하자

	//별도로 분리시켜놓은 로직인 model 객체를 이용해보자!!
	String msg = colorManager.getAdvice(color);
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
			action:"/color/main.jsp",
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
					<option value="red" <%if(color.equals("red")){%>selected<%}%>>빨간색</option>
					<option value="blue"<%if(color.equals("blue")){%>selected<%}%>>파란색</option>
					<option value="green" <%if(color.equals("green")){%>selected<%}%>>초록색</option>
					<option value="yellow" <%if(color.equals("yellow")){%>selected<%}%>>노란색</option>
				</select>
			</div>
			
			<button class="btn btn-info" id="bt">결과 보기</button>
		</form>
		
		<h3>
			선택 결과: <br>
			<%=msg%>
		</h3>		
	</div>
	
	
</body>
</html>






