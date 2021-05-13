<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <title>Posts</title>
    <%@include file="head.jsp" %>
</head>
<body>

<jsp:useBean id="postList" type="java.util.List<com.example.JustBlog.Entity.Posts>" scope="request"/>
<jsp:setProperty name="postList" property="*"/>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header section -->
<%@include file="navbar.jsp" %>>
<!-- Header section end -->
<%! int counter = 0; %>

<!-- Page top section -->
<section class="page-top-section set-bg" data-setbg="img/header-bg/1.jpg">
    <div class="container">
        <h2>Posts</h2>
    </div>
</section>
<!-- Page top section end -->


<!-- Blog section -->
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <% for (int i = 0; i < postList.size(); i++) { %>
                <div class="blog-post review-post">
                    <img src="img/game-review/1.jpg" alt="">
                    <div class="post-date">30 April, 2021</div>
                    <h3><% out.print(postList.get(i).getTheme());%> </h3>
                    <div class="post-metas">
                        <div class="post-meta"><% out.print(postList.get(i).getUsers().getUsername());%></div>
                        <div class="post-meta">in <a href="#">Games</a></div>
                        <div class="post-meta">3 Comments</div>
                    </div>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <p><% out.print(postList.get(i).getBody());%></p>
                    <a href="PostDetailServlet?&postId=<%=postList.get(i).getPostid()%>" class="site-btn">Read More</a>
                </div>
                <%}%>

            </div>
        </div>
    </div>
</section>
<!-- Blog section end -->

<!-- Footer section -->
<%@include file="footer.jsp"%>
<!-- Footer section end -->

<!--====== Javascripts & Jquery ======-->
<%@include file="script.jsp"%>

</body>
</html>

