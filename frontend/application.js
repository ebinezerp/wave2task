var Application=angular.module('Application',['ngRoute','RegistrationModule','LoginModule','ngCookies','UserModule']);


 Application.config(function ($routeProvider) {
$routeProvider.when('/',{
  templateUrl:'./user/pages/signin.html',
  controller:'LoginController',
  controllerAs:'loginCtrl'
})
.when('/register',{
  templateUrl:'./user/pages/register.html',
  controller:'RegistrationController',
  controllerAs:'regCtrl'
})
.when('/login',
{
  templateUrl:'./user/pages/signin.html',
  controller:'LoginController',
  controllerAs:'loginCtrl'
})
.when('/home',{
  resolve:{
    authorized:function($cookieStore,$location)
    {

      if($cookieStore.get('currentUser')==null)
      {
        $location.path('/')
      }
    }
    },
  templateUrl:'./user/pages/home.html',
  controller:'UserController',
  controllerAs:'userCtrl'
})
 })

 Application.constant('REST_URI','http://localhost:8090/restservices/')

 Application.directive('validPasswordC', function() {
   return {
     require: 'ngModel',
     scope: {

       reference: '=validPasswordC'

     },
     link: function(scope, elm, attrs, ctrl) {
       ctrl.$parsers.unshift(function(viewValue, $scope) {

         var noMatch = viewValue != scope.reference
         ctrl.$setValidity('noMatch', !noMatch);
         return (noMatch)?noMatch:!noMatch;
       });

       scope.$watch("reference", function(value) {;
         ctrl.$setValidity('noMatch', value === ctrl.$viewValue);

       });
     }
   }
 });
