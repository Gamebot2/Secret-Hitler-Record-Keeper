<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedWriter" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Scanner" %>
<%
/** Log POSTs at / to a file **/
if ("POST".equalsIgnoreCase(request.getMethod())) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/sample-app.log", true));
        Scanner scanner = new Scanner(request.getInputStream()).useDelimiter("\\A");
	if(scanner.hasNext()) {
		String reqBody = scanner.next();
		writer.write(String.format("%s Received message: %s.\n", (new Date()).toString(), reqBody));
	}
        writer.flush();
        writer.close();
	
} else {
%>
<!DOCTYPE html>
<html>
  <head>
        <title>Secret Hitler Records</title>
        <link rel = "stylesheet" href = "HomeStyle.css">
        <link rel = "stylesheet" href = "animate.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel = "icon" href = "img/favicon-16x16.png" type="image/x-icon">
    </head>
    <body>
        <div class = "spacer"></div>
        <div class = "text">
            <h1 class = "animated fadeInDown">Secret Hitler</h1><h1 class = "animated fadeInDown">Records</h1>
            <button class = "animated fadeInUp" onclick="window.location.href='RecordsPage.html'">Enter Here</button>
        </div>
    </body>
</html>
<% } %>
