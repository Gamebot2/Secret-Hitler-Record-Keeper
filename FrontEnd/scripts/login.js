'use strict';

angular.module('sharkApp').controller('LoginCtrl', function($scope, $location, cognitoService) {
    $scope.submit = function() {
        var userPool = cognitoService.getUserPool();

        var cognitoUser = cognitoService.getUser(userPool, $('#email').val());
        var authenticationDetails = cognitoService.getAuthenticationDetails($('#email').val(), $('#password').val());

        cognitoUser.authenticateUser(authenticationDetails, {
            onSuccess: function(result) {
                var accessToken = result.getAccessToken().getJwtToken();
                $scope.accessToken = accessToken;

                var currentUser = userPool.getCurrentUser();

                document.location.href = "RecordsPage.html";
                $scope.$apply();
            },
            onFailure: function(err) {
                $scope.errorMessage = "Invalid credentials thicc boi";
                console.log(err);
                $scope.$apply();
            },
        });
    };

    return false;
});