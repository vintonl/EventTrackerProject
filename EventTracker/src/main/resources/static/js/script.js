window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {
	window.addEventListener('load', function(e) {
		console.log('document loaded');
		init();
	});
}

function init() {
	document.getAllButton.lookupAll.addEventListener('click', function(event) {
		event.preventDefault();
		getAllBevs();
	})

	document.addBev.add.addEventListener('click', function(event) {
		event.preventDefault();
		addNewBeverage();

	})

}

function getAllBevs() {
	var xhr = new XMLHttpRequest();

	xhr.open('GET', 'http://localhost:8083/api/beverages', true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {

			var data = JSON.parse(xhr.responseText);
			console.log(data);
			displayBeverages(data);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
			var dataDiv = document.getElementById('bevData');
			dataDiv.textContent = '';
			let h1 = document.createElement('h1');
			dataDiv.appendChild(h1);
			h1.textContent = "Beverages not found.";

		}
	};

	xhr.send(null);
}

function displayBeverages(bevs) {
	var dataDiv = document.getElementById('bevData');
	dataDiv.textContent = '';

	let br = document.createElement('br');
	dataDiv.appendChild(br);
	let hr = document.createElement('hr');
	dataDiv.appendChild(hr);
	let table = document.createElement('table');
	dataDiv.appendChild(table);

	bevs.forEach(function(bev, index, arr) {
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		td.textContent = bev.name;

		td.addEventListener('click', function(e) {
			displayBev(bev);
		});
		dataDiv.appendChild(td);
		dataDiv.appendChild(tr);
	})

	let hr1 = document.createElement('hr');
	dataDiv.appendChild(hr1);
}

function addNewBeverage() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://localhost:8083/api/beverages', true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON
	// request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				var data = JSON.parse(xhr.responseText);
				console.log(data);
				getAllBevs();
			} else {
				console.log("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};

	let form = document.addBev;
	var newBevObject = {
		name : form.name.value,
		description : form.description.value,
		ingredients : form.ingredients.value,
		caffeine : form.caffeine.value,
		caffeinated : form.caffeinated.value,
		containsAlcohol : false,
		calories : form.calories.value,
		volume : form.volume.value,
		active : true,
		user : {
			id : 1
		}
	};

	var userObjectJson = JSON.stringify(newBevObject); // Convert JS object to
	// JSON string

	xhr.send(userObjectJson);

}

function displayBev(bev) {
	console.log("displayBev " + bev.name);
}
