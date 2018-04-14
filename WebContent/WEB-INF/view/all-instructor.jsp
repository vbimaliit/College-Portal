<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>

<title>Customer</title>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
		<div id="wrapper">
			<div id="header">
			<h2> College Instructor Portal</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
			<input type ="button"   value ="AddInstructor"
			onclick = "window.location.href='addinstructor' ; return false"/>
			
			<input type ="button"   value ="Courses"
			onclick = "window.location.href='showcourses' ; return false"/>
			
			
			<br> <br>
			<form:form action ="searchinstructor" ModelAttribute ="instructorname" method ="POST">
			Search Customer <input type="text" name="instructorname"/>
			<input type="submit" value ="Search" />
			</form:form>
			
			<br> <br>
			<table>
			       <tr>
			       <th> Firstname </th>
			       <th> Lastname </th>
			       <th> Email_id </th>
			       <th>Action</th>
			       </tr>
			       
			       <c:forEach var="tempinstructor" items="${allinstructor}">
			       <c:url var="updatelink"  value ="/mainclass/updateinstructor">
			       <c:param name="tempinstructor_id" value="${tempinstructor.id }" />
			       </c:url>
			       
			       
			       <c:url var="deletelink"  value ="/mainclass/delete">
			       <c:param name="tempinstructor_id" value="${tempinstructor.id }" />
			       </c:url>
			       
			       <tr>
			       		<td>${tempinstructor.firstname}</td>
			       		<td>${tempinstructor.lastname}</td>
			       		<td>${tempinstructor.email_id}</td>
			       		<td><a href ="${updatelink}">update</a>
							<a href ="${deletelink}" 
							onclick="if(!(confirm('Are you sure you want to delete this')))return false">|delete</a>			       		
			       		</td>
			       	</tr>
			       	</c:forEach>
			       
			</table>
			</div>
		</div>
		
		
</body>
</html>