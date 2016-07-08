(function() {
    'use strict';

    angular.module('layout').controller('TopNavCtrl', TopNavCtrl);

    TopNavCtrl.$inject = ['$state', '$rootScope'];

    function TopNavCtrl($state, $rootScope) {
        /* jshint validthis:true */
        var vm = this;
        vm.pageTitle = "";
        
        $rootScope.$on("$setPageTitle", function(event, args) {
        	vm.pageTitle = args.title;
        });
    }
})();
