'use strict';

var Login = angular.module("login", ['ngCookies']);

Login.config(function ($routeProvider) {
	$routeProvider     
		.when('/status/:statusCode', {
			controller: 'LoginCtrl'
		})
		.otherwise({
			redirectTo: '/'
		});
	});