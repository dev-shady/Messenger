<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.messenger.GroupList,com.messenger.group,java.util.LinkedList,java.util.ListIterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
GroupList glist=(GroupList)application.getAttribute("glist");
String gname=(String)session.getAttribute("gname");
group grp=(group)glist.getGroup(gname);
LinkedList<String> msgs=grp.getMessages();
String uname=(String)session.getAttribute("uname");
ListIterator<String> it=msgs.listIterator();
while(it.hasNext()) {
	out.write(it.next()+"<br>\n");
}
%>

<form action="chat">
<input type="text" name="msg">
<input type="submit" value="Send Message">
</form><br>

</body>
</html>
