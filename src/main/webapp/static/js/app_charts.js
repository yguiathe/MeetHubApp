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

function getQuarTrendsChart() {
	ctx = document.getElementById("quarterTrends");
	if (ctx != null) {
		var myBarChartGrp = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : [ "Jan", "Feb", "Mar" ],
				datasets : [ {
					label : "Contributions",
					backgroundColor : "#009eda",
					data : [ 133, 221, 783 ]
				}, {
					label : "Savings",
					backgroundColor : "#afc836",
					data : [ 408, 547, 675 ]
				}, {
					label : "Loans",
					backgroundColor : "orange",
					data : [ 250, 400, 50 ]
				} ]
			},
			options : {
				title : {
					display : true,
					text : 'Amount (thousands)'
				}
			}
		});
	}
}

function getFinTrendChart() {
	finChart = document.getElementById("finTrenChart");
	if (finChart != null) {
		ctx = finChart.getContext('2d');
		var myLineChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul' ],
				datasets : [ {
					label : 'Savings',
					data : [ 5000, 10000, 45000, 25000, 1000, 10000, 0 ],
					borderColor : "#afc836",
					fill : false
				}, {
					label : 'Contributions',
					data : [ 15000, 15000, 20000, 15000, 20000, 25000, 15000 ],
					borderColor : "#009eda",
					fill : false
				}, {
					label : 'Loan Balance',
					data : [ 0, 0, 0, 100000, 0, 75000, 65000 ],
					borderColor : "orange",
					fill : false
				} ]
			}

		});
	}
}

function getIOTrendChart() {
	finChart = document.getElementById("chart-1");
	if (finChart != null) {
		ctx = finChart.getContext('2d');
		var myLineChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ 'Jan', 'Feb', 'Mar' ],
				datasets : [ {
					label : 'Deposits',
					data : [ 5000, 17000, 18000 ],
					borderColor : "#afc836",
					backgroundColor : "#afc836",
					fill : true
				}, {
					label : 'Withdrawals',
					data : [ 15000, 15000, 20000 ],
					borderColor : "#009eda",
					backgroundColor : "#009eda",
					fill : true
				} ]
			},
			options: {
				scales: {
			        xAxes: [{
			            gridLines: {
			                display:false
			            }
			        }],
			        yAxes: [{
			            gridLines: {
			                display:false
			            }   
			        }]
			    }, 
		        legend : {
		        	position: 'bottom'
		        }
		    }
		});
	}
}

getFinSummaryChart();

getFinTrendChart();

getQuarTrendsChart();
