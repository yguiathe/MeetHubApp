function getFinSummaryChart() {
	ctx = document.getElementById("myChart");
	if (ctx != null) {
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
				responsive : true,
				legend : {
					position : 'top',
				},
				animation : {
					animateScale : true,
					animateRotate : true
				}
			}
		});
	}
}

function getFinTrendChart() {
	finChart = document.getElementById("finTrenChart");
	if(finChart != null){
		ctx = finChart.getContext('2d');
		var myLineChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul' ],
				datasets : [ {
					label : 'Savings',
					data : [ 5000, 10000, 45000, 25000, 1000, 10000, 0 ],
					borderColor : "#afc836",
					fill: false
				}, {
					label : 'Contributions',
					data : [ 15000, 15000, 20000, 15000, 20000, 25000, 15000 ],
					borderColor : "#009eda",
					fill: false
				}, {
					label : 'Loan Balance',
					data : [ 0, 0, 0, 100000, 0, 75000, 65000 ],
					borderColor : "orange",
					fill: false
				} ]
			}

		});
	}
}

getFinSummaryChart();

getFinTrendChart();
