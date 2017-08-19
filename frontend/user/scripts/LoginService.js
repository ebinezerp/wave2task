LoginModule.service('LoginService',function(REST_URI,$http,$q) {
  this.login=function(account) {
      var deffered=$q.defer();
      $http.post(REST_URI+'login',account).then(
        function(response)
        {
          deffered.resolve(response);
        },
        function (error) {
          deffered.reject(error);
        }
      )
      return deffered.promise;
  }

})
