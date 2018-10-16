app.controller('LoginCtrl', function (requestService,$scope, $http,toastr, $window) {

    $scope.args = {};

    $scope.authenticate = function (loginUser) {
        requestService.post("/api/authenticate", loginUser)
            .success(function (data) {
                toastr.success("login correcto")
                /*$rootScope.menu = data;
                $scope.content = "/login";*/
                //$window.localStorage.clear();
            }).error(function (err) {
            //$scope.content = "/login";
            toastr.error(err.message);
        });
    };
});