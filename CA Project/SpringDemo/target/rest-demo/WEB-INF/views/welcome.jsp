<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
<h1 align="center">Registration Data</h1>
</head>
<body>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<div class="container">
	<div class="row">
		
                      
              <table id="mytable" class="table table-bordred table-striped" border="3">
                   
                   <thead>
                   
       <tr>
                   <th fontcolor="yellow">  ID </th>
	<th> First Name </th>
	<th> Last Name</th>
	<th> Username   </th>
	<th> Password   </th>
	<th>Date Of Birth     </th>
	<th> Address   </th>
	 <th>Edit</th>
    <th>Delete</th>
  
                   </tr>
                   </thead>
    <tbody>
    
   
    <c:forEach var="j" items="${p}">

<tr>
		<td>${j.id}</td>
				<td>${j.fname}</td>
				<td>${j.lname}</td>
				<td>${j.username}</td>
				<td>${j.password}</td>
				<td>${j.dob}</td>
				<td>${j.address}</td>
	
		
		  <td><a href="edit/${j.id}" data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></a></td>
    <td><a href="delete/${j.id}" onclick="return confirm('Are you want to delete?')" data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete"><span class="glyphicon glyphicon-trash"></span></button></a></td>
	
		
</tr>
</c:forEach>
    
    </tbody>
        

		  </table>
	</div>
</div>
</body>


</html>
    
    