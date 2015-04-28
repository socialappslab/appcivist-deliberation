'use strict';

/* Controllers */

var deliberationControllers = angular.module('deliberationControllers', []);

deliberationControllers.controller('Ctrl', function($scope,$location){
    $scope.getUrl = function() {
        return $location.path();
    };
});

deliberationControllers.controller('CommentsListCtrl', function($scope, Comments) {
    $scope.comments = Comments.query();
});

deliberationControllers.controller('CommentCtrl', ['$scope', '$routeParams', 'Comment', function($scope, $routeParams, Comment){
    $scope.comment = Comment.query({id:$routeParams._id});
}]);

deliberationControllers.controller('CommentsListByUserCtrl', ['$scope','$routeParams', 'CommentsByUser', function($scope, $routeParams, CommentsByUser) {
    $scope.comments = CommentsByUser.query({userId:$routeParams._id});
}]);
