/**
 * 
 */

jQuery(document).ready(function($) {

	$("#depositForm").submit(function(event) {

		// Disble the search button
		enableDepositButton(false);

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		depositOrWithdraw();

	});
	
	$("#checking > div.table-responsive > ul > li > a").click(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();

		loadNextTrxPage($(this).attr('href'));

	});
	
	$("#deposit-btn").click(function(event){
		$("#depositDiv").show();
	});
	
	$("#depositFormClose-btn").click(function(event){
		$("#depositDiv").hide();
	});

	$(".account-list").click(function(){
		getAccountDetails();
		getIOTrendChart();
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
	$('#checkingTrxTbl tbody').html($(data).find('#trxPage > tr'));
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
			enableDepositButton(true);
		}
	});

}

function enableDepositButton(flag) {
	$("#deposit").prop("disabled", flag);
}

function display(data) {
	$('#confirmationMsg').html($('<div />').append(data).find('#dw_result'));
	$('#confirmationMsg').fadeIn("slow");
}

function getAccountDetails() {
	setAjaxHeader();
	
	//create url to request fragment
    var url = "/MeetHub/User/Accounts/1";

    //load fragment and replace content
    $('#myAccounts').fadeOut("slow").load(url).fadeIn('slow');
}

function activateAccount(event, id) {
	  alert("Hello button!" + id);
	  event.stopPropagation();
}