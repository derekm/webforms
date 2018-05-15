package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface Preview1Resource {

	@Path("{practiceId}")
	PracticeResource practice(@PathParam("practiceId") int practiceId);

}
