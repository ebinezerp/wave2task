UserModule.service('UserService',function($http,$q,REST_URI) {
    this.logout=function() {
      var deffered=$q.defer();
          $http.get(REST_URI+'logout').then
          (
            function(success)
            {
                  deffered.resolve('logout sucsessfully')
            },
            function(error) {
              deffered.reject('error occured');
            }
          )
          return deffered.promise;
    }
})
