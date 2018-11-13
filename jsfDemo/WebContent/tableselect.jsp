<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Table Select</title>
</head>
<body>

 <f:view> 
 <center>
 <h:form> 

<h:outputText value="#{tableSelect.selectTable}"></h:outputText>
<%-- <h:commandButton type="submit" value="Click to view tables" action="#{tableSelect.init}"/>
<h:selectOneMenu value="#{tableSelect.selectTable}">
 <f:selectItems value="#{tableSelect.tableList}"  var="it" itemValue="#{it}"></f:selectItems>
</h:selectOneMenu> --%>
<h:commandButton type="submit" value="Click to view tables" action="#{tableSelect.init}"/>
<h:selectOneMenu value="#{tableSelect.selectTable}" onchange="submit()"
			valueChangeListener="#{tableSelect.valueChanged}">
 <f:selectItems value="#{tableSelect.tableList}" />
 </h:selectOneMenu>

<h:selectManyListbox value="#{tableSelect.selectedcol}">
<f:selectItems value="#{tableSelect.colnames }" />  
</h:selectManyListbox>	
<h:outputText value="#{tableSelect.selectedcol}"></h:outputText>

</h:form> 
</center> 
 </f:view>

</body>
</html>