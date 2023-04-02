<%@ page pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${now}" default="None" /></p>
    <p>Counter :  <c:out value="${counter.toString()}" default="None" /> </p>
    <p>Date de création :  <c:out value="${date}" default="None" /> </p>
    <p>Deuxièmes paramètres :  <c:out value="${param2}" default="None" /> </p>




</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>