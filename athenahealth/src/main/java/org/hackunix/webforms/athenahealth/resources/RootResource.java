package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.Path;

public interface RootResource {

	@Path("oauthpreview")
	OAuthResource oauthpreview();

	@Path("preview1")
	Preview1Resource preview1();

}
