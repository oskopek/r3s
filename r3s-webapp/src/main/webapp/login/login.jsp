<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="SHORTCUT ICON" href="/resources/r3s_icon.svg">
    <link rel="icon" href="/resources/r3s_icon.svg"
          type="image/ico">
    <title>R3S - Login</title>
    <link rel="stylesheet" type="text/css" href="/resources/site.css">
</head>

<body>
<div class="header">
    <div class="logo"><a href="/app/index.jsp" target="_top">
        <img src="/resources/r3s-logo.png" alt="OpenCV"/></a>
    </div>
    <div class="topRow"><strong>
        <span class="link"><a href="/app/index.jsp" target="_top">Home</a></span>
        <span class="link"><a href="/info/features.jsp" target="_top">Features</a></span>
        <span class="link"><a href="/info/contribute.jsp">Contribute</a></span>
        <span class="link"><a href="/info/contact_us.jsp" target="_top">Contact us</a></span>
    </strong>
    </div>
</div>

<div class="mainColumn">
    <div><h2>Log in</h2></div>
    <form method="post" target="_top" action="j_security_check">
        <p>Username: <input type="text" name="j_username"/></p>

        <p>Password: <input type="password" name="j_password"/></p>

        <p><input type="submit" value="Log in"/></p>
    </form>
</div>

<div id="footer"></div>

</body>
</html>