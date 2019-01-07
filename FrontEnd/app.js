var app = angular.module('gameApp', ['ngRoute']);

app.controller('gameCtrl', function($scope, $http) {
    $http.get("http://localhost:5000/gamesDisplay")
    .then(function(response) {
        $scope.games = response.data;
        console.log(response.data);
    });
});

var app2 = angular.module('playerApp', ['ngRoute', 'ngMaterial']);

app2.controller('playerCtrl', function($scope, $http) {
    $http.get("http://localhost:5000/playersDisplay")
    .then(function(response) {
        $scope.players = response.data;
        $scope.players.forEach(function(element) {
            element.winPercentage = Math.round(element.winPercentage * 100);
            console.log(element.winPercentage);
        });
    });
});

app2.config(function($mdThemingProvider) {
    $mdThemingProvider.theme('dark-grey').backgroundPalette('red').dark();
});

var app3 = angular.module('insertApp', ['ngRoute', 'ngMaterial']);

app3.controller('insertCtrl', function($scope, $http) {
    $scope.teams = ['Fascists', 'Liberals'];
});