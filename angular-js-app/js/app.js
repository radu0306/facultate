var app = angular.module('blog', [ ]);

+app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
//Persoana 
  $scope.persoane = [];
  $scope.keys = [];

  $scope.person = {};
  $scope.editPerson = {};



  $http.get('http://localhost:8080/persoana').then(
    function successCallback(response) {

    $scope.persoane = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addPersoana = function(person) {
    $scope.persoane.data.push(person);
    $http.post('http://localhost:8080/persoana', person);
    $scope.person = {};
  };

  $scope.setUpdatePerson = function(person) {
    $scope.editPerson = person;
  };

  $scope.updatePerson = function() {
    $http.put('http://localhost:8080/persoana', $scope.editPerson);
    $scope.editPerson = {};
  };

  $scope.deletePersoana = function(id) {
    $http.delete('http://localhost:8080/persoana/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  //Oras
  }]);
  +app.controller('OrasController', ['$scope', '$http', function($scope, $http) {
   
   $scope.oras = [];

   $scope.o = {};
   $scope.editO = {};
   $scope.keys = [];
 
 
   $http.get('http://localhost:8080/oras').then(
    function successCallback(response) {

    $scope.oras = response;
    $scope.keys = Object.keys(response.data[0]);
  });
 
 
   $scope.addOras = function(o) {
    $scope.oras.data.push(o);
    $http.post('http://localhost:8080/oras', o);
    $scope.o = {};
  };

  $scope.setUpdateO = function(o) {
    $scope.editO = o;
  };

  $scope.updateO = function() {
    $http.put('http://localhost:8080/oras', $scope.editO);
    $scope.editO = {};
  };

  $scope.deleteOras = function(id) {
    $http.delete('http://localhost:8080/oras/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  }]);
  
  //Film
  +app.controller('FilmController', ['$scope', '$http', function($scope, $http) {
    var url1 = "http://localhost:8080/film";
   
   $scope.film = [];

   $scope.f = {};
   $scope.editF = {};
   $scope.keys = [];
 
 
   $http.get('http://localhost:8080/film').then(
    function successCallback(response) {

    $scope.film = response;
    $scope.keys = Object.keys(response.data[0]);
  });
 
 
   $scope.addFilm = function(f) {
    $scope.film.data.push(f);
    $http.post('http://localhost:8080/film', f);
    $scope.f = {};
  };

  $scope.setUpdateF = function(f) {
    $scope.editF = f;
  };

  $scope.updateF = function() {
    $http.put('http://localhost:8080/film', $scope.editF);
    $scope.editF = {};
  };

  $scope.deleteFilm = function(id) {
    $http.delete('http://localhost:8080/film/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  }]);
  
  
  //Produs
  +app.controller('ProdusController', ['$scope', '$http', function($scope, $http) {

   $scope.prod = [];

   $scope.p = {};
   $scope.editP = {};
   $scope.keys = [];
 
 
   $http.get('http://localhost:8080/produs').then(
    function successCallback(response) {

    $scope.prod = response;
    $scope.keys = Object.keys(response.data[0]);
  });
 
 
   $scope.addProd = function(p) {
    $scope.prod.data.push(p);
    $http.post('http://localhost:8080/produs', p);
    $scope.p = {};
  };

  $scope.setUpdateP = function(p) {
    $scope.editP = p;
  };

  $scope.updateP = function() {
    $http.put('http://localhost:8080/produs', $scope.editP);
    $scope.editP = {};
  };

  $scope.deleteProd = function(id) {
    $http.delete('http://localhost:8080/produs/' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  }]);