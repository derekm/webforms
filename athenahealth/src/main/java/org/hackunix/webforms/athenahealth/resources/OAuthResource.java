package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.Path;

public interface OAuthResource {

	@Path("token")
	OAuthTokenResource token();

}
