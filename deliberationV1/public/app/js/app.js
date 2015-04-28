'use strict';

/* App Module */

var deliberationApp = angular.module('deliberationApp', [
    'ngRoute',
    'deliberationControllers',
    'deliberationServices'
]);

deliberationApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/deliberation', {
                templateUrl: '../../public/app/partials/deliberation/deliberation.html',
                controller: 'CommentsListCtrl'
            }).
            when('/deliberation/comment=:_id', {
                templateUrl: '../../public/app/partials/deliberation/comment.html',
                controller: 'CommentCtrl'
            }).
            when('/deliberation/user=:_id', {
                templateUrl: '../../public/app/partials/deliberation/userComments.html',
                controller: 'CommentsListByUserCtrl'
            });
    }
]);
