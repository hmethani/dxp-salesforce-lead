(function() {
    'use strict';

    var core = angular.module('core');

    core.config(toastrConfig);

    /* @ngInject */
    function toastrConfig(toastr) {
       // toastr.options.timeOut = 4000;
       // toastr.options.positionClass = 'toast-bottom-right';
    }

    var config = {
        appErrorPrefix: '[AngularJS Boilerplate] ', //Configure the exceptionHandler decorator
        appTitle: 'AngularJS Boilerplate',
        version: '1.0.0'
    };

    core.value('config', config);

    core.config(configure);

    /* @ngInject */
    function configure($logProvider, $routeProvider, routehelperConfigProvider, exceptionConfigProvider) {
        // turn debugging off/on (no info or warn)
        if ($logProvider.debugEnabled) {
            $logProvider.debugEnabled(true);
        }

        // Configure the common route provider
        routehelperConfigProvider.config.$routeProvider = $routeProvider;
        routehelperConfigProvider.config.docTitle = 'AngularJS Boilerplate: ';

        // Configure the common exception handler
        exceptionConfigProvider.config.appErrorPrefix = config.appErrorPrefix;
    }

})();
