<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Not Found Error</title>
</head>
<body>
<div align="center">
<div>
    <img src="${pageContext.request.contextPath}/images/BookstoreLogo.png" />
</div>
<div>
    <h2>Sorry, the requested page could not be found!</h2>
</div>
<div>
    <a href="javascript:history.go(-1)">Go Back</a>
</div>
</div>

</body>
</html>