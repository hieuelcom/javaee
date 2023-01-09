<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib pre fix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Name Collector</title>
    </head>
    <body>
        <h4>Enter your name </h4>
    <s:form action="hello">
        <s:textfield name="name" label="Your name"/>
        <s:submit/>
    </s:form>
</body>
</htm>