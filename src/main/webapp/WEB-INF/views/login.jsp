<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<spring:url value="/static/img/logo1.png" var="favicon" />
<link rel="icon" href="${favicon}">
<title>Login</title>

<!-- Bootstrap core CSS -->
<spring:url value="/static/css/bootstrap/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/static/css/custom/account.css" var="accountCss" />
<spring:url value="/static/js/vendor/popper.min.js" var="popperJs" />
<link href="${bootstrapCss}" rel="stylesheet">
<link href="${accountCss}" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button"
					data-toggle="collapse" data-target="#navbarsExampleDefault"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Tayfint</a>
			</div>

		</div>
	</nav>

	<header id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-center">
						Admin Area <small> Account Login</small>
					</h1>
				</div>
			</div>
		</div>
	</header>

	<section id="main">
		<div class="container login-form">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<form id="login" action="signin" method="POST" class="well">
						<div class="form-group">
							<label>Username</label> <input type="text" name="username"
								class="form-control" placeholder="Username"/>
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" name="password"
								class="form-control" placeholder="Password"/>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="remember-me"/> Remember me
									</label>
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-default btn-block btn-login">Login</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</div>
			</div>
		</div>
	</section>

	<footer class="footer">
		<div class="container">
			<p>Tayfint, Inc. &copy; 2018</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<spring:url value="/static/js/bootstrap/bootstrap.min.js"	var="bootstrapJs" />
<spring:url value="/static/js/jquery.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<script src="${popperJs}"></script>
<script src="${bootstrapJs}"></script>