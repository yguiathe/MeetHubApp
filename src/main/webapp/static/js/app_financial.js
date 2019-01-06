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
	
	$("#checking > div.table-responsive > ul > li > a").click(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();

		loadNextTrxPage($(this).attr('href'));

	});

});

function setAjaxHeader(){
	$.ajaxSetup({
		headers : {
			'X-CSRF-TOKEN' : $('input[name="_csrf"]').attr('value')
		}
	});
}

function loadNextTrxPage(url){
	setAjaxHeader();
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : 'html',
		timeout : 100000,
		success : function(data) {
			showNextTrxPage(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			showNextTrxPage(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function showNextTrxPage(data){
	console.log(data);
	console.log($(data).find('#trxPage'));
	$('#checkingTrxTbl tbody').html($(data).find('#trxPage').html());
	$('#checkingTrxTbl tbody').fadeIn("slow");
}

function depositOrWithdraw() {

	var opType = $("#operationType").val();
	var acctType = $("#accountType").val();
	var amt = $("#amount").val();
	var transaction = {
		"operationType" : opType,
		"accountType" : acctType,
		"amount" : amt
	};

	setAjaxHeader();

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/MeetHub/account/deposit",
		data : JSON.stringify(transaction),
		dataType : 'html',
		timeout : 100000,
		success : function(data) {
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
	$('#confirmationMsg').html($('<div />').append(data).find('#dw_result'));
	$('#confirmationMsg').fadeIn("slow");
}