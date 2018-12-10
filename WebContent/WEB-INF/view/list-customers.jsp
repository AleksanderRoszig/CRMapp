<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>CRM application</title>
</head>



<body>
    <div class="section-navigation">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <div class="container">

                <span class="navbar-brand mb-0 h1">by Aleksander Roszig</span>


                <div class="float-right">
                    <ul class="nav justify-content-end">
                        <li class="nav-item">
                            <a class="nav-link active" href="/crmapp/customer/list">Home</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="/crmapp/product/showFormForAdd">Add product</a>
                        </li>
					
					<li class="nav-item">
                            <a class="nav-link" href="/crmapp/customer/showFormForAdd">Add client</a>
                        </li> 	
                        <li class="nav-item">
                            <a class="nav-link" href="/crmapp/customer/list">Clients</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/crmapp/product/list">Products</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link disabled" href="login.html">Log out</a>
                        </li>
                    </ul>
                </div>

        </nav>
        </div>
        <section class="section-about">
            <div class="container">
                <div class="row">


                    <div class="col-12 col-md-8">


                        <div class="section-about__text box">
                            <h3>About project</h3>
                            <p>This site include search engine, adding, deleting and updating options. Searching search all three positions: name, surname and email and isn't case sensitive</p>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">

                        <div class="section-about__user box box--color">
                            <h3>Logged as</h3>
                            <p class="margin__top--small">It doesn't work yet</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="section-table">
            <div class="container">
                <div class="client">
                    <h3>Client table</h3>

                              <!--  add a search box -->
            <form:form action="search" method="POST">
                Search product: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
                
            </form:form>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Surname</th>
                                <th scope="col">Email</th>
                                <th scope="col">Select</th>
                            </tr>
                        </thead>
                        <tbody>
                           
                <!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
							<!-- display the update link -->
							<button href="${updateLink}" type="button" class="btn btn-success"> <a href="${updateLink}" class="link_link"> Update</a></button>
							<button href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" type="button"
							 class="btn btn-danger"> <a href="${deleteLink}" class="link_link">Delete  </a></button>
							<button type="button" class="btn btn-dark">Select</button>
				
						</td>
						
					</tr>
				
				</c:forEach>
				
				
            </tbody>
            </table>
            
           
    </div>
    </div>
    </section>


    <footer class="section-footer">
        <p class="copy">in progress</p>
    </footer>


    <script src="${pageContext.request.contextPath}/resources/js/Chart.js"></script>
</body>

</html>