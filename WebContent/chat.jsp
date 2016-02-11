<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
LinkedList<String> l=(LinkedList<String>)request.getAttribute("data");
if(l!=null){
	 Iterator<String> i=l.iterator();
	while(i.hasNext()){
		out.println(i.next()+"<br>");
	} 
}

%>

<form action="chat">
<input type="text" name="msg">
<input type="submit" value="Send Message">
</form><br>

</body>
</html>