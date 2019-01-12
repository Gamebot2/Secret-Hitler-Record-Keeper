'use strict';
const url = "http://sharkappserver.us-east-1.elasticbeanstalk.com/"

var sharkApp = angular.module('sharkApp', ['ngRoute']);

sharkApp.service('cognitoService', function () {

    // Region
    AWS.config.region = 'us-east-1';
    AWS.config.credentials = new AWS.CognitoIdentityCredentials({
        IdentityPoolId: 'us-east-1:9c2935c6-770c-4ec2-b833-eeb1dc2ed839'
    });

    // Cognito User Pool Id
    AWSCognito.config.region = 'us-east-1';
    AWSCognito.config.credentials = new AWS.CognitoIdentityCredentials({
        IdentityPoolId: 'us-east-1:9c2935c6-770c-4ec2-b833-eeb1dc2ed839 '
    });

    this.getUserPool = function () {
        var poolData = {
            UserPoolId: 'us-east-1_MYybNGahA',
            ClientId: '3tbofej2l1nhuer11clglmtogn'
        };
        var userPool = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserPool(poolData);
        return userPool;
    };

    this.getUser = function (userPool, username) {
        var userData = {
            Username: username,
            Pool: userPool
        };
        var cognitoUser = new AWSCognito.CognitoIdentityServiceProvider.CognitoUser(userData);
        return cognitoUser;
    };

    this.getAuthenticationDetails = function (username, password) {
        var authenticationData = {
            Username: username,
            Password: password
        };
        var authenticationDetails = new AWSCognito.CognitoIdentityServiceProvider.AuthenticationDetails(authenticationData);
        return authenticationDetails;
    };

    this.getUserAttributes = function () {
        var attributes = [];
        for (var i = 0; i < arguments.length; i++) {
            var attr = new AWSCognito.CognitoIdentityServiceProvider.CognitoUserAttribute(arguments[i]);
            attributes.push(attr);
        }
        return attributes;
    };

});




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

    $scope.remove = function (player) {
        console.log("This is so lit " + player.id);
        $http.get(url + "removePlayer?Id=" + player.id)
            .then(function (response) {
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

        document.location.href = "RecordsPage.html";
    }

});