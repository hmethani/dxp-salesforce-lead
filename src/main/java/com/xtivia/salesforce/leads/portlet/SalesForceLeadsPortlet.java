package com.xtivia.salesforce.leads.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Salesforce leads portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/config.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-css=/assets/css/app.css",
		"com.liferay.portlet.header-portlet-css=/assets/css/toastr/jquery.toastmessage.css",
		"com.liferay.portlet.header-portlet-javascript=/lib/jquery/jquery.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/datatables/jquery.dataTables.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/datatables/angular-datatables.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/app.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-route.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-touch.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-resource.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-animate.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-messages.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-aria.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-cookies.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/angular-1.3.2/angular-sanitize.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/moment/moment.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/toastr/jquery.toastmessage.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/third-party-angular-modules/angular-ui-router.min.js",
		"com.liferay.portlet.header-portlet-javascript=/lib/third-party-angular-modules/ui.bootstrap-tpls-0.8.0.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/exception/exception.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/exception/exception-handler.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/exception/exception.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/logger/logger.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/logger/logger.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/router/router.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/blocks/router/routehelper.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/core/core.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/core/constants.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/core/config.js",

		"com.liferay.portlet.footer-portlet-javascript=/app/core/services/leads.service.js",

		"com.liferay.portlet.footer-portlet-javascript=/app/core/directives/directives.module.js",

		"com.liferay.portlet.footer-portlet-javascript=/app/layout/layout.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/layout/topnav.controller.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/featuresets/leads/leads.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/featuresets/leads/leads.controller.js",

		"com.liferay.portlet.footer-portlet-javascript=/app/featuresets/lead-details/lead-details.module.js",
		"com.liferay.portlet.footer-portlet-javascript=/app/featuresets/lead-details/lead-details.controller.js"
	},
	service = Portlet.class
)
public class SalesForceLeadsPortlet extends MVCPortlet {
	

	

	
}