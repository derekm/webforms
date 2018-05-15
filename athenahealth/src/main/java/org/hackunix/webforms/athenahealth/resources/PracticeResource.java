package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.Path;

public interface PracticeResource {

	@Path("patients")
	PatientsResource patients();

}
