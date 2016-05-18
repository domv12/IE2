<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>

<!-- define angular app -->
<html ng-app="scotchApp">

<head>
  <!-- SCROLLS -->
  <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />
  <link href="css/custom.css" rel="stylesheet" type="text/css" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/css/custom.css" />" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/css/contact.css" />" />
  <link type="text/css" rel="stylesheet" href="<c:url value="/css/catalog.css" />" />
   

  <!-- SPELLS -->
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular-route.min.js"></script>
  <script src="<c:url value="/js/script.js" />"></script>
</head>

<!-- define angular controller -->
<body ng-controller="mainController">

  <nav class="navbar navbar-default">
    <div class="container">
      <div class="navbar-header">
        <div class="navbar-brand"> 
        <img src="img/logo.png" alt="logo" height="20" width="75" >
        Probably the most dynamic library in the universe!</div>
      </div>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="#catalog"><i class="fa fa-book"></i> Catalog</a></li>
        <li><a href="#about"><i class="fa fa-shield"></i> Account</a></li>
        <li><a href="#contact"><i class="fa fa-comment"></i> Contact</a></li>
      </ul>
    </div>
  </nav>

  <div id="main">
  
    <!-- angular templating -->
		<!-- this is where content will be injected -->
    <div ng-view></div>
     
  </div>
  
  <footer class="center">
					<a href="https://www.facebook.com/dominik.kownacki" class="btn-share-md" target="_blank">				
					<div class="fb">								
							<i class="fa fa-facebook"></i>																												
					</div>
					</a>
					<a href="https://twitter.com/lmao" class="btn-share-md" target="_blank">	
					<div class="twitter">					
							<i class="fa fa-twitter"></i>											
					</div>
					</a>
					<a href="https://www.youtube.com/user/szczeryjerry" class="btn-share-md" target="_blank">							
					<div class="yt">
							<i class="fa fa-youtube"></i>
						
					</div>
					</a>
  </footer>

</body>

</html>
