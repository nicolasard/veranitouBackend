
angular.module('VeranitouConsultasApp', []).controller('VeranitouConsultasController', function($scope,$http) {
   $scope.ListaConsultasUrl = "/secure/consultas/lista/";
   $scope.greeting = "Hello World";
   $scope.consultas = ["Banana", "Orange", "Apple", "Mango"];

   $scope.loadConsultas = function(){
    console.log("Loading Consultas...")
    $http.get($scope.ListaConsultasUrl).then(function(response) {
            console.log(response.data);
            $scope.consultas = response.data;
        });
   };

});