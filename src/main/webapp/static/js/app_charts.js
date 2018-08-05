function getFinSummaryChart(){
	ctx = document.getElementById("myChart");
	if(ctx != null){
		var myDoughnutChart = new Chart(ctx, {
			type : 'doughnut',
			data : {
				datasets : [ {
					data : [ 10, 20, 30 ],
					backgroundColor : [ "#009eda", "#afc836", "orange" ]
				} ],

				// These labels appear in the legend and
				// in the tooltips when
				// hovering different arcs
				labels : [ 'Contributions', 'Savings', 'Loans' ]
			},
			options : {
				responsive: true,
				legend: {
					position: 'top',
				},
				animation: {
					animateScale: true,
					animateRotate: true
				}
			}
		});
	}
}

getFinSummaryChart();

