<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<link type="text/css" rel="stylesheet" href="../style/smoothness/jquery-ui-1.8.23.custom.css">
<script type="text/javascript" src="../scripts/jquery-1.8.1.js"></script>
<script type="text/javascript" src="../scripts/jquery-ui-1.8.23.custom.min.js"></script>
<script type="text/javascript">
	function changePassword() {
		openDialog('<c:url value="/index2.html"/>');
		return false;
	}
</script>
<style type="text/css">

</style>
<body>
<%--   <div id="loading" class="loading-invisible">
    <p>Your content (like a loading GIF)</p>
  </div>
  <script type="text/javascript">
			document.getElementById("loading").className = "loading-visible";
			var hideDiv = function() {
				document.getElementById("loading").className = "loading-invisible";
			};
			var oldLoad = window.onload;
			var newLoad = oldLoad ? function() {
				hideDiv.call(this);
				oldLoad.call(this);
			} : hideDiv;
			window.onload = newLoad;
		</script>
    <%@ include file="/jsp/popup-dialog.jsp"%> --%>
  <div id="minHeight"></div>