<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <title>Posts</title>
    <%@include file="head.jsp" %>
</head>
<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header section -->
<%@include file="navbar.jsp" %>>

<section class="page-top-section set-bg" data-setbg="img/header-bg/1.jpg">
    <div class="container">
        <h2>New Post</h2>
    </div>
</section>

<div class="video-section">
    <div class="container">
        <div class="video-logo">
            <img src="img/logo-2.png" alt="">
            <p>Create New Post</p>
        </div>
        <div class="video-popup-warp">
            <form action="AddNewPostServlet" method="post">
            <div class="form-outline">
                <h4 style="color: #6a6a6a">Theme:</h4>
                <input type="hidden" name="userId" value="<%=user.getId()%>">
                <input type="text" name="theme" id="typeText" class="form-control" />
            </div><br>

            <div class="form-outline">
                <h4 style="color: #6a6a6a">Post body:</h4>
                <input type="hidden" name="userId" value="<%=user.getId()%>">
                <textarea class="form-control" name="body" id="textAreaExample" rows="4"></textarea>
            </div><br>
                <button type="submit" class="btn btn-dark btn-lg">Send</button>
            </form>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
<%@include file="script.jsp"%>

</body>
</html>

