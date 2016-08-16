<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Hello CDI</title>
</head>
<body>

<h1><c:out value="${title}"/></h1>
<c:out value="${requestCounter.now()}"/>

</body>
</html>