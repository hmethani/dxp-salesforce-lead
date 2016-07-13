(function() {
    'use strict';

    angular
        .module('blocks.logger')
        .factory('logger', logger);

    logger.$inject = ['$log', 'toastr'];

    function logger($log, toastr) {
        var service = {
            showToasts: true,

            error: error,
            info: info,
            success: success,
            warning: warning,

            // straight to console; bypass toastr
            log: $log.log
        };

        return service;
        /////////////////////

        function error(message, data, title) {
        	$().toastmessage('showErrorToast', message);
            $log.error('Error: ' + message, data);
        }

        function info(message, data, title) {
        	$().toastmessage('showNoticeToast', message);
            $log.info('Info: ' + message, data);
        }

        function success(message, data, title) {
        	$().toastmessage('showSuccessToast', message);
            $log.info('Success: ' + message, data);
        }

        function warning(message, data, title) {
        	$().toastmessage('showWarningToast', message);
        	alert('warn '+message);
            $log.warn('Warning: ' + message, data);
        }
    }
}());
