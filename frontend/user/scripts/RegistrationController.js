var RegistrationModule=angular.module('RegistrationModule',[]);

RegistrationModule.controller('RegistrationController',function(){

//object for the RegistrationController

var regCtrl=this;

  regCtrl.account={};
  regCtrl.conform=false;

  regCtrl.register=function()
  {
    console.log(regCtrl.account);
  }

})
