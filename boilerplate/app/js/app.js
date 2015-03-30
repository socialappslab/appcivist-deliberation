'use strict';

/* App Module */

var deliberationApp = angular.module('deliberationApp', [
    'ngRoute',
    'deliberationControllers'
]);

deliberationApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/deliberation', {
                templateUrl: 'partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            when('/deliberation/comment=:_id', {
                templateUrl: 'partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            when('/deliberation/user=:user', {
                templateUrl: 'partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            otherwise({
                redirectTo: '/deliberation'
            });
    }
]);
