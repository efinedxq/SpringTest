<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Test</title>
</head>
<body>
	<s:form action="controller">
		<s:actionerror />
		<s:textfield name="stuId" label="学生id" />
		<s:submit value="查 询" />
		<s:if test="student!=null">学生姓名：${student.studentName}<br>学生id :${student.stuId}</s:if>
	</s:form>
</body>
</html>