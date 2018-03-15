<div class="container">

	<div class="row">

		<!-- display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- display the actual products  -->
		<div class="col-md-9">
		
			<!-- Added Breadcrumb component-->
			<div class="row">

				<div class="col-lg-12">


					<c:if test="${userClickProduct == true}">
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All products</li>
							
						</ol>
						
					</c:if>

					<c:if test="${userClickCategory == true}">
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
							
						</ol>
						
					</c:if>
				</div>

			</div>

		</div>


	</div>




</div>