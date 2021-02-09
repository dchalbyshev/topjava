<%@ page import="java.util.List" %>
<%@ page import="ru.javawebinar.topjava.model.Meal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="ru.javawebinar.topjava.model.Meal" %>

<html lang="ru">
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>

<ul>
    <li><a href="users">users</a></li>
</ul>

<hr>
<ul>
    <li><a href="users">Users</a></li>
    <li><a href="meals">Meals</a></li>
</ul>

      <table  border="2">
         <thead>

          <th>Date</th>
          <th>Description</th>
          <th>Calories</th>


         </thead>
          <tbody>

                  <% List<Meal> list = (List)request.getAttribute("meals");
                  for(Object meal: list){%>
                  <tr>
                      <td><%= ((Meal)meal).getDate()%> </td>
                      <td><%= ((Meal)meal).getDescription()%> </td>
                      <td><%= ((Meal)meal).getCalories()%> </td>
              </tr>
                  <%}%>

          </tbody>

          </table>








    </table>




</body>
</html>
