var stompClient = null;

function connect() {
    var socket = new SockJS('/api/socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/updates', function (message) {
        	showMessage(JSON.parse(message.body));
        });
    });
}

function showMessage(message) {
    $("#events")
    	.append("<tr><td>" + message.action + "</td>" +
    			"<td>" + message.entity + "</td>" + 
    			"<td>" + message.id + "</td></tr>");
}

$(function () {
	connect();
});