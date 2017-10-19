
angular.module('VeranitouConsultasApp', []).controller('VeranitouConsultasController', function($scope,$http) {
   $scope.ListaConsultasUrl = "/secure/consultas/lista/";
   $scope.qty = 2;
   $scope.page = 1;
   $scope.consultas = [];

   $scope.loadConsultas = function(qty,page){
    console.log("Loading Consultas...")
    $scope.qty = qty;
    $scope.page = page;
    gData = {params:{qty:$scope.qty,page:$scope.page}};
    $http.get($scope.ListaConsultasUrl,gData).then(function(response) {
            console.log(response.data);
            $scope.consultas = response.data;
        });
   };

});