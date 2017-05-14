(function(angular) {
  var AppController = function($scope, Movie) {
    Movie.query(function(response) {
      $scope.movies = response ? response : [];
    });
    
    $scope.addMovie = function(name, author, description, favorite) {
      new Movie({
        name : name,
        author: author,
        description: description,
        favorite: favorite,
        checked: false
      }).$save(function(Movie) {
        $scope.movies.push(Movie);
      });
      $scope.newMovie = "";
    };
    
    $scope.updateMovie = function(Movie) {
      Movie.$update();
    };
    
    $scope.deleteMovie = function(Movie) {
      Movie.$remove(function() {
        $scope.movies.splice($scope.movies.indexOf(Movie), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Movie'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));