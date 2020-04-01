<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<style>
	body {
    margin: 0px;
    padding: 0px;
    background: #ccc;
}
ul {
    position: absolute;
    top: 80%;
    left: 50%;
    transform: translate(-50%, -50%);
    margin: 0;
    padding: 0;
    display:flex;
}
ul li {
    list-style-type: none;
    margin: 0 40px;
}
ul li a .fa {
    font-size: 40px;
    color: #262626;
    line-height: 80px;
    transition: 1s;
}
ul li a {
    position: relative;
    display: block;
    width: 100px;
    height: 80px;
    background:#fff;
    text-align: center;
    transform: perspective(1000px) rotate(-30deg) skew(25deg) translate(0,0);
    box-shadow:rgba(0,0,0,0.5) -20px 20px 10px;
}
ul li a:before {
    content:'';
    position: absolute;
    top:10px;
    left:-20px;
    height:100%;
    width:20px;
    background:#b1b1b1;
    transform: rotate(0deg) skewY(-45deg)
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to XXXXX Airlines</h3>
	<h3>
		The only user is "<b>super</b>" and the password is "<b>pw</b>"
	</h3>
	<div>
		<a href="<c:url value="/secure" />"> Go to Secure Page </a>
	</div>	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>