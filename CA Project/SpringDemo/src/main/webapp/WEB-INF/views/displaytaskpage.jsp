<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Task</title>
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
   <script>
$(document).ready(function(){
	$("#mytable #checkall").click(function () {
	        if ($("#mytable #checkall").is(':checked')) {
	            $("#mytable input[type=checkbox]").each(function () {
	                $(this).prop("checked", true);
	            });

	        } else {
	            $("#mytable input[type=checkbox]").each(function () {
	                $(this).prop("checked", false);
	            });
	        }
	    });
	    
	    $("[data-toggle=tooltip]").tooltip();
	});


$('a').click(function(){
    return confirm('Are you sure want to Delete?');
});

    </script>
<style>
 body
{
   background-image:url("resources/images/range1.jpg");
	 background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}


    ul{
        padding: 0;
        list-style: none;
        background: white;
        opacity:0.5;
        //color:white;
    }
    ul li{
        display: inline-block;
        position: relative;
        line-height: 21px;
        text-align: left;
    }
    ul li a{
        display: block;
        padding: 8px 25px;
        color: black;
        text-decoration: none;
    }
    ul li a:hover{

        color: #fff;
        background: #939393;
    }
    ul li ul.dropdown{
        min-width: 100%; /* Set width of the dropdown */
        background: #f2f2f2;
        opacity:1;
        display: none;
        position: absolute;
       z-index: 999;
        left: 0;
    }
    ul li:hover ul.dropdown{
        display: block;	/* Display the dropdown */
    }
    ul li ul.dropdown li{
        display: block;
          color:black;
    }
 
 
.center {
 max-width:100%;
    max-height:100%;
    vertical-align: middle;
}


.topright {
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 18px;
}


table{
    font-family:'Calibri';
    font-size:15px;
    background-color:#fff;
    color:#333;
}
.modal-header{
    background-color:#333;
    color:#fff;
}

morquee { color:blue;
		bgcolor="#d9d9ff";
		 }


th { color:black; }
td { color:black;}
</style>
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
                  <a href="emplogout" style="color:#fff;">LOGOUT</a>  

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
                        <a href="clientshow"><i class="fa fa-table "></i>Client Approve</a>
                    </li>
                    <li class="active-link">
                        <a href="displaytask"><i class="fa fa-edit "></i>Display Task </a>
                    </li>

					 <li class="active-link">
                        <a href="displaydocument"><i class="fa fa-edit "></i>Display Document </a>
                    </li>
                    
                    <li class="active-link">
                        <a href="displaybankdocument"><i class="fa fa-edit "></i>Display Bank Document </a>
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
                     <h2>Display Task </h2>   
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
				
				
	
		 <td><a href="status/${j.id}" data-placement="top" data-toggle="tooltip" title="Status">Go</a></td>
		 
    
		
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
                    &copy;  2020 ecssofttech.com | Design by: <a href="http://ecssofttech.com" style="color:#fff;"  target="_blank">www.ecssofttech.com</a>
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