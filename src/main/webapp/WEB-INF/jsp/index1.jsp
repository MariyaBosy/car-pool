<!DOCTYPE HTML>
<!--
	Eventually by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Eventually by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="css/main.css" />
<!-- Google OAuth -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="797550632992-634oon8ssbhjnmqj6fcsbj4um8tgnuni.apps.googleusercontent.com">
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie9.css" /><![endif]-->
<script type="text/javascript">
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());
	}
	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function() {
			console.log('User signed out.');
		});
	}
</script>
</head>
<body>
	<!-- Header -->
	<header id="header">
		<h1>Jedi Car Pool</h1>
		<p>
			A simple template for telling the world when you'll launch<br />
			your next big thing. Brought to you by <a href="http://html5up.net">HTML5
				UP</a>.
		</p>
	</header>

	<!-- OAuth Form -->
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<a href="#" onclick="signOut();">Sign out</a>

	<!-- Footer -->
	<footer id="footer">
		<ul class="icons">
<!-- 			<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon fa-instagram"><span
					class="label">Instagram</span></a></li> -->
			<li><a href="http://github.com/pbaisla/car-pool"
				class="icon fa-github"><span class="label">GitHub</span></a></li>
<!-- 			<li><a href="#" class="icon fa-envelope-o"><span
					class="label">Email</span></a></li> -->
		</ul>
<!-- 		<ul class="copyright">
			<li>&copy; Untitled.</li>
			<li>Credits: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul> -->
	</footer>

	<!-- Scripts -->
	<!--[if lte IE 8]><script src="js/ie/respond.min.js"></script><![endif]-->
	<script src="js/main.js"></script>
</body>
</html>