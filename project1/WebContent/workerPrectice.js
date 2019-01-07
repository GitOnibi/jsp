/* onmessage: 입력값은 받음 */
onmessage = function(msg) {

	var conList = msg.data.split("-");
	var resultMsg = "<table border=1>";
	var idx = 0;
	for(var i = 0; i < 5; i++) {
		resultMsg += "<tr>";
		for(var j = 0; j < 5; j++) {
			resultMsg += "<td>" + conList[idx] + "</td>"
			idx++;
		}
		resultMsg += "</tr>";
	}
	resultMsg += "</table>";
	
	postMessage(resultMsg);
}