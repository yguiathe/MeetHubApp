<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar navbar-default navbar-fixed-bottom">
	<div class="container footer">
		<p>Tayfint, Inc. &copy; 2018</p>
	</div>
</nav>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<spring:url value="/static/js/bootstrap/bootstrap.min.js"	var="bootstrapJs" />
<spring:url value="/static/js/jquery.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<script src="${popperJs}"></script>
<script src="${bootstrapJs}"></script>