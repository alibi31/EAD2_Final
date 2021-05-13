<jsp:useBean id="user" class="com.example.JustBlog.Entity.Users" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<header class="header-section">
    <a href="#" class="site-logo">
        <img src="img/logo.png" alt="logo">
    </a>
    <ul class="main-menu">
        <li><a href="index">Home</a></li>
        <li><a href="characters">Characters</a></li>
        <li><a href="game">Games</a></li>
        <li><a href="AllPostsServlet">Posts</a></li>
        <% if (user.getUsername() == null) { %>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="register">Register</a></li>
        <%}%>
        <% if (user.getUsername() != null) { %>
        <li><a href="index.jsp"><jsp:getProperty name="user" property="username"/></a></li>
        <li><a href="newPost.jsp">New Post</a></li>
        <li><a href="LogoutServlet">Log out</a></li>
        <%}%>
    </ul>
    <div class="header-add">
        <img src="img/add.jpg" alt="">
    </div>
</header>