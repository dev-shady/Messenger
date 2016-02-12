package com.messenger;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   group g1;
   boolean status=false;
  
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		g1=new group();
		
	}


	public chat() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String msg=request.getParameter("msg");
		g1.messages.add(msg);
		request.setAttribute("data",g1.messages);
		RequestDispatcher rd=request.getRequestDispatcher("chat.jsp");
		rd.forward(request,response);
		
		
	
	}

	
	
}
