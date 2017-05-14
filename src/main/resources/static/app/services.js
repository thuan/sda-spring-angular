(function(angular) {
  var MovieFactory = function($resource) {
    return $resource('/movies/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  MovieFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Movie", MovieFactory);
}(angular));