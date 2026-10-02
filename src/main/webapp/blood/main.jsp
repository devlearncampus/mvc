<%@ page contentType="text/html; charset=UTF-8"%>
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
			action:"/blood",
			method:"GET"			
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
					<option value="A">A형</option>
					<option value="B">B형</option>
					<option value="AB">AB형</option>
					<option value="O">O형</option>
				</select>
			</div>
			
			<button class="btn btn-warning" id="bt">결과 보기</button>
		</form>
		
		<h3>
			선택 결과: <br>
			<%=request.getAttribute("msg")%>
		</h3>		
	</div>
	
	
</body>
</html>






