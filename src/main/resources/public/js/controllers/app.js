/**
 * Created by shekhargulati on 10/06/14.
 */

var app = angular.module('energiapp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute',
    'toastr'
]);



app.config(function ($routeProvider,toastrConfig) {
    $routeProvider.when('/', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
    }).otherwise({
        redirectTo: '/'
    })
    angular.extend(toastrConfig, {
        autoDismiss: false,
        containerId: 'toast-container',
        maxOpened: 0,
        newestOnTop: true,
        positionClass: 'toast-bottom-right',
        preventDuplicates: false,
        preventOpenDuplicates: false,
        target: 'body'
    });

});



