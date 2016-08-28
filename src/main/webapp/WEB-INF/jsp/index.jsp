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
												<li><a href="search">Find a ride</a></li>
												<li><a href="post">Give a ride</a></li>
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

							<div class="sign-in-content">
								<button id="login" type="button" class="btn btn-lg red-color">Sign in with Google</button>
							</div>
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
								<h2>Services</h2>
								<div class="line"></div>
							</div>
							<!-- end .page-sub-title -->

						</div>
						<!-- end .col-md-12 col-sm-12 col-xs-12 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-car"></i>

								<h3>Share your ride</h3>
								<p>Are you getting sick of traveling alone and spent so much
									money on gas? Share your ride today,and forget about this
									problems.</p>


							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-users"></i>

								<h3>Find new friends</h3>
								<p>Finding new friends is easier than ever,nothing makes
									better friendship than spending few hours casually chatting
									with some interesting people.</p>

							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

						<div class="col-md-4 col-sm-4 col-xs-12">

							<article class="service">

								<i class="fa fa-map-marker"></i>

								<h3>Go to new places</h3>
								<p>Find some new favourite place to chill out,you have no
									longer got excuse for not travelling and discovering.</p>

							</article>
							<!-- end .service -->

						</div>
						<!-- end .col-md-4 -->

					</div>
					<!-- end .services -->

					<div class="clearfix"></div>

					<div class="col-md-12 col-sm-12 col-xs-12">

						<div class="background parallax"
							style="background-image: url('img/XWBIL5.jpg');"
							data-img-width="1600" data-img-height="1064">

							<div class="main-parallax-content">

								<div class="second-parallax-content">

									<div class="parallax-content clearfix">

										<div class="col-md-4 col-sm-4 col-xs-12">
											<div class="site-stat">
												<span class="counter">5,000</span> <span>Happy users</span>
											</div>
										</div>

										<div class="col-md-4 col-sm-4 col-xs-12">
											<div class="site-stat">
												<span class="counter">7,000</span> <span>Successful
													rides</span>
											</div>
										</div>

										<div class="col-md-4 col-sm-4 col-xs-12">
											<div class="site-stat">
												<span class="counter">600,000</span> <span>Miles
													traveled in a good company</span>
											</div>
										</div>

									</div>
									<!-- end .parallax-content -->

								</div>
								<!-- end .main-parallax-content -->

							</div>
							<!-- end .paralax -->

						</div>
						<!-- end .fullscreen .background .parallax -->

					</div>
					<!-- end .col-md-12 -->

				</div>
				<!-- end .page-content -->

			</div>
			<!-- end .row -->
		</div>
		<!-- end .container -->

	</section>
	<!-- end .main-content -->

	<%@ include file="includes_foot.jsp"%>

</body>
</html>
