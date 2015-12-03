<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>员工列表示例</title>
  </head>
  
  <body>
    <table border="1">
    	<tr>
    		<td>EMPNO</td>
    		<td>ENAME</td>
    		<td>JOB</td>
    		<td>MGB</td>
    		<td>HIREDATE</td>
    		<td>SAL</td>
    		<td>COMM</td>
    		<td>DEPTNO</td>
    	</tr>
    	<c:forEach items="${emps}" var="emp">
    	<tr>
    		<td>${emp.empno}</td>
    		<td>${emp.ename}</td>
    		<td>${emp.job}</td>
    		<td>${emp.mgr}</td>
    		<td>${emp.hiredate}</td>
    		<td>${emp.sal}</td>
    		<td>${emp.comm}</td>
    		<td>${emp.deptno}</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
