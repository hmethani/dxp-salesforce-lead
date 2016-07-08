package com.xtivia.salesforce.leads.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
		id = "com.xtivia.salesforce.leads.configuration.LeadsConfiguration"
	)
public interface LeadsConfiguration {

	@Meta.AD(required=false)
	public String serviceUrl();
	@Meta.AD(required=false)
	public String clientId();
	@Meta.AD(required=false)
	public String clientSecret();
	@Meta.AD(required=false)
	public String username();
	@Meta.AD(required=false)
	public String password();
	@Meta.AD(required=false)
	public String securityToken();
}
