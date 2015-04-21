'use strict';

/* Controllers */

var deliberationControllers = angular.module('deliberationControllers', []);

deliberationControllers.controller('Ctrl', function($scope,$location){
    $scope.getUrl = function() {
        return $location.path();
    };
});

deliberationControllers.controller('CommentsListCtrl', function($scope, $http) {
    $http.get('../../public/app/comments/comments.json').success(function(data){
        $scope.comments = data;
    }).error(function(error){
        console.log('Error loading data' + error);
    });
});
