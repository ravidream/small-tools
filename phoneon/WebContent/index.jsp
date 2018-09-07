<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone On</title>
</head>
<body>
	<table width="60%" id = "id1">
		<tr>
			<td>	
				<table border ="1" width="100%" id="id2">
				   <tr>
				   		<th width="10%">SNo</th>
				   		<c:forEach items="${map}" var="entry" varStatus="i">
				    		<th><c:out value="${i.index + 1}"></c:out></th>
						</c:forEach>
				   		<th width="20%">Average</th> 
				   </tr>					
				</table>
			</td>
		</tr>
		
		<tr>
			<td>	
				<table border ="1" width="100%" id="id3">
				   <tr>
				   		<td width="10%">Name</td>
				   		<c:forEach items="${map}" var="entry" varStatus="i">
				   			<c:set var="strStu" value="${fn:split(entry.key, '-')}" />
				    		<th width="30%">${strStu[0]}</th>
				    		<c:set value="${entry.value}" var="list"></c:set>				    		
						</c:forEach>
						<td width="30%">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				   </tr>
		        </table>
		    </td>
		</tr>
		<tr>
		
		<td>
			<table  width="100%" height="100%" id="id4">
				<tr>
					<td><table border="1" width="40%" height="100%" id="id5">
						  <c:forEach items="${map}" var="entry" varStatus="i">
						   	<c:set var="str" value="${fn:split(entry.key, '-')}" ></c:set>
							<tr>
								 <td>${str[1]}</td>						 
						    </tr>
						 </c:forEach>				   	
					  </table></td>
					<td><table width="100%" height="100%" id="t0" style="margin-left:0px">	   
	
				 <c:forEach items="${map}" var="entry" varStatus="i">
				   	<td>
				   		<c:set value="${entry.value}" var="list"></c:set>
				   		<table border="1" width="100%" height="100%" id="t1">	
							<c:forEach items="${list}" var="li" varStatus="i">
								
				   			<c:set value="${li.subject}" var="subject"></c:set>	

				   			<tr>
					   			<td>
					   			<table border="0" width="100%" height="100%" id="t2">
					   			 <tr>	
					   			 <td>
									  <c:forEach items="${list}" var="li" varStatus="i">									   			
										 
										   		
										   												   				
											  <c:if test = "${subject == li.subject}">
												 
										   		${ li.marks }
										   	<c:set value="false" var="test"></c:set>	
										   						
											</c:if>
										 
									   </c:forEach>
									   </td>									   
									    </tr>
							   </table>
						   	   </td>
						   	   
					   	   </tr>	    		
				   			</c:forEach>
							
				   	</table>
				   	</td>	   
			</c:forEach>
		</table></td>
		<td><table border="1" width="100%" height="100%">
						  <c:forEach items="${map}" var="entry" varStatus="i">
						   	<c:set var="str" value="${fn:split(entry.key, '-')}" ></c:set>
							<tr>
								 <td>${str[2]}</td>						 
						    </tr>
						 </c:forEach>				   	
					  </table></td>
				</tr>
			</table>
		</td> 
		  	
		
		</tr>
</table>
</body>
</html>