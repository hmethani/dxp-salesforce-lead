<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.xtivia.salesforce.leads.configuration.LeadsConfiguration"%>
<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<liferay-theme:defineObjects />		
<portlet:defineObjects />

<% 
	String errorMessage = (String) renderRequest.getAttribute("errorMessage");
LeadsConfiguration leadsConfiguration = (LeadsConfiguration)renderRequest.getAttribute(LeadsConfiguration.class.getName());

String serviceUrl = StringPool.BLANK;
String clientId = StringPool.BLANK;
String clientSecret = StringPool.BLANK;
String username = StringPool.BLANK;
String password = StringPool.BLANK;
String securityToken = StringPool.BLANK;
System.out.println("Checking if not null");
if (Validator.isNotNull(leadsConfiguration)) {
System.out.println("Not null");
	serviceUrl = leadsConfiguration.serviceUrl();
	clientId = leadsConfiguration.clientId();
	System.out.println(leadsConfiguration.clientId());
	clientSecret = leadsConfiguration.clientSecret();
	username = leadsConfiguration.username();
	password = leadsConfiguration.password();
	securityToken = leadsConfiguration.securityToken();
	

}



%>

<div id="salesforceleadid" class="container-fluid" >
<% if (errorMessage != null) { %>
	<div class="error"><%= errorMessage %></div>
<% } else { %>
    <div data-ng-include="'/o/salesforceleadsportlet/app/layout/topnav.html'"></div>
    
	<div class="row-fluid">
		<div data-ui-view class="view-frame span12"></div>	
	</div>

	<script type="text/javascript">
	
		angular.element(document).ready(function() {
			bootstrap('salesforceleadid','salesforceleadid');
		});
		var plid = '<%= themeDisplay.getPlid() %>';
		var portletId = '<%= portletDisplay.getId() %>';
	</script>
<% } %>
</div>
