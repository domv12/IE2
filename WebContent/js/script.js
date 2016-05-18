	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['ngRoute']);

	// configure our routes
	scotchApp.config(function($routeProvider) {
		$routeProvider

			// route for the home page
			.when('/', {
				templateUrl : 'Pages/home.html',
				controller  : 'mainController'
			})
			
			// route for the catalog page
			.when('/catalog', {
				templateUrl : 'Pages/catalog.html',
				controller  : 'catalogController'
			})

			// route for the about page
			.when('/about', {
				templateUrl : 'Pages/about.html',
				controller  : 'aboutController'
			})

			// route for the contact page
			.when('/contact', {
				templateUrl : 'Pages/contact.html',
				controller  : 'contactController'
			});
	});

	// create the controller and inject Angular's $scope
	scotchApp.controller('mainController', function($scope) {
		// create a message to display in our view
		$scope.message = 'Everyone come and see how good I look!';
	});

	scotchApp.controller('catalogController', function($scope,$http) {
		$scope.message = 'I am an catalog page.';
		
		 $http.get("bookList").then(function(response) {
		        $scope.myData = response.data;
		    });
		
		
	});
	
	scotchApp.controller('aboutController', function($scope) {
		$scope.message = 'Look! I am an about page.';
		
		
		
	});

	scotchApp.controller('contactController', function($scope, $http) {

		var name;
		var email;
		var comment;
		
		 $scope.myTxt = "1";
		 $scope.myFunc = function () {
			
			  name = $scope.name;
			  email = $scope.email;
			  comment = $scope.comment;
			  
			  
			  var message = {name: name, email: email, comment: comment};
			  $http.post('/LiblaryProject/send', message)
			    .success(function() {
			      console.log("msg sent");
			    })
			    .error(function() {
			      console.log("msg failed");
			    });
			  
			 $scope.myTxt = email;
		  }
		 
	});
	
	
	
	
	
	