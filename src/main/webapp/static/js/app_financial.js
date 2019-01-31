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

//* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
	  this.classList.toggle("main-color-bg");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
      this.classList.remove("main-color-bg");
      document.getElementById("top-menu").style.color = "";
      dropdownContent.style.display = "none";
    } else {
      document.getElementById("top-menu").style.color = "white";
      dropdownContent.style.display = "block";
    }
  });
}