/**
 * Created by shekhargulati on 10/06/14.
 */

var app = angular.module('energiaap', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute',
    'toastr'
]);



app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});



