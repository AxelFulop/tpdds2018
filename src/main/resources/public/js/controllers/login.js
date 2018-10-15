app.controller('LoginCtrl', function (requestService,$scope, $http,toastr, $window) {

    var mail = "";
    var password="";

    $scope.authenticate = function () {
        requestService.post("/api/authenticate", { 'email': mail, 'password': password })
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