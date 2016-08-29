<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 7]>                  <html class="ie7 no-js" lang="en">     <![endif]-->
<!--[if lte IE 8]>              <html class="ie8 no-js" lang="en">     <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="not-ie no-js" lang="en">
<!--<![endif]-->
<head>

<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>Jedi Car Pool</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="includes_head.jsp"%>

</head>

<body>

	<header class="header">

		<div class="main-baner">

			<div class="fullscreen background parallax clearfix"
				style="background-image: url('img/tumblr_n7yhhvUQtx1st5lhmo1_1280.jpg');"
				data-img-width="1600" data-img-height="1064">

				<div class="main-parallax-content">

					<div class="second-parallax-content">

						<section class="container">

							<div class="row">

								<div class="main-header-container clearfix">

									<div class="col-md-8 col-sm-12 col-xs-12">

										<div class="logo">
											<h1>Jedi Car Pool</h1>
										</div>
										<!-- end .logo -->

									</div>
									<!-- end .col-sm-4 -->

									<div class="col-md-4 col-sm-8 col-xs-12">

										<nav id="nav" class="main-navigation">
											<ul class="navigation">
												<li><a data-toggle="modal" data-target="#loginModal">Find a ride</a></li>
												<li><a data-toggle="modal" data-target="#loginModal">Give a ride</a></li>
											</ul>

										</nav>
										<!-- end .main-navigation -->

									</div>
									<!-- end .col-md-8 -->

								</div>
								<!-- end .main-header-container -->

							</div>
							<!-- end .row -->

						</section>
						<!-- end .container -->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<c:choose>
								<c:when test="${loggedIn}">
									<div class="sign-in-content">
										<button id="login" type="button"
											class="btn btn-lg green-color">Successfully signed
											in!</button>
									</div>
								</c:when>
								<c:otherwise>
									<div class="sign-in-content">
										<button id="login" type="button" class="btn btn-lg red-color">Sign
											in with Google</button>
									</div>
								</c:otherwise>
							</c:choose>

							<!-- end .search-content -->

						</div>

					</div>
					<!-- end .second-parallax-content -->

				</div>
				<!-- end .main-parallax-content -->

			</div>
			<!-- end .background .parallax -->

		</div>
		<!-- end .main-baner -->

	</header>
	<!-- end .header -->

	<section class="main-content">

		<div class="container">
			<div class="row">

				<div class="page-content">

					<div class="services clearfix">

						<div class="col-md-12 col-sm-12 col-xs-12">

							<div class="page-sub-title textcenter">
								<h2>Why car pool?</h2>
								<div class="line"></div>
							</div>
							<!-- end .page-sub-title -->

						</div>
						<!-- end .col-md-12 col-sm-12 col-xs-12 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-car"></i>

								<h3>Share your ride</h3>
								<p>Are you getting sick of crowded public transport or
									traveling alone and spending so much money on commuting? Share
									your ride today, and forget about these problems.</p>


							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-users"></i>

								<h3>Meet new people</h3>
								<p>Carpooling is a wonderful way to meet interesting people.
									Get to know the people you work with and make new friends!</p>

							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-globe"></i>

								<h3>Save the environment</h3>
								<p>Car pooling cuts down on the number of cars and vehicles
									on the road. Fewer cars means less pollution and less pollution
									means a cleaner, healthier environment.</p>

							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

					</div>
					<!-- end .services -->

				</div>
				<!-- end .page-content -->

			</div>
			<!-- end .row -->
		</div>
		<!-- end .container -->

	</section>
	<!-- end .main-content -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>

				<div id="modal-info" class="modal-body">Please sign in to access the rest of the website.</div>
				<!-- end .modal-body -->

			</div>
			<!-- end .modal-content -->
		</div>
		<!-- end .modal-dialog -->
	</div>
	<!-- end .modal -->
	<%@ include file="includes_foot.jsp"%>

</body>
</html>
