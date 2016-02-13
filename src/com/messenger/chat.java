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
import javax.servlet.http.HttpSession;


@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //group g1;
  // boolean status=false;
  
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		//g1=new group();
		
	}


	public chat() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String msg=request.getParameter("msg");
		System.out.println("in SendMessage");
		GroupList glist=(GroupList)getServletContext().getAttribute("glist");
		HttpSession session=request.getSession();
		String gname=(String)session.getAttribute("gname");
		group grp=(group)glist.getGroup(gname);
		//LinkedList<String> msgs=grp.getMessages();
		String uname=(String)session.getAttribute("uname");
		grp.addMessage(uname+": "+msg);
		RequestDispatcher rd=request.getRequestDispatcher("chat.jsp");
		rd.forward(request,response);
		
		
	
	}

	
	
}
