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
<title>Jedi Car Pool - Add ride</title>
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
												<li><a href="search">Find a ride</a></li>
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
						<h2>Add new ride</h2>
						<div class="line"></div>
					</div>
					<!-- end .page-sub-title -->

				</div>
				<!-- end .col-lg-12 -->

				<div class="col-sm-12 col-md-12 col-xs-12">

					<div class="page-content add-new-ride">

						<form id="postForm" action="listings" method="POST" novalidate
							autocomplete="off" class="idealforms add-ride">

							<div class="field">
								<select id="source" name="source.id">
									<c:forEach var="source" items="${sources}">
										<option value="${ source.getId() }">${ source.getName() }</option>
									</c:forEach>
								</select>
							</div>



							<div class="field">
								<input id="destination-latitude" name="address.latitude"
									type="hidden"> <input id="destination-longitude"
									name="address.longitude" type="hidden"> <input
									id="destination-address" name="address.formattedAddress"
									type="hidden"> <input name="user.id"
									type="hidden"> <input name="vehicle.id" value="1"
									type="hidden"> <input id="autocomplete"
									placeholder="Destination" onFocus="geolocate()" type="text">
							</div>

							<div class="field">
								<input id="departure-time"> <input
									id="departure-datetime" type="hidden" name="departureTime">
							</div>

							<div class="field">
								<div class="field">
									<input name="seatsAvailable" type="number"
										placeholder="Number of seats">
								</div>
							</div>

							<div class="field buttons">
								<button type="submit" class="btn btn-lg green-color"><a data-toggle="modal" data-target="#infoModal">
								Submit</a></button>
						
							</div>

						</form>

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

	<div class="modal fade" id="infoModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>

				<div id="modal-info" class="modal-body"></div>
				<!-- end .modal-body -->

			</div>
			<!-- end .modal-content -->
		</div>
		<!-- end .modal-dialog -->
	</div>
	<!-- end .modal -->

	<%@ include file="includes_foot.jsp"%>
	<script>
		var frm = $("#postForm");
		frm.submit(function(e) {
			$('#modal-info').text("Saving your ride...")
			$('#infoModal').modal('show');
			$.ajax({
				type : frm.attr('method'),
				url : frm.attr('action'),
				data : frm.serialize(),
				success : function(data) {
					$('#modal-info').text("Ride successfully submitted!")
				},
				error : function(data) {
					$('#modal-info').text("Looks like there are some errors in the form. Please fix the following problems to post your ride:");
					$('#modal-info').append("<ol></ol>");
					for(var i=0; i < data.responseJSON.errors.length; i++) {
						var err = data.responseJSON.errors[i];
						$('#modal-info ol').append('<li>' + err.defaultMessage + '</li>')
					}
				}
			});

			e.preventDefault();
		});
		var placeSearch, autocomplete;

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
			$('#destination-address')[0].value = place.formatted_address;
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
