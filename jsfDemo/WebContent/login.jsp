<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>login</title>
</head>
<body>
<%-- <jsp:useBean id="connect" scope="session"
class="edu.uic.ids.model.Connect"> </jsp:useBean> 
 <jsp:useBean id="tableselect" scope="session"
class="edu.uic.ids.model.TableSelect"> </jsp:useBean>  --%>
 <f:view> 
<center>
<h4>IDS517 Database Login</h4>
<hr />
<a href="index.jsp">Home</a>
  <h:form>
<h:panelGrid columns="2">
<h:outputText value="Username"></h:outputText>
<h:inputText value="#{connect.username}"></h:inputText>
<h:outputText value="Password"></h:outputText>
<h:inputText value="#{connect.password}"/>

 <h:commandButton type="submit" value="Login" action="#{connect.setupcon}"/>
<h:outputText value="#{connect.error}" />
<h:commandButton type="submit" value="Logout" action="#{connect.closecon}" />
<h:outputText value="#{connect.closeerror}" />
</h:panelGrid>
</h:form>  
<a href="tableselect.jsp">table select</a>
 <%-- <form action="/jsfDemo/LoginServlet" method="post">
<table>
<tr>
<td>UserName:</td>
<td><input type="text" name="username" value="<%=connect.getUsername() %>" size="16" /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" value="<%=connect.getPassword() %>" size="16" /></td>
</tr>
<tr>
<td>Press to Login</td>
<td><input type="submit" value = "Login" /></td>
</tr>
</table>
</form> --%>
<br />
<hr />
<br />
</center>
 </f:view> 
</body>
</html>