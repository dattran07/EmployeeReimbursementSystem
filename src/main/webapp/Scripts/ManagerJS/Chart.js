document.addEventListener("DOMContentLoaded", function (e) {
  createOnStartUp();
})

let ctx = document.getElementById('myChart').getContext('2d');
let certification = 0;
let clientRelocation = 0;
let trainingRelocation = 0;
let interviewExpense = 0;
let salesExpense = 0;
let travelExpense = 0;
let other = 0;

const createOnStartUp = () => {
	let a1 = $.ajax({
		data : certification,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/certification'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a2 = $.ajax({
		data : clientRelocation,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/clientrelocation'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a3 = $.ajax({
		data : trainingRelocation,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/trainingrelocation'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a4 = $.ajax({
		data : interviewExpense,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/interviewexpense'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a5 = $.ajax({
		data : salesExpense,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/salesexpense'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a6 = $.ajax({
		data : travelExpense,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/travelexpense'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});
	a7 = $.ajax({
		data : other,
		dataType : 'json',
		url : 'http://localhost:8080/Revature/other'
	}).done(function(data) {
	}).fail(function(jqXHR, textStatus, errorThrown) {
		console.log(textStatus + ': ' + errorThrown);
	});

	$.when(a1, a2, a3, a4, a5, a6, a7).done(
			function(r1, r2, r3, r4, r5, r6, r7) {

				let chart = new Chart(ctx, {
					type : 'bar',
					data : {
						labels : [ 'Certification', 'Relocation to Client',
								'Relocation to Training', 'Interview Expense',
								'Sales Expense', 'Associate Travel Expense',
								'Other' ],
						datasets : [ {
							label : "Revature's Expenses",
							backgroundColor : [getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor()], 
							data : [ r1[0].requests, r2[0].requests,
									r3[0].requests, r4[0].requests, r5[0].requests,
									r6[0].requests, r7[0].requests ]
						}

						]
					},
					options: {
					    legend: {
					        display: false
					    },
					    tooltips: {
					        callbacks: {
					           label: function(tooltipItem) {
					                  return tooltipItem.yLabel;
					           }
					        }
					    }
					}
				});
			});

	function getRandomColor() {
	    var letters = '0123456789ABCDEF'.split('');
	    var color = '#';
	    for (var i = 0; i < 6; i++ ) {
	        color += letters[Math.floor(Math.random() * 16)];
	    }
	    return color;
	}
}

