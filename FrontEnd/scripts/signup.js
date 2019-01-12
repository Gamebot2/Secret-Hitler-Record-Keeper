'use strict';

angular.module('sharkApp').controller('SignupCtrl', function($scope, $location, cognitoService) {

    $scope.submit = function() {
        var userPool = cognitoService.getUserPool();

        var nameParam = {
            Name: 'name',
            Value: $('#name').val()
        };

        var emailParam = {
            Name: 'email',
            Value: $('#email').val()
        };

        var attributes = cognitoService.getUserAttributes(nameParam, emailParam);

        userPool.signUp($('#email').val(), $('#password').val(), attributes, null, function(err, result) {
            if(err) {
                console.log(err);

                $scope.errorMessage = err.message;
                $scope.$apply();
                return;
            } else {
                console.log(result);
                document.location.href = "activate.html";
                $scope.$apply();
            }
        });

        return false;
    }
});