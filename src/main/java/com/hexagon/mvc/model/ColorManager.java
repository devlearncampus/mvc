package com.hexagon.mvc.model;

//이 클래스는 웹이건, 응용이건 상관없이 모든 플랫폼에서 재사용이 가능한 모델 객체이다!!!
//즉 MVC에서 model을 분리시켜놓자 
public class ColorManager {
	 
	 public String getAdvice(String color) {
		//out.print("유저가 전송한 색상은 "+color);
		
		String msg=null;
		
		switch(color){
			case "red": msg="일단 저지르고 보자! 인생은 직진이야";break;	
			case "blue": msg="이성적이고 논리적인데, 사실 가끔 영혼이 좀 없음";break;	
			case "green": msg="평화가 최고야. 나무늘보가 부러운 프로 평화주의자";break;	
			case "yellow": msg="가만히 있으면 입에 가시가 돋는 에너자이저";break;	
			default:msg="색상을 아직 선택하지 않았네요";
		}
		return msg;
	 }
}
