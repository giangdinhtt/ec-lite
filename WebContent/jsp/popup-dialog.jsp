<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function openDialog(url) {
		setTimeout(function() {
			$("#popupDialog").dialog("open");
		}, 10);

		$("#modalIframeId").attr("src", url);
	}

	$(document).ready(function() {
		$("#popupDialog").dialog({
			autoOpen : false,
			modal : true,
			height : 500,
			width : 600,
			show : 'fade',
			hide : 'fade',
			dialogClass : 'noTitle'
		});
	});
</script>
<div id="popupDialog">
  <iframe id="modalIframeId" width="100%" height="100%" marginWidth="0" marginHeight="0" frameBorder="0"
    scrolling="auto"></iframe>
</div>