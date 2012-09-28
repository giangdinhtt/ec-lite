<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/page-header.jsp"%>
<%@ include file="/jsp/header.jsp"%>
<div id="wrapper">
    <div id="header">
        <h1>Sticky Footer with Faux Column</h1>
        <p>Using a dummy float in the html for Opera and IE8 compliance</p>        
    </div>
    <div id="left" style="background-color: #f0a;">
        <h3>Left Column</h3>
        <p>This sidebar gets it's color from a repeat-y image on the #wrapper div to 
        give an equal height column appearance.</p>
    </div> 
    <div id="content" style="background-color: #0fa;">
        <h2>Page Title</h2> 
        <p>This demo uses a dummy float in the html for Opera and IE8 compliance.</p>
        <p>Reduce viewport height to scroll content and test sticky footer.</p>
        <p>Content</p>
        <p>Content</p>
        <p>Content</p>
        <p>Content</p>
        <p>Last Content</p>         
    </div><!-- end content -->   
</div><!-- end wrapper -->
<%@ include file="/jsp/footer.jsp"%>
<%@ include file="/jsp/page-footer.jsp"%>