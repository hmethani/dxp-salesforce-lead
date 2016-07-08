(function() {
    'use strict';

    angular
        .module('leads')
        .controller('LeadDetailsCtrl', LeadDetailsCtrl);

    LeadDetailsCtrl.$inject = ['leadsService', '$stateParams', '$rootScope'];

    function LeadDetailsCtrl(leadsService, $stateParams, $rootScope) {
        /* jshint validthis: true */
        var vm = this;
        
        $rootScope.$emit("$setPageTitle", { title: "Lead Details" });

        vm.id = $stateParams.id;
        vm.loaded = false;
        
        function init() {
        	vm.lead = {};
            leadsService.getLead(vm.id).success(function(data) {
            	vm.lead = data;
            	vm.loaded = true;
            });
        }

        init();
    }
})();
