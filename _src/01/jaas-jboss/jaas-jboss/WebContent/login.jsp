<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<html >
<HEAD>
<TITLE></TITLE>
<!-- To prevent caching -->
<%
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<SCRIPT>
function submitForm() {
var frm = document. logonForm;

// Check if all the required fields have been entered by the user before
// submitting the form
if( frm.j_username.value == "" ) {
alert("blank");
frm.j_username.focus();
return ;
}

if( frm.j_password.value == "" ) {
alert("blank");
frm.j_password.focus();
return ;
}
frm.submit();
}
</SCRIPT>
</HEAD>
<BODY>
<FORM name="logonForm" action="SecurityCheckerServlet" METHOD=get>
<TABLE width="100%" border="0" cellspacing="0" cellpadding=
"1" bgcolor="white">
<TABLE width="100%" border="0" cellspacing=
"0" cellpadding="5">
<TR align="center">
<TD align="right" class="Prompt"></TD>
<TD align="left">
<INPUT type="text" name="j_username" maxlength=20>
</TD>
</TR>
<TR align="center">
<TD align="right" class="Prompt"> </TD>
<TD align="left">
<INPUT type="password"
name="j_password" maxlength=20 >
<BR>
<TR align="center">
<TD align="right" class="Prompt"> </TD>
<TD align="left">
<input type="submit" onclick="javascript:submitForm();" value="Login">
</TD>
</TR>
</TABLE>
</FORM>
</BODY>
</html>