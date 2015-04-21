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
                templateUrl: '../../public/app/partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            when('/deliberation/comment=:_id', {
                templateUrl: '../../public/app/partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            when('/deliberation/user=:user', {
                templateUrl: '../../public/app/partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            });
    }
]);
