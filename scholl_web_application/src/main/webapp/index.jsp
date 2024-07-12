<%-- 
    Document   : index
    Created on : 27 may 2024, 11:25:14 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String dataLoginResponse = (String) session.getAttribute("dashboard");
%>
<html>
    <jsp:include page="views/inic/Head.jsp" />
    <body>
        <%
            
            if (dataLoginResponse != null) {
        %>
        <jsp:include page="views/auth/Auth.jsp"/>
        <%
            }else{
        %>
        <jsp:include page="views/dashboard/Dashboard.jsp" />
         <%
            }
        %>
    </body>
</html>
