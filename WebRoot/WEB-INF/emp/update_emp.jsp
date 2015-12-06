<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
  	<script type="text/javascript" src="../../js/jquery-1.11.3.min.js"></script>
  	<script type="text/javascript" src="../../js/json.js"></script>
  	<script type="text/javascript">
  		function save() {
  			$.ajax({
  				type:"PUT",
  				url:"/SpringMyBatis_Demo/emp/update",
  				data:JSON.stringify($("#myform").serializeObject()),
  				dataType:"json",
  				contentType:"application/json",
  				success:function(data) {
  					location.href = "/SpringMyBatis_Demo/emp/find";
  				}
  			});
  		}
  	</script>
  </head>
  
  <body>
    <%--<form action="updateEmp" method="post">--%>
    <form id="myform">
    	<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
    		<tr>
    			<td>EMPNO：</td>
    			<td>
    				<input type="text" name="empno" value="${emp.empno}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>姓名：</td>
    			<td>
    				<input type="text" name="ename" value="${emp.ename}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>岗位：</td>
    			<td>
    				<input type="text" name="job" value="${emp.job}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>工资：</td>
    			<td>
    				<input type="text" name="sal" value="${emp.sal}"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<%--<input type="submit" value="保存"/>--%>
    				<input type="submit" value="保存" onclick="save();"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
