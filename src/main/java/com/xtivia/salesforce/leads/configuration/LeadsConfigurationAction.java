package com.xtivia.salesforce.leads.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.xtivia.salesforce.leads.util.LeadsUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(
		configurationPid="com.xtivia.salesforce.leads.configuration.LeadsConfiguration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
		property = {
			"javax.portlet.name=com_xtivia_salesforce_leads_portlet_SalesForceLeadsPortlet"
		},
		service = ConfigurationAction.class
)
public class LeadsConfigurationAction extends DefaultConfigurationAction{

	private static final Log _log = LogFactoryUtil.getLog(LeadsConfigurationAction.class);

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Blade Message Portlet configuration include");
		}
		httpServletRequest.setAttribute(
			LeadsConfiguration.class.getName(),
			_leadsConfiguration);
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_leadsConfiguration = ConfigurableUtil.createConfigurable(
			LeadsConfiguration.class, properties);
	}


	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Blade Message Portlet configuration action");
		}

		String clientId = ParamUtil.getString(actionRequest, LeadsUtil.CLIENT_ID);
		String clientSecret = ParamUtil.getString(actionRequest, LeadsUtil.CLIENT_SECRET);
		String serviceUrl = ParamUtil.getString(actionRequest, LeadsUtil.SERVICE_URL);
		String password = ParamUtil.getString(actionRequest, LeadsUtil.PASSWORD);
		String securityToken = ParamUtil.getString(actionRequest, LeadsUtil.SECURITY_TOKEN);
		String username = ParamUtil.getString(actionRequest, LeadsUtil.USERNAME);


		setPreference(actionRequest, "clientId", clientId);
		setPreference(actionRequest, "clientSecret", clientSecret);
		setPreference(actionRequest, "serviceUrl", serviceUrl);
		setPreference(actionRequest, "password", password);
		setPreference(actionRequest, "securityToken", securityToken);
		setPreference(actionRequest, "username", username);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	private volatile LeadsConfiguration _leadsConfiguration;
}
