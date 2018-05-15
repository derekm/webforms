package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

public interface AthenaHealthResource {

	@Path("/")
	RootResource withBearerToken(@HeaderParam("Authorization") String bearer);

}
