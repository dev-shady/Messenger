package com.messenger;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/enterGroup")
public class enterGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       boolean status=false;
  
    public enterGroup() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupId=request.getParameter("groupId");
		Cookie[] c=request.getCookies();
if(c!=null){
			
		if(c[0].getValue().equals(groupId)){
			status=true;
		}
		try{
		if(c[1].getValue().equals(groupId)){
			status=true;
		}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("array out of bounds exception");
		}
		if(status){
			response.sendRedirect("chat.jsp");
		}
		else{
			//if(false)
			System.out.println("no group with groupId "+groupId+" exists");
			response.sendRedirect("home.jsp");
		}
		
		
	}

else{
	//CHECK IF GROUP EXISTS wiz. FILE OPERATION
	//if(true)
	Cookie cs=new Cookie("groupId",groupId);
	response.addCookie(cs);
	RequestDispatcher rd=request.getRequestDispatcher("chat");
	rd.forward(request,response);
	//
	//if(false)
	System.out.println("no group with groupId "+groupId+" exists");
	response.sendRedirect("home.jsp");
}


}
	
	
}
