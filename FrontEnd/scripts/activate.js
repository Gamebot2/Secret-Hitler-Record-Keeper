'use strict';

angular.module('sharkApp').controller('ActivateCtrl', function ($scope, $location, cognitoService) {
    $scope.submit = function () {
        var userPool = cognitoService.getUserPool();

        var cognitoUser = cognitoService.getUser(userPool, $('#email').val());
        var activationKey = $('#activationCode').val();

        cognitoUser.confirmRegistration(activationKey, true, function (err, result) {
            if (err) {
                console.log(err);

                $scope.errorMessage = err.message;
                $scope.$apply();
                return;
            }

            document.location.href = "login.html";

            $scope.$apply();
        });
    };

    return false;
});