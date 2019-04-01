<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul> <h2>Lista de aulas:</h2>
	<li>${mensajeAula1.nombre}</li>
	<li>${mensajeAula2.nombre}</li>
</ul>
Alumno1: ${mensajeAlumno1.nombre} </br>
Alumno2: ${mensajeAlumno2.nombre} </br>


<%-- Singleton: ${mensajeSingleton.nombre} - ${mensajeSingleton.descripcion}<br/> --%>
<%-- Prototype: ${mensajePrototype.nombre} - ${mensajePrototype.descripcion}<br/> --%>
<%-- Request: ${mensajeRequest.nombre} - ${mensajeRequest.descripcion}<br/> --%>
<%-- Session: ${mensajeSession.nombre} - ${mensajeSession.descripcion}<br/> --%>

</body>
</html>