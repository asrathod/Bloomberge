<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
<style>
div.dataTables_wrapper {
        margin-bottom: 3em;
    }
</style>
<div class="content-wrapper">

	<!-- <body> -->
	<section class="content">
		<div class="box">
			<div class="box-body">
				<%-- <c:if test="${!empty esiDetailsBeanList}"> --%>
				<c:if test="${not empty message}">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
					</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert alert-warning alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<h4>
							<i class="icon fa fa-warning"></i> ${error}
						</h4>
					</div>
				</c:if>

				<div class="row">
					<form class="form-horizontal" method="GET"
						action="${contextPath}/Bloomberg/listValidAndInvalidDeals">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-5 control-label">Select
								File<span class="text-red">*</span>
							</label>
							<div class="col-sm-4">
								<select class="form-control select2" id="fileId" name="fileId"
									style="width: 100%;">
									<c:forEach items="${fileList }" var="file">
										<option value="${file.id}">${file.fileName}</option>
											<%-- <c:if test="${fileName eq fileList}">selected="selected"</c:if>>${fileName}</option> --%>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-2 col-sm-offset-6">
							<button type="submit" class="btn btn-success btn-block btn-flat">Search
							</button>
						</div>
					</form>
				</div>
				<div class="row">
					<div class="col-md-12">&nbsp;</div>
				</div>
				<hr>
				<div class="generic-container">
					<c:choose>
						<c:when test="${not empty validDealsList}">
							<!-- <table align="left" border="1"> -->
							<div class="panel-heading"><span class="lead"><strong>List of Valid Deals</strong></span></div>
							<!-- <table id="example7" class="table table-bordered table-striped"> -->
							<table class="table table-hover" border = 1>
								<thead>
									<tr>
										<th>Id</th>
										<th>From Currecncy</th>
										<th>To Currecncy</th>
										<th>Amount</th>
										<th>Date</th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${validDealsList}" var="validDealsBean">
										<tr>
											<td align="center">${validDealsBean.id}</td>
											<td align="center">${validDealsBean.fromCurrecncy}</td>
											<td align="center">${validDealsBean.toCurrecncy}</td>
											<td align="center">${validDealsBean.amount}</td>
											<td align="center">${validDealsBean.date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
					<br />		
						<div class="panel-heading"><span class="lead"><strong>List of Invalid Deals</strong> </span></div>
							<table id="example7" class="table table-bordered table-striped" border = 1>
								<thead>
									<tr>
										<th>Id</th>
										<th>From Currecncy</th>
										<th>To Currecncy</th>
										<th>Amount</th>
										<th>Date</th>
										<th>Reason</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach items="${invalidDealsList}" var="invalidDealsBean">
										<tr>
											<td align="center">${invalidDealsBean.id}</td>
											<td align="center">${invalidDealsBean.fromCurrecncy}</td>
											<td align="center">${invalidDealsBean.toCurrecncy}</td>
											<td align="center">${invalidDealsBean.amount}</td>
											<td align="center">${invalidDealsBean.date}</td>
											<td align="center">${invalidDealsBean.reason}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<div class="row">
								<div class="col-md-12" style="color: red; font-size: 30px; text-align: center;">There are no items to display</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</section>
</div>

<script src="${contextPath}/resources/js/newui/jQuery-2.1.4.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	

<script type="text/javascript">
$(document).ready(function() {
    $('example7').DataTable();
} );
</script>

