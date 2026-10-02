<%@page import="com.hexagon.mvc.model.BloodManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! BloodManager bloodManager = new BloodManager(); %>
<%
	//클라이언트가 전송한 색상 파라미터 받기!!
	String blood = request.getParameter("blood");
	if(blood==null)blood=""; //최초에는 전송된 파라미터가 없으므로, 디폴트값을 강제로 부여하자
	
	//out.print("유저가 전송한 색상은 "+color);
	String msg = bloodManager.getAdvice(blood); 
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
			action:"/blood/main.jsp",
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
				<select class="form-control" name="blood">
					<option>원하시는 혈액형을 선택하세요</option>
					<option value="A" <%if(blood.equals("A")){%>selected<%}%>>A형</option>
					<option value="B"<%if(blood.equals("B")){%>selected<%}%>>B형</option>
					<option value="AB" <%if(blood.equals("AB")){%>selected<%}%>>AB형</option>
					<option value="O" <%if(blood.equals("O")){%>selected<%}%>>O형</option>
				</select>
			</div>
			
			<button class="btn btn-warning" id="bt">결과 보기</button>
		</form>
		
		<h3>
			선택 결과: <br>
			<%=msg%>
		</h3>		
	</div>
	
	
</body>
</html>






