<head>
	<meta name='layout' content='main' />
	<title>Multi level  Roles in Grails</title>
</head>

<body>

	<div class='nav'>
		<span class='menuButton'><a class='home' href='${createLinkTo(dir:'')}'>Home</a></span>
	</div>

	<div class='body'>
		<g:link action='user'> ROLE_USER</g:link><br/>
		<g:link action='admin'>ROLE_ADMIN</g:link><br/>
		<g:link action='superadmin'> ROLE_SUPERADMIN</g:link><br/>
	</div>

</body>
