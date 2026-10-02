package com.hexagon.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexagon.mvc.model.BloodManager;

public class BloodController{
	BloodManager manager = new BloodManager();
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계 - 일시키기 
		String blood = request.getParameter("blood");
		String msg=manager.getAdvice(blood);
		
		//4단계 - 결과 저장 
		request.setAttribute("msg", msg);
	}
	
}





