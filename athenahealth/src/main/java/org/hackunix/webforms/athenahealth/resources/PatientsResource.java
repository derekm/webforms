package org.hackunix.webforms.athenahealth.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hackunix.webforms.athenahealth.objects.Patient;

public interface PatientsResource {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	List<Patient> post(@BeanParam Patient patient);

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	List<Patient> post(@FormParam("departmentid") int departmentid,
	                   @FormParam("firstname") String firstname,
	                   @FormParam("lastname") String lastname,
	                   @FormParam("dob") String dob,
	                   @FormParam("homephone") String homephone,
	                   @FormParam("mobilephone") String mobilephone);

}
