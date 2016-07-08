(function() {
    'use strict';

    angular
        .module('leads')
        .controller('LeadsCtrl', LeadsCtrl);

    LeadsCtrl.$inject = ['leadsService', 'DTOptionsBuilder', '$state', '$rootScope'];

    function LeadsCtrl(leadsService, DTOptionsBuilder, $state, $rootScope) {
        /* jshint validthis: true */
        var vm = this;
        
        $rootScope.$emit("$setPageTitle", { title: "SalesForce Leads Management" });
        
        vm.searchLeads = searchLeads;
        vm.resetSearch = resetSearch;
        vm.goToDetails = goToDetails;
        
        function init() {
            vm.loaded = false;
        	vm.search = { name: '', company: '', email: '' };
        	vm.tableOptions = DTOptionsBuilder.newOptions().withOption('bFilter', false).withDOM('trpl');
            leadsService.getLeads().success(populateLeads);
        }

        init();

        function populateLeads(data) {
        	vm.leads = data;
            vm.loaded = true;
        }
        
        function searchLeads() {
            vm.loaded = false;
        	leadsService.searchLeads(vm.search).success(populateLeads);
        }
        
        function resetSearch() {
        	init();
        }
        
        function goToDetails(lead) {
        	$state.go("lead-details", {id: lead.id});
        }
    }
})();
