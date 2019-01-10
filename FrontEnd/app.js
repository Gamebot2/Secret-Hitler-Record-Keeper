
const url = "http://localhost:5000/"

var app = angular.module('gameApp', ['ngRoute']);

app.controller('gameCtrl', function ($scope, $http) {
    $http.get(url + "gamesDisplay")
        .then(function (response) {
            $scope.games = response.data;
            console.log(response.data);
        });
});

var app2 = angular.module('playerApp', ['ngRoute', 'ngMaterial']);

app2.controller('playerCtrl', function ($scope, $http) {

    $http.get(url + "playersDisplay")
        .then(function (response) {
            $scope.players = response.data;
            console.log(response.data);
            $scope.players.forEach(function (element) {
                element.winPercentage = Math.round(element.winPercentage * 100);
            });
        });

    $scope.createPlayer = () => {
        try {
            var modUrl = url + 'addPlayer';
            $http({
                url: modUrl,
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                },
                data: JSON.stringify($scope.player),
            })
                .then(response => {
                    console.log(response.data);
                });

        }
        catch (err) {
            console.log(err);
        }
        location.reload();
    }

    $scope.remove = function(player) {
        console.log("This is so lit " + player.id);
        $http.get(url + "removePlayer?Id=" + player.id)
        .then(function(response) {
            console.log(response);
        });
        location.reload();
    };
});

app2.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('dark-grey').backgroundPalette('red').dark();
});

var app3 = angular.module('insertApp', ['ngRoute', 'ngMaterial']);

app3.controller('insertCtrl', function ($scope, $http) {
    console.log(10);

    $http.get(url + "players")
        .then(function (response) {
            $scope.players = response.data;
            console.log(response.data);
        });


    var modUrl = url + 'addGame';    
    $scope.onClick = () => {
        console.log($scope.game);
        try {
            $http({
                url: modUrl,
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                },
                data: JSON.stringify($scope.game),
            })
                .then(response => {
                    console.log(response.data);
                });

        }
        catch (err) {
            console.log(err);
        }
    }

});