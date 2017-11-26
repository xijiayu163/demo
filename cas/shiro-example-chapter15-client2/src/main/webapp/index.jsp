<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<form id="serarchForm" action="logout">
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/cas-login">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录<br/>
</shiro:user>
<shiro:hasRole name="admin">
    您有角色admin
</shiro:hasRole>

<a href="/chapter15-client/test" class="myBtn"><em>查询</em></a>
<a href="javascript:logout();" class="myBtn"><em>登出</em></a>

<script type="text/javascript">
	function logout(){
		document.getElementById("serarchForm").submit();
	}
</script>
</form>
</body>
</html>
