package com.hexagon.mvc.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.hexagon.mvc.model.ColorManager;

/*
 웹기반으로 제작했던 color 선택 애플리케이션을 javase 의 GUI으로 구현해보자
*/
public class ColorFrame extends JFrame{
	JComboBox<String> box;
	JButton bt;
	JLabel la_msg;
	ColorManager colorManager;
	
	public ColorFrame() {
		box = new JComboBox<String>();
		bt = new JButton("결과 보기");
		la_msg = new JLabel();
		colorManager = new ColorManager();
		
		box.addItem("원하시는 색상을 선택하세요");
		box.addItem("red");
		box.addItem("blue");
		box.addItem("green");
		box.addItem("yellow");
		
		//조립
		setLayout(new FlowLayout());
		add(box);
		add(bt);
		add(la_msg);
		
		//버튼과 리스너와의 연결 
		//리스너 구현체를 내부익명클래스로 구현하면 그나마 코드량을 줄일 수 있지만,
		//여전히 다른 언어등에 비해 이벤트 연결코드 거창하다...이 문제를 해결하려면?
		//함수형 프로그래밍 방법인 익명함수로 처리..하지만 java에서는 람다(Lambda)라 함
		//js 의 화살표 함수와 거의 비슷..
		bt.addActionListener((e)->{
			//System.out.println("나 눌렀어?");
			
			//모델 객체를 이용하여 결과 출력!!
			
			la_msg.setText("여기에 결과변수 넣기");
		});
		
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorFrame();
	}

}
