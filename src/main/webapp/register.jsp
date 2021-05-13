<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign UP</title>
    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="login.css"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Sign In</h5>
                    <form class="form-signin" action="RegisterServlet" method="post">
                        <div class="form-label-group">
                            <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Username" required autofocus>
                            <label for="inputEmail">Email address</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                            <label for="inputPassword">Password</label>
                        </div>
                        <div class="form-label-group">
                            <input type="password" id="inputPassword1" name="password2" class="form-control" placeholder="Confirm Password" required>
                            <label for="inputPassword1">Confirm Password</label>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember password</label>
                        </div>
                        <button class="btn btn-lg btn-dark btn-block text-uppercase" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="script.jsp"%>
</body>
</html>
