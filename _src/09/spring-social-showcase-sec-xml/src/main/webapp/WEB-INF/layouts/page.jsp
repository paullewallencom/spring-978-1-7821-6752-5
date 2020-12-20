<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Multiple Authentication Providers with Spring Social and Database</title>
<style type="text/css">

body{
margin:0;
padding:0;
line-height: 1.5em;
}

b{font-size: 110%;}
em{color: red;}

#maincontainer{
width: 840px; /*Width of main container*/
margin: 0 auto; /*Center container on page*/
}

#topsection{
background: #EAEAEA;
height: 90px; /*Height of top section*/
}

#topsection h1{
margin: 0;
padding-top: 15px;
}

#contentwrapper{
float: left;
width: 100%;
}

#contentcolumn{
margin-left: 200px; /*Set left margin to LeftColumnWidth*/
}

#leftcolumn{
float: left;
width: 200px; /*Width of left column*/
margin-left: -840px; /*Set left margin to -(MainContainerWidth)*/
background: #FDE95E;
}

#footer{
clear: left;
width: 100%;
background: black;
color: #FFF;
text-align: center;
padding: 4px 0;
}

#footer a{
color: #FFFF80;
}

.innertube{
margin: 10px; /*Margins for inner DIV inside each column (to provide padding)*/
margin-top: 0;
}

</style>

</head>
<body>
<div id="maincontainer">

<div id="topsection"><div class="innertube"><h1><a href="<c:url value="/"/>">Multiple Authentication Providers with Spring Social and Database</a></h1>
    </div></div>

<div id="contentwrapper">
<div id="contentcolumn">
<div class="innertube"><tiles:insertAttribute name="content" /></div>
</div>
</div>

<div id="leftcolumn">
<div class="innertube"><tiles:insertTemplate template="menu.jsp" /></div>
</div>

<div id="footer"><a href="http://www.dynamicdrive.com/style/">Dynamic Drive CSS Library</a></div>

</div>
</body>
</html>
