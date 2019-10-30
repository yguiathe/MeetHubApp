$(function() {
	// Menu toggle script
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("menuDisplayed");
	});
	
	$(".app-v-nav > li > a").not(":last").click(function() {
		$(".app-v-nav > li > a").not(":last").parent().removeClass("active");
		$("#page-content-wrapper > div.content:visible").toggleClass("d-none");
		$(this).parent().toggleClass("active");
		fetchTabContent($(this).attr('href'), false);
		$($(this).attr('href')).removeClass("d-none");
	});
	
	$('[data-toggle="tooltip"]').tooltip();
});

function fetchTabContent(tabId, reload) {
	console.log(tabId);
	switch (tabId) {
		case "#profile-tab":
			break;
		case "#teams-tab":
			$.get(getAppContext() + "Memberships", function(data) {
				console.log("A");
				$(tabId).html(data);
			});
			break;
		case "#applications-tab":
			break;
		case "#notifications-tab":
			break;
	}
}

function getAppContext() {
	var loc = window.location;
	return loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
}