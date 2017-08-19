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
