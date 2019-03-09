<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <% 
	  HttpSession session=request.getSession(false);
	  if(session!=null){
		  session.invalidate();
	  }
      String redirect = response.encodeRedirectURL(request.getContextPath() + "/Login.jsp" );
      response.sendRedirect(redirect);
      %>
</body>
</html>