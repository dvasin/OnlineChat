<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<title></title>
	<style type="text/css">
   .block1 {
    width: 80%;
    padding: 5px;
    border: solid 1px black;
    float: left;
    overflow: auto;
   }
   .block2 {
    width: 16%;
    background: #fc0;
    padding: 5px;
    border: solid 1px black;
    overflow: auto;
   }
    .block3 {
    width: 98%;
    padding: 5px;
    border: solid 1px black;
    float: inherit;
   }
  </style>
</head>
<body>
<p>Hello, ${user.nick}</p>
<div style="width: 600px;padding-left: 0px;">
	<div class="block1">
	<c:forEach var="elem" items="${lastmessages}">
		<div>
		    <c:out value="${elem.user.nick} : "/>
		    <c:out value="${elem.text}"/>
		</div>
	</c:forEach>
	</div>
	<div class="block2">
	<c:forEach var="elem" items="${loggedinusers}">
    		<div>
    		    <c:out value="${elem.nick}"/>
    		</div>
    </c:forEach>
	</div>
	<div class="block3" style="
    border-top-width: 0px;">
		<form name="sendMessageForm" method="POST" action="chat">
            <input type="hidden" name="command" value="sendMessageAndRefresh" />
      		<p><textarea name="message" style="margin: 0px; width: 580px; height: 56px;"></textarea></p>
      		<p><input type="submit" value="SEND"></p>
     </form>
	</div>
</div>
<div>
    <form name="loginForm" method="POST" action="chat">
        <input type="hidden" name="command" value="logout" />
        <p><input type="submit" value="Log out"></p>
    </form>
</div>
</body>
</html>