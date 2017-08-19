var RegistrationModule=angular.module('RegistrationModule',[]);

RegistrationModule.controller('RegistrationController',function(RegistrationService,$location){

//object for the RegistrationController

var regCtrl=this;

  regCtrl.account={};
  regCtrl.conform=false;

  regCtrl.register=function()
  {
    console.log(regCtrl.account);
    RegistrationService.register(regCtrl.account).then(
      function(response) {
        console.log(response);
        $location.path("/login")
      },
      function(error) {
        console.log(error);
      }

    )
  }

})
