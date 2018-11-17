/**
 * 
 */

jQuery(document).ready(function($) {

	$("#depositForm").submit(function(event) {

		// Disble the search button
		enableSearchButton(false);

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		depositOrWithdraw();

	});

});

function depositOrWithdraw() {

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/MeetHub/account/deposit",
		data : $("#depositForm").serialize(),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
			enableSearchButton(true);
		}
	});

}

function enableSearchButton(flag) {
	$("#deposit").prop("disabled", flag);
}

function display(data) {
	var json = "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"> " +
			"<span aria-hidden=\"true\">&times;</span> </button>" +
			+ JSON.stringify(data, null, 4);
	$('#confirmationMsg').html(json);
}