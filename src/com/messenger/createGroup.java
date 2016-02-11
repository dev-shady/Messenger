package com.messenger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createGroup")
public class createGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public createGroup() {
        super();
    }
    
    public createGroup(String name,String id){
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String groupName=request.getParameter("groupName");
		String groupId=request.getParameter("groupId");
		group g1=new group(groupId,groupName);  //FILE OPERATION HERE
		Cookie c=new Cookie("groupId", groupId);
		c.setMaxAge(60*60*2);
		response.addCookie(c);
	    response.sendRedirect("home.jsp");
			
	}

	
	

}
