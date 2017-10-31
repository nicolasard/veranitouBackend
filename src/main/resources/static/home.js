
angular.module('VeranitouConsultasApp', []).controller('VeranitouConsultasController', function($scope,$http) {
   $scope.ListaConsultasUrl = "/secure/consultas/lista/";
   $scope.CantidadRegistrosUrl = "/secure/consultas/cantidad/"
   $scope.CantidadRegistros = 0;
   $scope.Paginas = 0;
   $scope.qty = 2;
   $scope.page = 1;
   $scope.consultas = [];

   $scope.loadConsultas = function(qty,page){
    $scope.loadCantidad();
    console.log("Loading Consultas...")
    $scope.qty = qty;
    $scope.page = page;
    gData = {params:{qty:$scope.qty,page:$scope.page}};
    $http.get($scope.ListaConsultasUrl,gData).then(function(response) {
            console.log(response.data);
            $scope.consultas = response.data;
        });

    //Calculo la cantidad de hojas 
    var cantidad = $scope.CantidadRegistros / $scope.qty;
    $scope.Paginas = new Array();
    for (i = 0; i < cantidad; i++) { 
        $scope.Paginas.push(i);
    }
    console.log($scope.Paginas);
    console.log("Cantidad",cantidad);
   };

   $scope.loadCantidad = function(){
    console.log("Cargando Cantidad de registros...");

    $http.get($scope.CantidadRegistrosUrl).then( function(response){
            console.log(response.data);
            $scope.CantidadRegistros = response.data;
   });
   };

   $scope.paginaSiguiente = function(){
    
   };

   $scope.paginaAnterior = function(){

   };
});