function bootstrap(nameSpace) {
    'use strict';

    /* App Module */

    var app = angular.module(nameSpace, [
        'core',
        'directives',
        /*
         * Feature Areas
         */
        'layout',
        'leads',
        'lead-details'
    ]);

    /* App Routes */

    function routeConfig($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('leads', {
                url: '/leads',
                templateUrl: '/o/salesforceleadsportlet/app/featuresets/leads/leads.html',
                controller: 'LeadsCtrl',
                controllerAs: 'vm',
                title: 'SalesForce Leads'
            }).state('lead-details', {
                url: '/lead-details/:id',
                templateUrl: '/o/salesforceleadsportlet/app/featuresets/lead-details/details.html',
                controller: 'LeadDetailsCtrl',
                controllerAs: 'vm',
                title: 'SalesForce Lead Details'
            });
        
        $urlRouterProvider.otherwise("/leads");
    }
    app.config(routeConfig);

    routeConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    

    angular.bootstrap(document.getElementById(nameSpace), [nameSpace]);
}
