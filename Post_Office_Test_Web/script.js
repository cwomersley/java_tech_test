'use strict'

function evaluateData() {
	let showBox = document.getElementById("showBox");
	let dataString = showBox.innerHTML;

	//Check inputs are only what are expexted in a calc
	dataString = dataString.replace(/[^-()\d/*+]/g, '');
	//eval can introduce secuirty risks but in this context there is no issue.
	var answer = eval(dataString);
	showBox.textContent = answer;
}

function addToShowBox(input) {
	let showBox = document.getElementById("showBox");
	showBox.innerHTML += input;
	return;
}

function runOperations(numOne, numTwo, operator) {
	return new Promise((resolve, reject) => {
		try {
			let answer = 0;
			switch (operator){
				case "+":
					answer = numOne + numTwo;
					break;
				case "-":
					answer = numOne - numTwo;
					break;
			}
			resolve(answer)
		} catch(err) {
			reject(err);
		}
	})
}

function gatherData(dataString) {
	return new Promise((resolve, reject) => {
		try{
			let parsedData = {
				numbers: [],
				operator: ''
			};
			for (let i = 0; i < dataString.length; i++) {
				let val = parseInt(dataString.charAt(i));
				if (isNaN(val)) {
					parsedData.operator = dataString.charAt(i);
				} else {
					parsedData.numbers.push(val);
				}
			}
			resolve(parsedData);
		} catch(err) {
			reject(err);
		}
	})
}
//Remove last entry -add clear all when clearing after a result
function undo() {
	let showBox = document.getElementById("showBox");
	showBox.innerHTML = showBox.innerHTML.slice(0,-1)
	return;
}

//Set showBox to empty string
function clearShowBox() {
	let showBox = document.getElementById("showBox");
	showBox.innerHTML = "";
	return;
}
