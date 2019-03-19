document.addEventListener("DOMContentLoaded", function (e) {
  createOnStartUp();
})

let pendingChecked = false;
let resolvedChecked = false;
let allChecked = false;
let url = "http://localhost:8080/Revature/managerallReqs";

const createOnStartUp = () => {
	
	document.getElementById("all").addEventListener("change", function() {
		allChecked = this.checked;
		setUrl();
		sendAjaxGet(url, display);
	});

	document.getElementById("pending").addEventListener("change", function() {
		pendingChecked = this.checked;
		setUrl();
		sendAjaxGet(url, display);
	});

	document.getElementById("resolved").addEventListener("change", function() {
		resolvedChecked = this.checked;
		setUrl();
		sendAjaxGet(url, display);
	});
	
	sendAjaxGet(url, display);
}

const setUrl = () => {
	if (pendingChecked) {
		url = "http://localhost:8080/Revature/managerpendingReqs";
	} else if (resolvedChecked) {
		url = "http://localhost:8080/Revature/managerresolvedReqs";
	} else if (allChecked) {
		url = "http://localhost:8080/Revature/managerallReqs";
	}
}

const sendAjaxGet = (url, func) => {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState==4 && this.status==200) {
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

const display = (xhr) => {
	requestArr = JSON.parse(xhr.responseText).requests;
	let table = document.getElementById("requestTable");
	table.removeChild(document.getElementById("requestTableBody"));
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "requestTableBody");
	table.appendChild(newBody);
	for (i in requestArr) {
		let newRow = document.createElement("tr");
		if (requestArr[i].manager) {
			man = `${requestArr[i].manager.firstname} ${requestArr[i].manager.lastname}`;
		} else {
			man = "TBA";
		}
		newRow.innerHTML = 
			`<td>${requestArr[i].id}</td>
			<td>${requestArr[i].employee.firstname + " " + requestArr[i].employee.lastname}</td>
			<td>${requestArr[i].type}</td> 
			<td>${requestArr[i].amount}</td>
			<td>${requestArr[i].status}</td> 
			<td>${requestArr[i].decision}</td>
			<td>${man}</td>`;
		newBody.appendChild(newRow);
	}
}

const myFunction = () => {
    let input, filter, tbody, tr, td, i, txtValue;
    input = document.getElementById("empName");
    filter = input.value.toUpperCase();
    ul = document.getElementById("requestTableBody");
    li = ul.getElementsByTagName("tr");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("td")[1];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

// Toggle the side navigation
$("#sidebarToggle").on('click', function (e) {
	e.preventDefault();
	$("body").toggleClass("sidebar-toggled");
	$(".sidebar").toggleClass("toggled");
});	

