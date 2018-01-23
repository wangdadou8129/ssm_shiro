<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎<shiro:principal/>登录
	   <shiro:hasAnyRoles name="manager">
	   		<shiro:principal/>有manager:*权限
	   </shiro:hasAnyRoles>
	   <shiro:authenticated>
	   		<shiro:principal/>被认证
	   </shiro:authenticated>
	   <shiro:hasPermission name="manager:*">
	   		<shiro:principal/>有manager:*权限
	   </shiro:hasPermission>
</body>
</html>