<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory Management</title>
<head>
<link rel="stylesheet" href="pages/css/jquery-ui.css">
<script src="pages/js/jquery.min.js"></script>
<script src="pages/js/jquery-1.10.2.js"></script>
<script src="pages/js/jquery-ui.js"></script>

<style>
    .error {
        color: red; font-weight: bold;
    }
    
	.list {    
	    border: 1px solid #ddd;
	    text-align: left;
	    border-collapse: collapse;
	    width: 100%;
	    padding: 15px;
	    margin-top: 25px;
	}

</style>

<script type="text/javascript">

	$(function() {
		var date = $('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val();
	  });

	function searchAjax(id) {
		
		$.ajax({
			type : "GET",
			url: "inventory/"+id,
			success : function(data) {
				var html = "<tr><td>"+ data.inventaryName +"</td>" +
				"<td>"+ data.department.departmentName +"</td>" +
				"<td>"+ data.department.address +"</td>" +
				"<td>"+  data.department.ownerEmail+"</td>" +
				"<td>"+ data.inventoryType.type +"</td>" +
				"<td>"+ data.expiryDate +"</td></tr>" ;
				$("#inventoryDisplay").append(html);
			}
		});
	}

</script>
</head>
<body>
	<div>
		<div>
			<table>
				<th>Inventory List :</th>
				<c:if test="${! empty inventories}">
					<c:forEach var="inventory" items="${inventories}">
						<tr>
							<td onClick="javascript:searchAjax(${inventory.id})"><c:out
									value="${inventory.inventaryName}" /></a></td>

						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div align="center">
			<h1>Inventory Form :</h1>
			<table>
				<form:form action="saveInventory" method="post"
					modelAttribute="inventory">
					<form:hidden path="id" />
					<tr>
						<td>Inventory Name:</td>
						<td><form:input path="inventaryName" /></td>
						<td><form:errors path="inventaryName" cssClass="error" /></td>
					</tr>

					<tr>
						<td>Department Name :</td>
						<td><form:input path="department.departmentName" /></td>
						<td><form:errors path="department.departmentName"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td>Department Address:</td>
						<td><form:textarea path="department.address" /></td>
						<td><form:errors path="department.address" cssClass="error" /></td>
					</tr>

					<tr>
						<td>Owner Email:</td>
						<td><form:input path="department.ownerEmail" /></td>
						<td><form:errors path="department.ownerEmail"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td>Inventory Type:</td>
						<td><form:select path="inventoryTypeId"
								items="${inventoryTypes}" itemValue="id" itemLabel="type">
							</form:select></td>
						<td><form:errors path="inventoryTypeId" /></td>
					</tr>
					<tr>
						<td>Expiry Date:</td>
						<td><form:input path="expiryDate" id="datepicker" /></td>
						<td><form:errors path="expiryDate" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</form:form>
			</table>
		</div>
		<div class="list">
			<table style="border-collapse: collapse; width: 100%;"
				id="inventoryDisplay">
				<tr>
					<th>Inventory Name</th> <th>Department Name</th> <th>Department Address</th> <th>Owener Email</th> <th>Inventory Type</th>
					<th>Expiry Date</th>
				</tr>

			</table>
		</div>
	</div>
</body>

</html>