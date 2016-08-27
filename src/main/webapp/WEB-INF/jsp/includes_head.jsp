
<!-- Styles -->

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Forms -->
<link href="css/jquery.idealforms.css" rel="stylesheet">
<!-- Select  -->
<link href="css/jquery.idealselect.css" rel="stylesheet">
<!-- Timepicker  -->
<link
	href="//cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.10.0/jquery.timepicker.min.css"
	rel="stylesheet">
<!-- Slicknav  -->
<link href="css/slicknav.css" rel="stylesheet">
<!-- Main style -->
<link href="css/style.css" rel="stylesheet">

<!-- Modernizr -->
<script src="js/modernizr.js"></script>

<!-- Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Montserrat'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Google OAuth -->

<script src="https://apis.google.com/js/platform.js?onload=oauthReady"
	async defer></script>
<meta name="google-signin-client_id"
	content="797550632992-634oon8ssbhjnmqj6fcsbj4um8tgnuni.apps.googleusercontent.com">
	<script type="text/javascript">
	window.oauthReady = function(){
      gapi.load('auth2', function() {
          gapi.auth2.init();
        });
		function login() {
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signIn({
				scope : 'https://www.googleapis.com/auth/user.phonenumbers.read'
			}).then(function(googleUser) {
				  var profile = googleUser.getBasicProfile();
				  var name = profile.getName();
				  var email = profile.getEmail();
				  var token = googleUser.getAuthResponse().id_token;
				  $.get('https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=' + token, function(data){console.log(data)});
				  $.post('login', {
					  "name": name,
					  "email": email,
					  "token": token
				  }, function(){
					  window.location.href = "";
				  });
			});
		}
		function logout() {
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function() {
				console.log('User signed out.');
				$.post('logout', function(){
					  window.location.href = "/car-pool";
				  });
			});
		}
		$('#login').on('click', login);
		$('#logout').on('click', logout);
}
</script>