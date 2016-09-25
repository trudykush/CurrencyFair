<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FrontEnd</title>
</head>
<body>
	<h1>Form page for user details: </h1>

	<FORM ACTION="data.jsp" METHOD="POST">
		Please enter the ID of the publisher you want to find: 
		<BR>
		 <INPUT TYPE="TEXT" NAME="id"> 
		 <BR> 
		 <INPUT TYPE="SUBMIT" value="Submit">
	</FORM>

	<h3>File Upload:</h3>
		<br />
	<form method="post" action="UploadServlet" enctype="multipart/form-data">
	Select file to upload:
	<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
	<input type="submit" value="Upload" />
	</form>

</body>
</html>