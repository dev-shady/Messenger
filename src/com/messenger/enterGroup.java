package com.messenger;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/enterGroup")
public class enterGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       boolean status=false;
  
    public enterGroup() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupId=request.getParameter("groupId");
	//	fileManagement f=new fileManagement();
		String uname="new";
		GroupList glist=(GroupList)getServletContext().getAttribute("glist");
		if(glist==null)
			System.out.println("glist null");
	Cookie[] c=request.getCookies();
	//Cookie cookie;
if(c!=null){
		System.out.println("cookies not null");
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
			
			group grp=glist.getGroup(groupId);
			grp.addMember(uname);
			grp.addMessage(uname+" joined");
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*60);
			session.setAttribute("uname",uname);
			session.setAttribute("gname", groupId);
			response.sendRedirect("chat.jsp");
		}
		else{
			//if(false)
			System.out.println("no group with groupId "+groupId+" exists");
			response.sendRedirect("home.jsp");
		}
		
		
	}

else{
	System.out.println("cookies null");
	if(glist.contains(groupId)){							//CHANGED
	Cookie cs=new Cookie("groupId",groupId);
	group grp=glist.getGroup(groupId);
	grp.addMember(uname);
	grp.addMessage(uname+" joined");
	response.addCookie(cs);
	HttpSession session=request.getSession();
	session.setMaxInactiveInterval(60*60);
	session.setAttribute("uname",uname);
	session.setAttribute("gname", groupId);
	RequestDispatcher rd=request.getRequestDispatcher("chat");
	rd.forward(request,response);
	}
	else{
	System.out.println("no group with groupId "+groupId+" exists");
	response.sendRedirect("home.jsp");
	}
}


}
	
	
}
