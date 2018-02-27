<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<jsp:include page="fragments/header.jsp" />

<section id="breadcrumb">
	<div class="container">
		<ol class="breadcrumb">
			<li class="active">Registration</li>
		</ol>
	</div>
</section>

<section id="main">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="index.html" class="list-group-item active main-color-bg">
						<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
						Steps
					</a> <a href="#about-you" class="list-group-item"><span
						class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
						About You</a> <a href="#credentials" class="list-group-item"><span
						class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
						Credentials</a> <a href="#other" class="list-group-item"><span
						class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
						Additional Info</a>
				</div>

				<div class="well">
					<h4>User Agreement</h4>
					<p>By clicking Sign Up, you agree to our Terms and that you
						have read our Data Policy, including our Cookie Use.</p>
				</div>
			</div>
			<div class="col-md-9">
				<form:form method="POST" action="register.go"
					modelAttribute="user">
					<div class="panel panel-default">
						<div class="panel-heading tabbed-nav main-color-bg">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#about-you">About
										You</a></li>
								<li><a data-toggle="tab" href="#credentials">Credentials</a></li>
								<li><a data-toggle="tab" href="#other">Additional Info</a></li>
							</ul>
						</div>
						<div class="panel-body tab-content">
							<div id="about-you" class="tab-pane fade in active">

								<div class="form-group form-inline">
									<label for="name_label" class="col-md-2 form-labels">Your
										Name</label>
									<div class="form-group">
										<form:input path="firstName" type="text" class="form-control"
											name="firstname" id="firstname" placeholder="First Name" />
									</div>
									<div class="form-group">
										<form:input path="middleName" type="text" class="form-control"
											name="middlename" id="middlename" placeholder="Middle Name" />
									</div>
									<div class="form-group">
										<form:input path="lastName" type="text" class="form-control"
											name="lastname" id="lastname" placeholder="Last Name" />
									</div>
								</div>
								<div class="form-group form-inline">
									<label for="birthday" class="col-md-2 form-labels">Date
										of Birth</label>
									<form:input path="birthdate" type='date' class="form-control"
										name="birthdate" id="birthdate" />
								</div>
								<div class="form-group">
									<label for="gender" class="col-md-2 form-labels">Gender</label>
									<label class="radio-inline"> <form:radiobutton
											path="gender" name="gender" id="male" value="M" /> Male
									</label> <label class="radio-inline"> <form:radiobutton
											path="gender" name="gender" id="female" value="F" /> Female
									</label>
								</div>
								<div class="form-group form-inline">
									<label for="marital_status" class="col-md-2 form-labels">Marital
										Status</label>
									<form:select path="maritalStatusCd" id="marital_status"
										class="form-control">
										<option value="0">Single</option>
										<option value="1">Married</option>
										<option value="2">Divorced</option>
										<option value="3">Widow</option>
									</form:select>
								</div>
								<div class="form-group form-inline">
									<label for="citizenship" class="col-md-2 form-labels">Citizenship</label>
									<div class="form-group">
										<form:input path="citizenship" type="text"
											class="form-control" name="citizenship" id="citizenship"
											placeholder="Cameroonian" />
									</div>
								</div>

								<div class="form-group form-inline">
									<label for="primaryIdType" class="col-md-3 form-labels">Primary	ID Type </label>
									<form:select path="primaryIdType" id="primaryIdType"
										class="form-control">
										<option value="PP">Passport</option>
										<option value="SSN">SSN</option>
										<option value="NID">National ID</option>
										<option value="Others">Others</option>
									</form:select>
								</div>
								<div class="form-group form-inline">
									<label for="primaryId" class="col-md-2 form-labels">ID #</label>
									<div class="form-group">
										<form:input path="primaryId" type="text"
											class="form-control" name="primaryId" id="primaryId"
											placeholder="12345566" />
									</div>
								</div>

								<%-- <div class="form-group">
									<label for="picture" class="col-md-2 form-labels">Profile
										Picture</label>
									<form:input path="picture" type="file" id="picture" />
								</div> --%>
							</div>
							<div id="credentials" class="tab-pane fade">
								<div class="form-group form-inline">
									<label for="email" class="col-md-3 form-labels">Email</label>
									<form:input path="email" type="email" class="form-control"
										name="email" id="email" placeholder="yguiathe@tayfint.com" />
								</div>
								<div class="form-group form-inline">
									<label for="username" class="col-md-3 form-labels">Username</label>
									<form:input path="username" type="text" class="form-control"
										name="username" id="username" placeholder="tayfint.10" />
								</div>
								<div class="form-group form-inline">
									<label for="password" class="col-md-3 form-labels">Password</label>
									<form:input path="password" type="password"
										class="form-control" name="password" id="password"
										placeholder="password1" />
								</div>
								<div class="form-group form-inline">
									<label for="cpassword" class="col-md-3 form-labels">Confirm
										Password</label>
									<form:input path="confirmPassword" type="password"
										class="form-control" name="cpassword" id="cpassword"
										placeholder="password1" />
								</div>
							</div>
							<div id="other" class="tab-pane fade">
								<div class="form-group form-inline">
									<label for="occupation" class="col-md-3 form-labels">Occupation</label>
									<div class="form-group">
										<form:input path="occupation" type="text" class="form-control"
											name="occupation" id="occupation"
											placeholder="Systems Analyst" />
									</div>
								</div>
								<div class="form-group form-inline">
									<label class="col-md-3 form-labels" for="salary">Monthly
										Income (in dollars)</label>
									<div class="input-group">
										<div class="input-group-addon">$</div>
										<form:input path="monthlySalary" type="text"
											class="form-control" id="salary" placeholder="200000" />
										<div class="input-group-addon">.00</div>
									</div>
								</div>
								<div class="form-group form-inline">
									<label for="education" class="col-md-3 form-labels">Highest
										Level of Education</label>
									<div class="form-group">
										<form:input path="education" type="text" class="form-control"
											name="education" id="education"
											placeholder="Masters in Cybersecurity" />
									</div>
								</div>

								<div class="form-group form-inline">
									<label for="employmentstatuscd" class="col-md-3 form-labels">Employment
										Status</label>
									<form:select path="employmentStatusCd" id="employmentstatuscd"
										class="form-control">
										<option value="0">Self-Employed</option>
										<option value="1">Employed</option>
										<option value="2">Unemployed</option>
										<option value="3">Retired</option>
									</form:select>
								</div>
								<div class="form-group form-inline">
									<label for="employer" class="col-md-3 form-labels">Employer</label>
									<div class="form-group">
										<form:input path="employer" type="text" class="form-control"
											name="employer" id="employer" placeholder="Actimize, Inc." />
									</div>
								</div>

							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-9"></div>
								<div class="col-md-3">
									<button type="submit" class="btn btn-default all-btn">Sign
										Up</button>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>
