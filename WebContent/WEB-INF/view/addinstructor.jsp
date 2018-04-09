<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>

<title>Add Instructor</title>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
		  
		  
</head>
<body>
	<div id="wrapper">
			<div id="header">
			<h2> College Portal</h2>
			</div>
		</div>
		
		<div id = "container">
		<h3>Add Instructor </h3>
		<form:form action="processinstructor" modelAttribute="combinedobject" method="POST">
		<form:hidden path = "inst.id" />
		
		
		
		<table>
		<tbody>
		 <tr>
		 <td><label>First name</label></td>
		 <td><form:input path="inst.firstname"/></td>
		 </tr>
		 
		 <tr>
		 <td><label>Last name</label></td>
		 <td><form:input path="inst.lastname"/></td>
		 </tr>
		 
		 
		 <tr>
		 <td><label>Email_id</label></td>
		 <td><form:input path="inst.email_id"/></td>
		 </tr>
		  
		  <tr>
		 <td><label>Hobby</label></td>
		 <td><form:input path="inst_det.hobby"/></td>
		 </tr>
		 
		 <tr>
		 <td><label>Youtube Channel</label></td>
		 <td><form:input path="inst_det.youtube_channel"/></td>
		 </tr>
		  
		  
		  
		  <tr>
		  <td> <label></label></td>
		  <td><input type ="submit" value ="save" class="save" /></td>
		  </tr>
		</tbody>
		</table>
		</form:form>
		</div>
</body>
</html>