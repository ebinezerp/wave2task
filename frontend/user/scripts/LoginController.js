var LoginModule=angular.module('LoginModule',[]);

LoginModule.controller('LoginController',function (LoginService,$cookieStore,$location,$rootScope) {
  var loginCtrl=this;
  loginCtrl.account={};
  loginCtrl.login=function() {
    console.log(loginCtrl.account);
    LoginService.login(loginCtrl.account).then(
      function(response)
      {
        console.log(response);
        console.log(response.status==200)
        if(response.status==200)
        {
          $cookieStore.put('currentUser',response.data);
          $rootScope.currentUser=$cookieStore.get('currentUser');
          $location.path('/home');
        }
      },
      function(error) {
          console.log(error);
      }
    )
  }
})
