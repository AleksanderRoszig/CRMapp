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

                <span class="navbar-brand mb-0 h1"></span>


                <div class="float-right">
                    <ul class="nav justify-content-end">
                        <li class="nav-item">
                            <a class="nav-link active" href="list">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/crmapp/customer/list">Clients</a>
                        </li>


						<!-- its not usefull -->
                        <li class="nav-item">
                            <a class="nav-link" href="/crmapp/product/list">Products</a>
                        </li>

						<!-- spring security -->
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
                            <p>This site include setting parameters of new client. In backend I included Hibernate Validator which check is new parameters compatible with my settings like minimum size of name or surname. The correctness of email is checked by frontend layer. </p>
                        </div>
                    </div>
                    <div class="col-12 col-md-4">

                        <div class="section-about__user box box--color">
                            <h3>Logged as</h3>
                            <p class="margin__top--small">ADMIN</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <section class="section-addclient">
            <div class="container">

                <div class="client">
                    <h3>Add client</h3>
                    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
                    <form:hidden path="id" />
                        <div class="form-group">
                            <label for="InputName">Name</label>
                            <form:input path="firstName"  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Set name"/>
                        	<form:errors path="firstName" placeholder="error" />
                        </div>

                        <div class="form-group">
                            <label for="InputSurname">Surname</label>
                            
                            <form:input path="lastName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Set surname"/>
                      		<form:errors path="lastName" placeholder="error" />
                        </div>

                        <div class="form-group">
                            <label for="InputEmail1">Email</label>
                         
                            <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Set email"/>
                        </div>

						
                        
                        <div class="form-group">
                            <label for="FormControlSelect">Select sector</label>
                            <select class="form-control" id="FormControlSelect1">
                                <option>Java Developer</option>
                                <option>651</option>
                                <option>a</option>
                                <option>a</option>
                                <option>a</option>
                            </select>
                        </div>

                        <td><input type="submit" value="Save" class="save" /></td>
                    </form:form>
                </div>
            </div>

        </section>

        <footer class="section-footer">
            <p class="copy">in progress</p>
        </footer>


        <script src="${pageContext.request.contextPath}/resources/js/Chart.js"></script>
</body>

</html>