<%--
  Created by IntelliJ IDEA.
  User: luminous
  Date: 2022/9/2
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--  JSP 表达式--%>
<%= new java.util.Date()%>


<%--jsp 脚本片段--%>
<%
int sum = 0;
for(int i = 1;i<=100;i++){
  out.println(sum+=i);
}
%>





  </body>
</html>
