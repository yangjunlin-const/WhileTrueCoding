<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<div align="left">
    <table height="60" border="0" align="left">
        <tr>
            <td>
                <form name="test" action="<%=request.getContextPath() %>/user/get" method="post">
                    userId:
                    <input type="text" name="userId"/>
                    <br/>
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>

<%--<script type="text/javascript">
    function getUser() {
        var form = document.forms[0];
        form.action = "${pageContext.request.contextPath}/user/addUser1";
        form.method = "post";
        form.submit();
    }
</script>--%>
</html>
