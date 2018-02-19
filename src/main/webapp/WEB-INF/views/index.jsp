<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<spring:url value="/static/img/logo1.png" var="favicon" />
<spring:url value="/static/img/grovemade.jpg"	var="coverImg" />
<link rel="icon" href="${favicon}">

<title>Tayfint - Cover</title>
<style>
body {
	background: url(${coverImg}) no-repeat 50% 50%;
}
</style>
<spring:url value="/static/js/jquery.min.js" var="jQuery" />
<spring:url value="/static/css/animate/animate.css"	var="animateCss" />
<spring:url value="/static/css/animate/waypoints.css"	var="waypointCss" />
<spring:url value="/static/js/add-ons/jquery.waypoints.min.js"	var="jQWaypointJs" />
<spring:url value="/static/js/add-ons/waypoints.js"	var="waypointJs" />
<spring:url value="/static/css/bootstrap/bootstrap.min.css"	var="bootstrapCss" />
<spring:url value="/static/css/custom/cover.css"	var="customCss" />
<spring:url value="/static/js/vendor/popper.min.js"	var="popperJs" />
<spring:url value="/static/js/bootstrap/bootstrap.min.js"	var="bootstrapJs" />

<script src="${jQuery}"></script>
<link href="${animateCss}" rel="stylesheet" />
<link href="${waypointCss}" rel="stylesheet" />
<script src="${jQWaypointJs}" type="text/javascript"></script>
<script src="${waypointJs}" type="text/javascript"></script>
<link href="${bootstrapCss}" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${customCss}" rel="stylesheet">
</head>
<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<header class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand os-animation"
							data-os-animation="bounceInLeft" data-os-animation-delay="1s">Tayfint</h3>
						<nav class="nav nav-masthead">
							<a class="nav-link active" href="#">Home</a> <a class="nav-link"
								href="#">Features</a> <a class="nav-link" href="#">Contact</a>
						</nav>
					</div>
				</header>

				<main role="main" class="inner cover os-animation"
					data-os-animation="bounceInUp" data-os-animation-delay="1.5s">
				<h1 class="cover-heading">Rewarding</h1>
				<p class="lead">Behind Tectoo, is a need to computerize the
					collaboration amongst friends. Sign up today and start using Tectoo
					to share ideas, invest in public markets, save some money, and even
					decide on what's going to be the interest rate for your next loan.
					In short, Tectoo let's your money work for you.</p>
				<p class="lead">
					<a href="gettingStarted.html" class="btn btn-lg btn-secondary">Get
						Started</a>
				</p>
				</main>

				<footer class="mastfoot">
					<div class="inner">
						<p>
							&copy; 2017 Tayfint, Inc. &middot; <a href="#">Privacy</a>
							&middot; <a href="#">Terms</a>
						</p>
					</div>
				</footer>

			</div>

		</div>

	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script src="${popperJs}"></script>
	<script src="${bootstrapJs}"></script>
</body>
</html>