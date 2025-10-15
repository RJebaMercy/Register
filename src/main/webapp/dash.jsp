<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>

</head>
<body>
 <form action="RegisterDashBoard" method="get">
<div class="dashboard-box">
    <h1>Student Detail</h1>
    <div class="student]nfo">
        <p><strong>Name: ${Name} </strong> </p>
        <p><strong>Email: ${Email} </strong> </p>
        <p><strong>Course: ${Course}</strong> </p>
    </div>
   <a href="logout"><button type="button">Logout</button></a>
</div>
</form>
</body>
</html>
    