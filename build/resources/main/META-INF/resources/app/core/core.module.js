(function() {
    'use strict';

    angular.module('core', [
        /*
         * Angular modules
         */
        'ngAnimate',
        'ngRoute',
        'ngSanitize',
        /*
         * Our reusable cross app code modules
         */
        'blocks.exception',
        'blocks.logger',
        'blocks.router',
        /*
         * 3rd Party modules
         */
        'ui.router',
        'ui.bootstrap',
        'datatables'
    ]);

})();
