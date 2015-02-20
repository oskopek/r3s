<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="SHORTCUT ICON" href="/resources/r3s_icon.svg">
    <link rel="icon" href="/resources/r3s_icon.svg"
          type="image/ico">
    <title>R3S - Contribute</title>
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
    <h2>Contributing</h2>

    <p><strong>Everyone</strong> is encouraged to help improve this project.

    <p>Here are some ways <strong>you</strong> can contribute:

    <ul>
        <li> by using alpha, beta, and pre-release versions
        <li> by reporting bugs
        <li> by suggesting new features
        <li> by implementing <a href="https://github.com/oskopek/r3s/blob/master/docs/goals.adoc">planned features</a>
        <li> by translating to a new language
        <li> by <a href="https://github.com/oskopek/r3s/blob/master/docs/howto-write-documentation.adoc">writing or
            editing documentation</a>
        <li> by writing specifications
        <li> by writing code (<strong>no patch is too small</strong>: fix typos, add comments, clean up inconsistent
            whitespace)
        <li> by refactoring code
        <li> by closing <a href="https://github.com/oskopek/r3s/issues">issues</a>
        <li> by reviewing patches
    </ul>

    <h3>Submitting an Issue</h3>

    <p>We use the <a href="https://github.com/oskopek/r3s/issues">GitHub issue tracker</a> to track bugs and features.
        Before
        submitting a bug report or feature request, check to make sure it hasn't
        already been submitted. When submitting a bug report, please include a <a
                href="https://gist.github.com/">Gist</a>
        that includes a stack trace and any details that may be necessary to reproduce
        the bug, including your Java version and operating system.

    <h3>Submitting a Pull Request</h3>

    <p>
    <ul>
        <li><a href="http://help.github.com/fork-a-repo/">Fork the repository</a>
        <li><a href="http://learn.github.com/p/branching.html">Create a topic branch</a>
        <li> Implement your feature or bug fix
        <li> If applicable, add tests for your feature or bug fix
        <li> Run <samp>mvn clean install -Pit</samp>
            <ul>
                <li> If you contributed to <strong>r3s-webapp</strong>, run: <samp>mvn clean install
                    -Pit,wildfly-it</samp>
            </ul>
        <li> If the tests fail, return to step 3 and 4
        <li> Add, commit, and push your changes
        <li><a href="http://help.github.com/send-pull-requests/">Submit a pull request</a>
    </ul>
</div>

<div id="footer"></div>

</body>
</html>