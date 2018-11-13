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
<title>bmiCalculator</title>
</head>
<body>
<f:view>
<center>
<h4>IDS517 BMI Calculator</h4>
<hr />
<a href="index.jsp">Home</a>
<br />
<hr />
<br />
</center>
<h:form>
<h:panelGrid columns="2">
<h:outputText value="User:" />
<h:inputText id="user" value="#{bmiBean.user}" />
<h:outputText value="Units:" />
<h:selectOneListbox value="#{bmiBean.units}" size="2">
<f:selectItem itemValue="SI" itemLabel="SI"/>
<f:selectItem itemValue="English-Imperial"
itemLabel="English-Imperial"/>
</h:selectOneListbox>
<h:outputText value="weight (kg/lbs):" />
<h:inputText id="weight" value="#{bmiBean.weight}" />
<h:outputText value="height (meters/inches):" />
<h:inputText id="height" value="#{bmiBean.height}" />
<h:outputText value="" />
<h:outputText value="" />
<h:commandButton type="submit" value="Reset"
action="#{bmiBean.reset}" />
<h:commandButton type="submit" value="Compute"
action="#{bmiBean.computeBmi}" />
<h:outputText value="" />
<h:outputText value="" />
<h:outputText value="BMI:" />
<h:outputText value="#{bmiBean.bmi}" />
<h:outputText value="BMI Prime:" />
<h:outputText value="#{bmiBean.bmiPrime}" />
<h:outputText value="BMI category:" />
<h:outputText value="#{bmiBean.bmiCategory}" />
<h:outputText value="" />
<h:outputText value="#{bmiBean.errorMessage}" />
</h:panelGrid>
</h:form>
</f:view>
</body>
</html>