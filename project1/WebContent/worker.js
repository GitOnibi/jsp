/* onmessage: 입력값은 받음 */
onmessage = function(num) {
	var sum = 0;
	var num1 = parseInt(num.data.num1);
	var num2 = parseInt(num.data.num2);
	for(var i = num1; i <= num2; i++) {
		sum += i;
	}
	postMessage(sum);
}