(function() {
	'use strict';

	angular.module('core').factory('leadsService', leadsService);

	leadsService.$inject = [ '$q', '$http', 'logger' ];

	/* @ngInject */
	function leadsService($q, $http, logger) {

		var server = '/o/rest/salesforce'; // Base API/Service path.

		var service = {
			getLeads : getLeads,
			searchLeads: searchLeads,
			getLead: getLead
		};

		return service;

		// Getting data from an API
		function getLeads() {
			return $http({
				method : 'GET',
				url : server + '/leadslist/showall',
				params : {plidParam:plid, portletIdParam: portletId}
			}).success(function(data, status, headers, config) {
				return data.data;
			}).error(function(data, status, headers, config) {
				logger.error('Error getting data.');
			});
		}
		
		function searchLeads(searchParams) {
			searchParams.plidParam = plid;
			searchParams.portletIdParam = portletId;
			return $http({
				method : 'GET',
				url : server + "/leads/search",
				params: searchParams
			}).success(function(data, status, headers, config) {
				return data.data;
			}).error(function(data, status, headers, config) {
				logger.error('Error getting data.');
				return { data: {}};
			});
		}
		
		function getLead(idUrl) {
			return $http({
				method : 'GET',
				url : server + "/leads/details",
				params: { id : idUrl, plidParam:plid, portletIdParam: portletId }
			}).success(function(data, status, headers, config) {
				return data.data;
			}).error(function(data, status, headers, config) {
				logger.error('Error getting data.');
				return { data: {}};
			});
		}
	}
})();
