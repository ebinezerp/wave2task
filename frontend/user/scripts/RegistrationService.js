RegistrationModule.service('RegistrationService',function(REST_URI,$http,$q){
  this.register=function(account) {
        var deffered=$q.defer();
        $http.post(REST_URI+'register',account).then(
          function (response) {
              console.log(response);
              deffered.resolve(response);
          },
          function(error) {
                   console.log(error);
                   deffered.reject(error);
          }
        )
        return deffered.promise;
  }
})
