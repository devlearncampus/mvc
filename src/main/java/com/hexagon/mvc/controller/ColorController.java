package com.hexagon.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexagon.mvc.model.ColorManager;

//이 클래스는 오직 색상과 관련한 요청을 처리하는 컨트롤러임
/*MVC 와  Model2 의 차이점
 모델2 란? javaEE 기술로 구현한  MVC 패턴을 의미
 
 M - 순수(pure) java 가 담당
 V - jsp가 담당 
 C - Servlet 이 담당 (웹요청을 받아야 하고, 로직 객체에 일을 시킬 수 있는 능력者)
*/
public class ColorController extends HttpServlet{
	ColorManager colorManager = new ColorManager();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 전송한 색상 파라미터 받기!!
		String color = request.getParameter("color");
		if(color==null)color=""; //최초에는 전송된 파라미터가 없으므로, 디폴트값을 강제로 부여하자

		//별도로 분리시켜놓은 로직인 model 객체를 이용해보자!!
		/*
		 기존 jsp 코드에서 컨트롤러의 역할에 해당하는 코드를 이 컨트롤러 클래스로 옮겨오는것까지는 성공했으나..
		 jsp 가 디자인에 사용할  msg  변수를 Controller가 보유하고 있기 때문에 어떻게 해서든지, msg를  jsp 가 사용할  수 있도록 처리..
		 
		이 문제를 해결하려면 javaEE 애플리케이션의 데이터의 Scope(생존 범위)
		1.request 스코프 - 요청이 끝날때까지는 유지되는 scope  (단순히 데이터를 결과 페이지에 보여주는게 목적이라면 압도적으로 많이 쓰임)
							     일부러 생성할 필요없이 매 요청마다 언제나 생성되므로...									
		2.session  스코프 - 로그인이 필요없는 서비스인 경우, session 객체를 사용하면 메모리 낭비..(과하다) 
		3.application 스코프  - 너무 오래 유지되므로, 많은 데이터가 누적될 가능성이 높다..(과하다) 
		*/
		String msg = colorManager.getAdvice(color);
		
		//session에 데이터를 심으면,  session 을 사용할 수 있는 동안은 꺼내서 쓸수 있다..
		//1) 브라우저 프로세스를 종료하고 새롭게 들어올때는 쿠키가 없으므로 세션 접근못씀(그 이전까지 사용 가능) 
		//2) 브라우저 프로세스를 종료하지 않더라도 일정 시간 동안 재요청이 없는 경우( 즉 서버에서 지정한 기간 동안 재요청이 없는 경우 사용하지 않는 것으로 간주하여 세션무효화)
		
		//세션은 요청이 들어올때마다 무조건 만들어는게 아님, 메모리 효율상 개발자가 세션을 건드리는 코드를 만나면 이때 생성됨!!
		//HttpSession session=request.getSession(); 
		//session.setAttribute("msg", msg);  //session 은 Map을 구현했으므로, key-value 쌍으로 관리됨
		
		//tomcat 서버에 배포된 웹애플리케이션이 가동되는 시점에 생성되는 ServletContext(jsp의 application  내장 객체)에도 session과 동일하게 데이터를
		//심을 수 있다.이 ServletContext 객체는 tomcat 서버를 끌때까지 생명력이 유지되는  scope를 가지고 있다..
		/*
		 *             javaee api (자료형)                jsp내장객체
		 *           HttpServletRequest                 request
		 *           HttpServletResponse               response
		 *           PrintWriter                                out
		 *           HttpSession                           session 
		 *           ServletContext                      application
		 * */
		//ServletContext context=request.getServletContext();//웹사이트와 생명을 함께하는 객체인 ServletContext 얻기 
		//context.setAttribute("msg", msg);
		
		request.setAttribute("msg", msg);
		
		//결과 페이지인 View  보여주기
		//아래의 메서드의 매개변수값으로 브라우저가 재접속할 url을 적으면 됨 
		//response.sendRedirect("/color/main.jsp");  // js 의 location.href= 와 완전 동일
		
		//우리가 선택한 저장소는 request 이므로, 이 요청에 대한 응답을 절대로 해서는 안되며 main.jsp로 포워딩해야 request 가 죽지않고 유지된다..
		RequestDispatcher dis = request.getRequestDispatcher("/color/main.jsp"); //포워딩할 주소 
		dis.forward(request, response); //포워딩  시, 새로운request, response 를 만드는게 아니라, 현재 요청에 사용된 request, response 가
													//그래도 살아서 전달된다..
	}
}













