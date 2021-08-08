<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Dashboard</title>
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
  font-family: Arial, Helvetica, sans-serif;
  
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 10px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
 <script>
   function foo() {
	   alert("You have Successfully done your bank Detail Thank You!!!!");
	   return true;
	}
   </script>
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
                  <a href="clientlogout" style="color:#fff;">LOGOUT</a>  

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
                        <a href="uploaddetails"><i class="fa fa-table "></i>Upload Details</a>
                        
                    </li>
                    <li class="active-link">
                        <a href="uploadbankdetail"><i class="uploadbankdetail"></i>Upload Bank Detail</a>
                    </li>
                    
                    <li class="active-link">
                        <a href="makepayment"><i class="fa fa-edit "></i>Make Payment</a>
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
                     <h2>Bank Detail </h2>  
                     <form action="savebankdetails" method="post" enctype="multipart/form-data">
  <div class="container">
   
    <hr>

    <label for="email"><b>Pan No</b></label>
    <input type="text" placeholder="Enter Pan Number" name="panno" id="email" required>

    <label for="psw"><b>Name on Pancard</b></label>
    <input type="text" placeholder="Enter Name on Pancard" name="name" id="psw" required>
    
    
    
     <label for="psw"><b>Bank Account Number</b></label>
    <input type="text" placeholder="Enter Bank Account Number" name="accountno" id="psw" required>
    
    <label for="psw"><b> Account Type</b></label>
    <select name="accountype" class="form-control">  
       <option value="--Select Account type-------">Select Account Type</option>   
 	    <option value="saving">Saving accout</option> 
 	    <option value="current">Current account</option> 
</select>
    

	<label for="psw"><b>IFSC CODE</b></label>
    <input type="text" placeholder="Enter IFSC CODE" name="ifsc" id="psw" required>
    
     <label for="psw"><b>Bank Name </b></label>
     <select name="bankname" class="form-control">  
   <option value="--Select Account type-------">Select Bank Name</option>   
  <option value="ALLAHABAD BANK">ALLAHABAD BANK </option>
  <option value="ANDHRA BANK">ANDHRA BANK</option>
  <option value="AXIS BANK">AXIS BANK</option>
  <option value="STATE BANK OF INDIA">STATE BANK OF INDIA</option>
  <option value="BANK OF BARODA">BANK OF BARODA</option>
  <option value="UCO BANK">UCO BANK</option>
  <option value="UNION BANK OF INDIA">UNION BANK OF INDIA</option>
  <option value="BANK OF INDIA">BANK OF INDIA</option>
  <option value="BANDHAN BANK LIMITED">BANDHAN BANK LIMITED</option>
  <option value="CANARA BANK">CANARA BANK</option>
  <option value="GRAMIN VIKASH BANK">GRAMIN VIKASH BANK</option>
  <option value="CORPORATION BANK">CORPORATION BANK</option>
  <option value="INDIAN BANK">INDIAN BANK</option>
  <option value="INDIAN OVERSEAS BANK">INDIAN OVERSEAS BANK</option>
  <option value="ORIENTAL BANK OF COMMERCE">ORIENTAL BANK OF COMMERCE</option>
  <option value="PUNJAB AND SIND BANK">PUNJAB AND SIND BANK</option>
  <option value="PUNJAB NATIONAL BANK">PUNJAB NATIONAL BANK</option>
  <option value="RESERVE BANK OF INDIA">RESERVE BANK OF INDIA</option>
  <option value="SOUTH INDIAN BANK">SOUTH INDIAN BANK</option>
  <option value="UNITED BANK OF INDIA">UNITED BANK OF INDIA</option>
  <option value="CENTRAL BANK OF INDIA">CENTRAL BANK OF INDIA</option>
  <option value="VIJAYA BANK">VIJAYA BANK</option>
  <option value="DENA BANK">DENA BANK</option>
  <option value="BHARATIYA MAHILA BANK LIMITED">BHARATIYA MAHILA BANK LIMITED</option>
  <option value="FEDERAL BANK LTD">FEDERAL BANK LTD </option>
  <option value="HDFC BANK LTD">HDFC BANK LTD</option>
  <option value="ICICI BANK LTD">ICICI BANK LTD</option>
  <option value="IDBI BANK LTD">IDBI BANK LTD</option>
  <option value="PAYTM BANK">PAYTM BANK</option>
  <option value="FINO PAYMENT BANK">FINO PAYMENT BANK</option>
  <option value="INDUSIND BANK LTD">INDUSIND BANK LTD</option>
  <option value="KARNATAKA BANK LTD">KARNATAKA BANK LTD</option>
  <option value="KOTAK MAHINDRA BANK">KOTAK MAHINDRA BANK</option>
  <option value="YES BANK LTD">YES BANK LTD</option>
  <option value="SYNDICATE BANK">SYNDICATE BANK</option>
  <option value="CENTRAL BANK OF INDIA">CENTRAL BANK OF INDIA</option>
  <option value="BANK OF MAHARASHTRA">BANK OF MAHARASHTRA</option>
	</select>
    
     <label for="psw"><b>Branch  Name </b></label>
    <input type="text" placeholder="Enter Branch Name" name="branchname" id="psw" required>
    
     <label for="psw"><b>Mobile Number </b></label>
    <input type="text" placeholder="Enter Mobile nuber" name="mobile" id="psw" required>
    
     <label for="psw"><b>Upload Balance Sheet </b></label>
    <input type="file"  name="files">
    
 
    <hr>
   

    <button type="submit" class="registerbtn" onclick="return foo();">Register</button>
  </div>
  
 
</form> 
                      
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