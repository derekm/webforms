package org.hackunix.webforms.athenahealth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hackunix.webforms.athenahealth.objects.BearerToken;

public interface OAuthTokenResource {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	BearerToken post(@FormParam("grant_type") final String grantType);

}
