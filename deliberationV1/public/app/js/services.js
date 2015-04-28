'use strict';

/* Services */

var deliberationServices = angular.module('deliberationServices', ['ngResource']);

deliberationServices.factory('Comments', ['$resource',
    function($resource){
        return $resource('api/comments', {}, {
            query: {method: 'GET'}
        });
    }]);

deliberationServices.factory('Comment', ['$resource',
    function($resource){
        return $resource('api/comment/:id', {}, {
            query: {method: 'GET', params:{id:'@id'}}
        });
    }]);

deliberationServices.factory('CommentsByUser', ['$resource',
    function($resource){
        return $resource('api/comments/:userId', {}, {
            query: {method: 'GET', params:{userId: '@userId'}}
        });
    }]);