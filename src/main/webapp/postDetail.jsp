<%@ page import="com.example.JustBlog.Entity.Comments" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <title>Post Detail</title>
    <%@include file="head.jsp"%>
</head>
<body>
<jsp:useBean id="post" class="com.example.JustBlog.Entity.Posts" scope="request"/>
<jsp:setProperty name="post" property="*"/>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header section -->
<%@include file="navbar.jsp"%>
<!-- Header section end -->

<section class="page-top-section set-bg" data-setbg="img/header-bg/2.jpg">
    <div class="container">
        <h2>Post Details</h2>
    </div>
</section>

<section class="testimonials-section">
    <div class="container">
        <div class="game-title">
            <img src="img/game-characters/title-icon.png" alt=""><p> <small>by</small> <%=post.getUsers().getUsername()%><p>
            <h2><%=post.getTheme()%></h2>
            <p><%=post.getBody()%></p>
        </div>

        <% for (Comments comment: post.getComments()) { %>
        <div class="testimonial">
            <div class="testimonial-text">
                <div class="test-date"><%=comment.getUsers().getUsername()%></div>
                <h4><%=comment.getComment()%></h4>
                <% if (user.getUsername() != null) { %>
                <form action="LikesServlet" method="get">
                    <input type="hidden" name="commentId" value="<%=comment.getCommentid()%>">
                <button type="submit" class="btn btn-success" name="like" value="true">
                    Likes <span class="badge badge-light"><%=comment.getLikes()%></span></button>
                <button type="submit" class="btn btn-danger" name="dislike" value="true">
                    Dislikes <span class="badge badge-light"><%=comment.getDislikes()%></span></button>
                </form>
                <%}%>
                <% if (user.getUsername() == null) { %>
                    <a type="submit" class="btn btn-success" href="login.jsp">
                        Likes <span class="badge badge-light"><%=comment.getLikes()%></span></a>
                    <a type="submit" class="btn btn-danger" href="login.jsp">
                        Dislikes <span class="badge badge-light"><%=comment.getDislikes()%></span></a>
                      <%}%>
            </div>

        </div>
        <%}%>
        <% if (user.getUsername() != null) { %>
        <form action="CommentServlet" method="post">
        <div class="form-group">
            <input type="hidden" name="postId" value="<%=post.getUserid()%>">
            <input type="hidden" name="userId" value="<%=user.getId()%>">
            <label for="comment">Comment:</label>
            <textarea name="comment" class="form-control" rows="5" id="comment" placeholder="New comment..."></textarea><br>
            <button type="submit" class="btn badge-dark btn-lg">Send</button>
        </div>
        </form>
        <%}%>
        <% if (user.getUsername() == null) { %>
        <form action="CommentServlet" method="post">
            <div class="form-group">
                <label for="comment1">Comment:</label>
                <textarea class="form-control" rows="5" id="comment1" placeholder="Please login first" disabled></textarea>
            </div>
        </form>
        <%}%>
    </div>
</section>
<!-- Testimonials section end -->


<!-- Footer section -->
<%@include file="footer.jsp"%>
<!-- Footer section end -->

<!--====== Javascripts & Jquery ======-->
<%@include file="script.jsp"%>

</body>
</html>

