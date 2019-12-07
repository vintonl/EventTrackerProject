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
	var dataDiv = document.getElementById('oneBevData');
	dataDiv.textContent = '';

	let h1 = document.createElement('h1');
	dataDiv.appendChild(h1);
	h1.textContent = bev.name;

	let descriptionP = document.createElement('p');
	dataDiv.appendChild(descriptionP);
	descriptionP.textContent = bev.description;

	let ul = document.createElement('ul');
	let li = document.createElement('li');
	li.textContent = "Ingredients: " + bev.ingredients;
	let li1 = document.createElement('li');
	li1.textContent = "Caffeine: " + bev.caffeine + " mg";
	let li2 = document.createElement('li');
	li2.textContent = "Calories: " + bev.calories;
	let li3 = document.createElement('li');
	li3.textContent = "Volume: " + bev.volume + " ounces";
	let li4 = document.createElement('li');
	li4.textContent = "Date: " + bev.createdAt;

	dataDiv.appendChild(li);
	dataDiv.appendChild(li1);
	dataDiv.appendChild(li2);
	dataDiv.appendChild(li3);
	dataDiv.appendChild(li4);
	dataDiv.appendChild(ul);

	// this creates a button
	let editButton = document.createElement('button');
	editButton.innerHTML = "Edit Beverage";
	dataDiv.appendChild(editButton);

	// this adds functionality to the button
	editButton.addEventListener('click', function(e) {
		e.preventDefault();
		showUpdateForm(bev);
	});

	let hr = document.createElement('hr');
	dataDiv.appendChild(hr);

}

function showUpdateForm(bev) {
	console.log("showUpdateForm " + bev.name);
	var dataDiv = document.getElementById('editBev');
	dataDiv.textContent = '';

	let form = document.createElement('form');
	dataDiv.appendChild(form);
	form.name = "editForm";

	let nameText = document.createElement('lable');
	nameText.textContent = 'Name: '
	form.appendChild(nameText);
	
	let inputName = document.createElement('input');
	inputName.type = 'text';
	inputName.name = 'name';
	inputName.value = bev.name;
	form.appendChild(inputName);
	
	let br = document.createElement('br');
	form.appendChild(br);
	
	let nameDescription = document.createElement('lable');
	nameDescription.textContent = 'Description: '
	form.appendChild(nameDescription);
	
	let inputDescription = document.createElement('input');
	inputDescription.type = 'text';
	inputDescription.name = 'description';
	inputDescription.value = bev.description;
	form.appendChild(inputDescription);
	
	let br1 = document.createElement('br');
	form.appendChild(br1);
	
	let nameIngredients = document.createElement('lable');
	nameIngredients.textContent = 'Ingredients: '
	form.appendChild(nameIngredients);
	
	let inputIngredients = document.createElement('input');
	inputIngredients.type = 'text';
	inputIngredients.name = 'ingredients';
	inputIngredients.value = bev.ingredients;
	form.appendChild(inputIngredients);
	
	let br2 = document.createElement('br');
	form.appendChild(br2);
	
//	let inputCaffeinated = document.createElement('input');
//	inputCaffeinated.type = 'radio';
//	inputCaffeinated.name = 'caffeinated';
//	inputCaffeinated.value = true;
//	form.appendChild(inputCaffeinated);
//	
//	let br3 = document.createElement('br');
//	form.appendChild(br3);
//	
//	let inputCaffeinatedFalse = document.createElement('input');
//	inputCaffeinatedFalse.type = 'radio';
//	inputCaffeinatedFalse.name = 'caffeinated';
//	inputCaffeinatedFalse.value = false;
//	inputCaffeinatedFalse.textContent = 'Caffeine-Free';
//	form.appendChild(inputCaffeinatedFalse);
//	
//	let br4 = document.createElement('br');
//	form.appendChild(br4);
	
	let nameCaffeine = document.createElement('lable');
	nameCaffeine.textContent = 'Caffeine: '
	form.appendChild(nameCaffeine);
	
	let inputCaffeine = document.createElement('input');
	inputCaffeine.type = 'number';
	inputCaffeine.name = 'caffeine';
	inputCaffeine.value = bev.caffeine;
	form.appendChild(inputCaffeine);
	
	let br5 = document.createElement('br');
	form.appendChild(br5);
	
	let nameCalories = document.createElement('lable');
	nameCalories.textContent = 'Calories: '
	form.appendChild(nameCalories);
	
	let inputCalories = document.createElement('input');
	inputCalories.type = 'number';
	inputCalories.name = 'calories';
	inputCalories.value = bev.caffeine;
	form.appendChild(inputCalories);
	
	let br6 = document.createElement('br');
	form.appendChild(br6);
	
	let nameVolume = document.createElement('lable');
	nameVolume.textContent = 'Volume: '
	form.appendChild(nameVolume);
	
	let inputVolume = document.createElement('input');
	inputVolume.type = 'number';
	inputVolume.name = 'volume';
	inputVolume.value = bev.caffeine;
	form.appendChild(inputVolume);
	
	// this creates a button
	let editButton = document.createElement('button');
	editButton.innerHTML = "Submit Edited Beverage";
	dataDiv.appendChild(editButton);

	// this adds functionality to the button
	editButton.addEventListener('click', function(e) {
		e.preventDefault();
		updateBev(bev);
	});
	
	let br7 = document.createElement('br');
	dataDiv.appendChild(br7);
	let br8 = document.createElement('br');
	dataDiv.appendChild(br8);
	
	// this creates a button
	let deleteButton = document.createElement('button');
	deleteButton.innerHTML = "Delete this Beverage";
	dataDiv.appendChild(deleteButton);
	
	// this adds functionality to the button
	deleteButton.addEventListener('click', function(e) {
		e.preventDefault();
		deleteBev(bev);
	});
	

	let hr = document.createElement('hr');
	dataDiv.appendChild(hr);
}

function updateBev(bev) {
	console.log('updateBev: ' + bev.name)
}

function deleteBev(bev) {
	console.log('deleteBev: ' + bev.name)
}
