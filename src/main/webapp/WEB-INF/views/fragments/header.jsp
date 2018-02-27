<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<spring:url value="/static/img/logo1.png" var="favicon" />
<link rel="icon" href="${favicon}">
<title>Sign Up</title>

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
			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item active">
						<form class="navbar-form navbar-right" method="POST"
							action="<spring:url value="/signin"/>">
							<div class="form-group">
								<input type="text" placeholder="Email" name="username"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="password" placeholder="Password" name="password"
									class="form-control">
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" name="remember-me"> Remember me
								</label>
							</div>
							<button type="submit" class="btn btn-success all-btn">Login</button>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<header id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<h1>
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
						Sign Up <small> Setup An Account</small>
					</h1>
				</div>
			</div>
		</div>
	</header>
	    <!-- <nav class="navbar navbar-default">
      <div class="container-fluid">
        Brand and toggle get grouped for better mobile display
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Tayfint | Name</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <ul class="nav navbar-nav">
            <li>
              <a href="#"></a>
            </li>
            <li class="active">
              <a class="nav-link" href="#">Dashboard<span class="sr-only">(current)</span></a>
            </li>
            <li>
              <a class="nav-link" href="pages.html">Pages</a>
            </li>
            <li>
              <a class="nav-link" href="posts.html">Posts</a>
            </li>
            <li>
              <a class="nav-link" href="users.html">Users</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="nav-item active">
              <a class="nav-link" href="#">Welcome, Yvan</a>
            </li>
            <li>
              <a class="nav-link" href="login.html"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <header id="header">
      <div class="container">
        <div class="row">
          <div class="col-md-10">
            <h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Dashboard <small>Manager Your Site</small></h1>
          </div>
          <div class="col-md-2">
            <div class="dropdown create">
              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Create Content
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a type="button" data-toggle="modal" data-target="#addPage">Add Page</a></li>
                <li><a href="#">Add Post</a></li>
                <li><a href="#">Add User</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </header> -->