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

	var opType = $("#operationType").val();
	var acctType = $("#accountType").val();
	var amt = $("#amount").val();
	var transaction = {
		"operationType" : opType,
		"accountType" : acctType,
		"amount" : amt
	};

	$.ajaxSetup({
		headers : {
			'X-CSRF-TOKEN' : $('input[name="_csrf"]').attr('value')
		}
	});

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/MeetHub/account/deposit",
		data : JSON.stringify(transaction),
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
	$('#confirmationMsg').html($(data).find('#dw_result'));
	$('#confirmationMsg').fadeIn("slow");
}