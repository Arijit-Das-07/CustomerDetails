
$(document).ready(function() {
	$("#primary").on('click', function() {
		var $mail = $('#search').val();
		$.ajax({
			type: 'GET',
			url: '/getbymailid/' + $mail,
			success: function(data) {
				console.log(JSON.stringify(data))
				alert("Data: " + JSON.stringify(data) + "\nStatus: " + status);
			}
		});
	});

});


$(document).ready(function() {
	getcustomers();
	$("#newTutBtn").on("click", function(e) {
		$("#newForm").toggle();
	});
	function getcustomers() {
		$('#customersBody').html('');
		$.ajax({
			url: 'http://localhost:8080/getallcustomer',
			method: 'get',
			dataType: 'json',
			data: {
				test: 'test data'
			},
			success: function(data) {

				var html;
				$(data).each(function(i, customer) {
					html += "<tr>";
					html += "<td >" + customer.id + "</td>";
					html += "<td>" + customer.cust_name + "</td>";
					html += "<td>" + customer.site_loc + "</td>";
					html += "<td>" + customer.cust_con_person + "</td>";
					html += "<td>" + customer.cust_mail_id + "</td>";
					html += "<td>" + customer.cust_cont_no + "</td>";
					html += "<td>" + customer.trans_mail_id + "</td>";
					html += "<td>" + customer.trans_name + "</td>";
					html += "<td>" + customer.status + "</td>";
					html += "<td>" + `<i class="fas fa-trash deleteTut" data-tutid="` + customer.id + `"></i> `;
					html += "</tr>";
				});
				$('#customersBody').html(html);
				$('#customersTable').DataTable();
				loadButtons()
			}
		});

	}

	function loadButtons() {
		$(".deleteTut").click(function(e) {
			deleteTutorial($($(this)[0]).data("tutid"));
			e.preventDefault();
		})
	}



	$("#submitcustomer").on("click", function(e) {
		let data = {
			"cust_name": $($("#newForm")[0].cust_name).val(),
			"site_loc": $($("#newForm")[0].site_loc).val(),
			"cust_con_person": $($("#newForm")[0].cust_con_person).val(),
			"cust_mail_id": $($("#newForm")[0].cust_mail_id).val(),
			"cust_cont_no": $($("#newForm")[0].cust_cont_no).val(),
			"trans_mail_id": $($("#newForm")[0].trans_mail_id).val(),
			"trans_name": $($("#newForm")[0].trans_name).val(),
			"status": "Active"
		}
		postcustomer(data);
		$("#newForm").trigger("reset");
		$("#newForm").toggle();
		e.preventDefault();

	});


	function postcustomer(data) {
		$.ajax({
			url: 'http://localhost:8080/add/',
			method: 'POST',
			dataType: 'json',
			data: data,
			success: function(data) {
				console.log(data);
				getcustomers();
			}
		});
	}

	
	function deleteTutorial(id) {
		var x = confirm("Are you sure you want to delete?");
        if (x) {
		$.ajax({
			url: 'http://localhost:8080/remove/' + id,
			method: 'DELETE',
			dataType: 'json',
			success: function() {
				getcustomers();
			}
		});
	}}


});




