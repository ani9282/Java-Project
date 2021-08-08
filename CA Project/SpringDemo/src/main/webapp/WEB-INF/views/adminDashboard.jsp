<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
 <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Simple Responsive Admin</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="resources/asset/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="resources/asset/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="resources/asset/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>

<div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="resources/asset/img/logo.png" />
                    </a>
                </div>
              
                 <span class="logout-spn" >
                  <a href="adminlogout" style="color:#fff;">LOGOUT</a>  

                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                 

 <li >
                        <a href="#" ><i class="fa fa-desktop "></i>Dashboard</a>
                    </li>
                   

                    <li>
                        <a href="employeeregistration"><i class="fa fa-table "></i>Employee Registration</a>
                    </li>
                    <li class="active-link">
                        <a href="assigntask"><i class="fa fa-edit "></i>Assign task </a>
                    </li>

					<li class="active-link">
                        <a href="attendenceemployee"><i class="fa fa-edit "></i>Attendence Employee </a>
                    </li>
                    
                    <li class="active-link">
                        <a href="selectdateforattendence"><i class="fa fa-edit "></i>Datewise Attendence Employee </a>
                    </li>
                    

<!--  
                 <li>
                        <a href="#"><i class="fa fa-qrcode "></i>My Link One</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i>My Link Two</a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-edit "></i>My Link Three </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table "></i>My Link Four</a>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit "></i>My Link Five </a>
                    </li>-->
                </ul>
                            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Open Task Summary </h2>   
                      <table id="mytable" class="table table-bordred table-striped" border="3">
                   
                   <thead>
                   
       <tr>
                   <th fontcolor="yellow">  ID </th>
	<th> Name </th>
	<th> Date</th>
	<th> Time  </th>
	<th> Task   </th>
	<th> Status   </th>
	<th> Check   </th>
  
                   </tr>
                   </thead>
    <tbody>
    
   
    <c:forEach var="j" items="${p}">

<tr>
		<td>${j.id}</td>
				<td>${j.name}</td>
				<td>${j.date}</td>
				<td>${j.time}</td>			
				<td>${j.task}</td>		
				 <td>${j.status}</td>
				
				
	
		<td><a href="completetask/${j.id}" data-placement="top" data-toggle="tooltip" title="Status">Complete Task</a></td>
		 
   
		
</tr>
</c:forEach>
    
    </tbody>
        

		  </table>
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
              
                 <!-- /. ROW  -->           
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
    <div class="footer">
      
    
             <div class="row">
                <div class="col-lg-12" >
                    &copy;  2020 yourdomain.com | Design by: <a href="http://binarytheme.com" style="color:#fff;"  target="_blank">www.binarytheme.com</a>
                </div>
        </div>
        </div>
          

     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="resources/asset/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="resources/asset/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="resources/asset/js/custom.js"></script>
</body>
</html>