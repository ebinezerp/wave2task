var UserModule=angular.module('UserModule',[]);

UserModule.controller('UserController',function(UserService,$cookieStore,$location)
{
  var userCtrl=this;
  userCtrl.account={};
  userCtrl.account=$cookieStore.get('currentUser');

  userCtrl.logout=function()
  {
      UserService.logout().then(
        function(success)
        {
          alert(success);
          $cookieStore.remove('currentUser');
          $location.path('/login')

        },
        function(error) {
          alert(error)
        }
      )

  }

})
