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

	for (var i = 0; i < bevs.length; i++) {
		let h1 = document.createElement('h1');
		dataDiv.appendChild(h1);
		h1.textContent = bevs[i].name;

		let descriptionP = document.createElement('p');
		dataDiv.appendChild(descriptionP);
		descriptionP.textContent = bevs[i].description;

		let ul = document.createElement('ul');
		let li = document.createElement('li');
		li.textContent = "Ingredients: " + bevs[i].ingredients;
		let li1 = document.createElement('li');
		li1.textContent = "Caffeine: " + bevs[i].caffeine + " mg";
		let li2 = document.createElement('li');
		li2.textContent = "Calories: " + bevs[i].calories;
		let li3 = document.createElement('li');
		li3.textContent = "Volume: " + bevs[i].volume + " ounces";
		let li4 = document.createElement('li');
		li4.textContent = "Date: " + bevs[i].createdAt;

		dataDiv.appendChild(li);
		dataDiv.appendChild(li1);
		dataDiv.appendChild(li2);
		dataDiv.appendChild(li3);
		dataDiv.appendChild(li4);
		dataDiv.appendChild(ul);
	}
}

function addNewBeverage() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://localhost:8083/api/beverages', true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				var data = JSON.parse(xhr.responseText);
				console.log(data);
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

	var userObjectJson = JSON.stringify(newBevObject); // Convert JS object to JSON string

	xhr.send(userObjectJson);
}
