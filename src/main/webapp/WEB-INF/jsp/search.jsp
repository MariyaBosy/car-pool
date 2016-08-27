<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="includes_head.jsp"%>
</head>

<body>

	<input id="user-id" type="hidden" value="${ user.getId() }">
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
												<li><a href="post">Give a ride</a></li>
												<li><a href="logout" id="logout">Logout</a></li>
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

							<div class="search-content">

								<form action="" novalidate autocomplete="off"
									class="idealforms searchtours">

									<div class="row">

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input value="I need a ride from" type="text" disabled>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<select id="source" name="source">
													<c:forEach var="source" items="${sources}">
														<option value="${ source.getId() }">${ source.getName() }</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input value="to" type="text" disabled>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">

											<div class="field">
												<input id="destination-latitude" name="destination.latitude"
													type="hidden"> <input id="destination-longitude"
													name="destination.longitude" type="hidden"> <input
													id="address" type="hidden"> <input
													id="autocomplete" placeholder="Destination"
													onFocus="geolocate()" type="text">
											</div>

										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input value="leaving" type="text" disabled>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<select id="departureTimeModifier"
													name="departureTimeModifier">
													<option value="LOE">before</option>
													<option value="GOE">after</option>
												</select>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input id="departure-time"><input
									id="departure-datetime" type="hidden" name="departureTime">
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input value="having" type="text" disabled>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<select id="seatsModifier" name="seatsAvailableModifier">
													<option value="EQ">exactly</option>
													<option value="LOE">at most</option>
													<option value="GOE">at least</option>
													<option value="GT">more than</option>
													<option value="LT">less than</option>
												</select>
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input name="seatsAvailable" type="number"
													placeholder="Number of seats">
											</div>
										</div>

										<div class="col-md-3 col-sm-3 col-xs-12">
											<div class="field">
												<input value="seats." type="text" disabled>
											</div>
										</div>


										<div class="col-md-3 col-sm-3 col-xs-12">

											<div class="field buttons">
												<button type="submit" class="btn btn-lg green-color">Find
													me a ride!</button>
											</div>

										</div>

									</div>


								</form>
							</div>
							<!-- end .search-content -->

						</div>
						<!-- end .col-sm-12 -->

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

				<div class="col-md-12 col-sm-12 col-xs-12">

					<div class="page-sub-title textcenter">
						<h2>Rides</h2>
						<div class="line"></div>
					</div>
					<!-- end .page-sub-title -->

				</div>
				<!-- end .col-md-12 col-sm-12 col-xs-12 -->

				<div class="col-md-12 col-sm-12 col-xs-12">

					<div class="page-content">

						<div class="rides-list">

							<c:forEach var="listing" items="${listings}">
								<article class="ride-box clearfix">

									<div class="ride-content">
										<h3>
											From <a href="#">${ listing.getSource().getName() }</a> To <a
												href="#">${ listing.getAddress() }</a>
										</h3>
										ride by <a href="#">${ listing.getUser().getName() }</a>
									</div>

									<ul class="ride-meta">

										<li class="ride-date"><a href="#" class="tooltip-link"
											data-original-title="Date" data-toggle="tooltip"> <i
												class="fa fa-clock-o"></i> <fmt:formatDate
													value="${ listing.getDepartureTime() }" pattern="HH:mm" />

										</a></li>
										<!-- end .ride-date -->

										<li class="ride-people"><a href="#" class="tooltip-link"
											data-original-title="Number of seats" data-toggle="tooltip">
												<i class="fa fa-user"></i> <span id="listing-${ listing.getId()}-seats">${ listing.getSeatsAvailable() }</span></a></li>
										<!-- end .ride-people -->

										<li><c:choose>
												<c:when test="${ isBooked.get(listing.getId()) }">
													<button class="btn green-color">
														<i class="fa fa-check" aria-hidden="true"></i> Booked
													</button>
												</c:when>
												<c:otherwise>
													<button value="${ listing.getId()}" class="btn blue-color bookSeat">Book
														Seat</button>


												</c:otherwise>
											</c:choose></li>

									</ul>
									<!-- end .ride-meta -->

								</article>
								<!-- end .ride-box -->
							</c:forEach>

							<div class="clearfix"></div>

							<div class="post-pagination pagination-margin clearfix">

								<div class="next pull-right">
									<a href="#"> Next <i class="fa fa-chevron-right"></i>
									</a>
								</div>

							</div>
							<!-- end .post-pagination -->

						</div>
						<!-- end .events-list -->

					</div>
					<!-- end .page-content -->

				</div>
				<!-- end .col-md-12 col-sm-12 col-xs-12 -->

			</div>
			<!-- end .row -->
		</div>
		<!-- end .container -->

	</section>
	<!-- end .main-content -->

	<%@ include file="includes_foot.jsp"%>

	<script>
		var placeSearch, autocomplete;
		var componentForm = {
			street_number : 'short_name',
			route : 'long_name',
			neighborhood : 'long_name',
			sublocality : 'long_name',
			administrative_area_level_1 : 'short_name',
			administrative_area_level_2 : 'short_name',
			country : 'long_name',
			postal_code : 'short_name'
		};

		function initAutocomplete() {
			// Create the autocomplete object, restricting the search to geographical
			// location types.
			autocomplete = new google.maps.places.Autocomplete(
			/** @type {!HTMLInputElement} */
			(document.getElementById('autocomplete')), {
				types : [ 'geocode' ]
			});

			// When the user selects an address from the dropdown, populate the address
			// fields in the form.
			autocomplete.addListener('place_changed', fillInAddress);
		}

		function fillInAddress() {
			// Get the place details from the autocomplete object.
			var place = autocomplete.getPlace();
			$('#destination-latitude')[0].value = place.geometry.location.lat();
			$('#destination-longitude')[0].value = place.geometry.location
					.lng();
			console.log($('#destination-latitude')[0].value);
			console.log($('#destination-longitude')[0].value);
			/*         for (var component in componentForm) {
			 document.getElementById(component).value = '';
			 document.getElementById(component).disabled = false;
			 }
			 */
			// Get each component of the address from the place details
			// and fill the corresponding field on the form.
			for (var i = 0; i < place.address_components.length; i++) {
				var addressType = place.address_components[i];
				if (componentForm[addressType]) {
					var val = place.address_components[i][componentForm[addressType]];
					/* 					document.getElementById(addressType).value = val;
					 */console.log(val);
				}
				console.log(addressType);
			}
		}
		// Bias the autocomplete object to the user's geographical location,
		// as supplied by the browser's 'navigator.geolocation' object.
		function geolocate() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var geolocation = {
						lat : position.coords.latitude,
						lng : position.coords.longitude
					};
					var circle = new google.maps.Circle({
						center : geolocation,
						radius : position.coords.accuracy
					});
					autocomplete.setBounds(circle.getBounds());
				});
			}
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDUSJkdCeRf3QiJQUNsXBjwff6LOyLNAT8&libraries=places&callback=initAutocomplete"
		async defer></script>
</body>
</html>
