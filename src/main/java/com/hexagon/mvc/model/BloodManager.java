package com.hexagon.mvc.model;

public class BloodManager {
	
	public String getAdvice(String blood) {
		String msg=null;
		
		switch(blood){
			case "A": msg="혼자 100만 가지 경우의 수를 생각하는 섬세한 프로 속앓러";break;	
			case "B": msg="남 눈치 안 보고 내 길을 가는 마이웨이 자유 영혼";break;	
			case "AB": msg="속내를 알 수 없는 시크한 외계인 코스프레러";break;	
			case "O": msg="에너지가 넘치고 무리를 이끄는 털털한 대장님";break;	
			default:msg="혈액형을 아직 선택하지 않았네요";
		}	
		return msg;
	}
}
