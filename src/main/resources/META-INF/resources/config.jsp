<%@page import="com.xtivia.salesforce.leads.configuration.LeadsConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.xtivia.salesforce.leads.util.LeadsUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<liferay-ui:success key="preferences-stored-successfully" message="The Salesforce details has been set successfully set."/>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL"
/>

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL"
/>

<%
LeadsConfiguration leadsConfiguration = (LeadsConfiguration)renderRequest.getAttribute(LeadsConfiguration.class.getName());

String serviceUrl = StringPool.BLANK;
String clientId = StringPool.BLANK;
String clientSecret = StringPool.BLANK;
String username = StringPool.BLANK;
String password = StringPool.BLANK;
String securityToken = StringPool.BLANK;
if (Validator.isNotNull(leadsConfiguration)) {
	serviceUrl = portletPreferences.getValue("serviceUrl",leadsConfiguration.serviceUrl());
	clientId = portletPreferences.getValue("clientId", leadsConfiguration.clientId());
	clientSecret = portletPreferences.getValue("clientSecret",leadsConfiguration.clientSecret());
	username = portletPreferences.getValue("username", leadsConfiguration.username());
	password = portletPreferences.getValue("password", leadsConfiguration.password());
	securityToken = portletPreferences.getValue("securityToken",leadsConfiguration.securityToken());
}

%>

<div class="config-instructions">
	<h4>Salesforce Configuration</h4>
	<ul class="instruction-text">
		<li>This portlet uses Salesforce's OAuth based authentication. To set this up, Salesforce requires a <a href="https://help.salesforce.com/apex/HTViewHelpDoc?id=connected_app_overview.htm" target="about:blank">Connected Application</a> to be created. The instructions to do this <a href="https://help.salesforce.com/apex/HTViewHelpDoc?id=connected_app_create.htm" target="about:blank">are here</a>.</li>
		<li>Once the Connected Application is created, you will be able to get Client ID and the Client Secret.</li> 
		<li>The Username, Password and the Security Token are for the user that will be used for all the portal users to fetch lead data.</li>
		<li>In case you have any questions, please reach out to us at: <a href="mailto:info@xtivia.com">info@xtivia.com</a></li>
	</ul>
</div>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm" cssClass="salesforce-configuration">
<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>"
	/>
	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>"
	/>
  <aui:fieldset>
  	<div class="control-group">
  		<label class="control-label" for="service_url">Service URL</label>
  		<span class="instructions">The Service URL needs be the whole URL with both the instance hostname and the version information. Example: https://na34.salesforce.com/services/data/v34.0</span>
  		<input id="service_url" class="field" name="<portlet:namespace/><%= LeadsUtil.SERVICE_URL %>" placeholder="https://na34.salesforce.com/services/data/v34.0" type="text" value="<%= serviceUrl %>">
  	</div>
    <aui:input name="<%= LeadsUtil.CLIENT_ID %>" label="Client ID" type="text" value="<%= clientId %>"/>
    <aui:input name="<%= LeadsUtil.CLIENT_SECRET %>" label="Client Secret" type="text" value="<%= clientSecret %>"/>
    <aui:input name="<%= LeadsUtil.USERNAME %>" label="SalesForce Login Username" type="text" value="<%= username %>"/>
    <aui:input name="<%= LeadsUtil.PASSWORD %>" label="SalesForce Login Password" type="password" value="<%= password %>"/>
  	<div class="control-group">
  		<span></span>
  	</div>
  	<div class="control-group">
  		<label class="control-abel" for="security_token">Security Token</label>
  		<span class="instructions">The Security Token is for the user with the above username & it will be sent to that user's email address.</span>
  		<input id="security_token" class="field" name="<portlet:namespace/><%= LeadsUtil.SECURITY_TOKEN %>" type="text" value="<%= securityToken %>">
  	</div>a
  </aui:fieldset>

  <aui:button-row>
    <aui:button type="submit" value="Save Configuration"/>
  </aui:button-row>

</aui:form>
