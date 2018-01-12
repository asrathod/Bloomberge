<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Deals</title>
<link href="<c:url value='/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>

<body>
<%-- 	<c:forEach var="message" items="${message}">
		<span>${error}</span>
		<br />
	</c:forEach> --%>
	<c:if test="${not empty error}">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-warning"></i> ${error}
				</h4>
			</div>
		</c:if>
	
	<div class="generic-container">
		
		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">New Document Upload Page</span>
			</div>
			
			<div class="uploadcontainer">
				<form:form method="POST" modelAttribute="uploadForm"
					action="${contextPath}/Bloomberg/saveFileData" enctype="multipart/form-data"
					class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<br> <label class="col-md-2 control-lable" for="file"
								style="margin-left: 30px">Upload a File :</label>
							 <div class="col-md-2"> 
								<!-- <br> -->
								 <table id="fileTable">
									 <tr> 
										<td><input type="file" name="file" id="file"
											class="form-control input-sm" />
											<span id="lblError" style="color: red;"></span>
											<div class="has-error">
												<form:errors path="file" class="help-inline" />
											</div></td>
									 </tr> 
								 </table> 
							 </div> 
						</div>
					</div>

					<div class="row" align="center">
						<div class="form-actions floatRight">
							<input type="submit" value="Upload"
								class="btn btn-primary btn-sm" id="btnUpload">
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
    $("body").on("click", "#btnUpload", function () {
        var allowedFiles = [".csv"];
        var fileUpload = $("#file");
        var lblError = $("#lblError");
        var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
        if (!regex.test(fileUpload.val().toLowerCase())) {
            lblError.html("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
            return false;
        }
        lblError.html('');
        return true;
    });
</script>
</body>
</html>
