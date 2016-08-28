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
<title>Error - Jedi Car Pool</title>
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="includes_head.jsp"%>

</head>

<body>

	<header class="header">

		<div class="main-baner">

			<div class="background parallax clearfix"
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
												<li><a href="/car-pool">Return to site</a></li>
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

				<div class="col-sm-12 col-md-12 col-xs-12">

					<div class="page-sub-title textcenter">
						<h2>${status} ${error}</h2>
						<div class="line"></div>
					</div>
					<!-- end .page-sub-title -->

				</div>
				<!-- end .col-lg-12 -->

				<div class="col-sm-12 col-md-12 col-xs-12">

					<div class="page-content add-new-ride">
						<c:choose>
							<c:when test="${status==500}">
								<p>Something went wrong. We apologize for the inconvenience.</p>
							</c:when>
							<c:when test="${status==404}">
								<p>This isn't the page you're looking for.</p>
								<p>Check the URL and try again.</p>
							</c:when>
							<c:when test="${status==400}">
								<p>There's something wrong with your request.</p>
								<p>Check that everything is correct and try again.</p>
							</c:when>
							<c:otherwise>
								<p>${message}</p>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- end .page-content -->

				</div>
				<!-- end .col-sm-12 -->

			</div>
			<!-- end .row -->
		</div>
		<!-- end .container -->

	</section>
	<!-- end .main-content -->

</body>
</html>
