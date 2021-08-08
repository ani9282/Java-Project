<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
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
   <style>
        body {
  margin: 0;
  padding: 0;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin-top: 5px;
  max-width: 600px;
  height: 850px;
   margin-left:200px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
.state{
    width:100%;
            height: 32px;
        }
   body {
            margin: 0;
            font-family: "Lato", sans-serif;
        }

        .sidebar {
            margin: 0;
            padding: 0;
            width: 200px;
            background-color: #f1f1f1;
            position: fixed;
            height: 100%;
            overflow: auto;
        }

            .sidebar a, .dropdown-btn {
                display: block;
                color: black;
                padding: 16px;
                text-decoration: none;
                text-align: center;
            }

                .sidebar a.active, .dropdown-btn.active {
                    background-color: #4CAF50;
                    color: white;
                }

                .sidenav a:hover, .dropdown-btn:hover {
                    color: #f1f1f1;
                }

        .active {
            background-color: green;
            color: white;
        }

        .sidebar a:hover:not(.active), .dropdown-btn:hover:not(.active) {
            background-color: #555;
            color: white;
        }

        .dropdown-container {
            display: none;
            background-color: #f1f1f1;
            padding-left: 8px;
        }

        div.content {
            margin-left: 200px;
            padding: 0px 1px;
            height: 700px;
            width: 1037px;
        }

        .fa-caret-down {
            float: right;
            padding-right: 8px;
        }

        @media screen and (max-width: 700px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }

                .sidebar a {
                    float: left;
                }

            div.content {
                margin-left: 0;
            }
        }

        @media screen and (max-width: 400px) {
            .sidebar a {
                text-align: center;
                float: none;
            }
        }

        </style>
        <style>
            .center {
 margin: auto;
  width: 50%;
  padding: 0px;
  color:red;
}

 input[type=submit] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 20px 20px;
  text-decoration: none;
   text-align:center; 
  margin: 4px 2px 1px 1px ;
  cursor: pointer;
  
  .err
{
	color:blue;
}
	
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
            <div id="page-inner" style="background-image: url('http://www.businessnewsdaily.com/images/i/000/007/874/original/free-business-plan-templates.jpg'); background-repeat: no-repeat;   background-size: 100% 100%;">
                <div class="row">
                    <div class="col-md-12">
                     <h2 align="center" style="color:white">Employee Registration </h2>   
                     <div id="login">
       <form action="empregister" method="post">
     
        <div class="container">
         <h1 class="err">${msg}</h1>
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                         <div id="login-box" class="col-md-12">
                   
                            <h3 class="text-center text-info">&nbsp;</h3>
                            <div class="form-group">
                                <label for="username" class="text-info"> Name:</label><br>
                                <input type="text" name="username" id="username" class="form-control" value="" runat="server" required/>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Address:</label><br>
                                <input type="text" name="add" id="add" class="form-control" runat="server" required/>
                            </div>
                             <div class="form-group">
                                <label for="password" class="text-info">Mobile No:</label><br>
                                <input type="text" name="mobile" id="mob" class="form-control" runat="server" maxlength="10"  required/>
                            </div>
                              
                            <div class="form-group">
                                <label for="password" class="text-info">Email:</label><br>
                                <input type="text"  name="email" id="email" class="form-control" runat="server" required/>
                            </div>
                              <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control" runat="server" required/>
                                  </div>
                                  
                                    <div class="form-group">
                                <label for="password" class="text-info">Confirm Password:</label><br>
                                <input type="password" name="cpassword" id="password" class="form-control" runat="server" required/>
                                  </div>
                                  
                                    <div class="form-group">
                                <label for="password" class="text-info">Date Of Birth:</label><br>
                                <input type="date" name="dob" id="password" class="form-control" runat="server" required/>
                                  </div>
                                  
                                    <div class="form-group">
                                <label for="password" class="text-info">Employee Position</label><br>
                                <input type="text" name="position" id="password" class="form-control" runat="server" required/>
                                  </div>
                                  
                                  
                                  <br>
                                  <div class="form-group">
                                <input type="submit" value="sumbit"  class="form-control" style="font-size:12pt;color:white;background-color:green;border:2px solid #336600;padding:3px" />
                                  </div>

                           
                           
                          
            
                    </div>
      


   </div>
                </div>
          </div></form>
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