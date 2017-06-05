<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, demo.jpa.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JPA Demo</title>
</head>
<body>
	<h2>JPA Persistence Demo</h2>
	<p>This is a little demo project to test out JPA. Following is a
		list of registered Users, which may be empty.</p>
	<%
		@SuppressWarnings("unchecked") // because of unchecked type cast
		List<User> users = (List<User>) request.getAttribute("users");
		String postTo = (String) request.getAttribute("postTo");
	%>
	<ul>
		<%
			for (User user : users) {
		%>
		<li>
			<%
				out.println(user.toString());
			%>
		</li>
		<%
			}
		%>
	</ul>
	Create new User:
	<form action="<%out.println(postTo + "/DbServlet");%>" method="post">
		<input type="text" name="username">
		<button type="submit">Submit</button>
	</form>
</body>
</html>
