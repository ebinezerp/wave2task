var Application=angular.module('Application',['ngRoute','RegistrationModule']);


 Application.config(function ($routeProvider) {
$routeProvider.when('/',{
  templateUrl:'./user/pages/signin.html'
})
.when('/register',{
  templateUrl:'./user/pages/register.html',
  controller:'RegistrationController',
  controllerAs:'regCtrl'
})
 })
