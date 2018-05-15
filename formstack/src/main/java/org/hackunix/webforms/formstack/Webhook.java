package org.hackunix.webforms.formstack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hackunix.adapters.jaxb.LocalDateXmlAdapter;
import org.hackunix.webforms.athenahealth.client.AthenaHealthClient;
import org.hackunix.webforms.athenahealth.objects.Patient;

import com.github.t1.log.LogLevel;
import com.github.t1.log.Logged;

@Logged(level = LogLevel.INFO)
@Path("formstack/webhook")
@RequestScoped
public class Webhook {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> json(final JsonObject form) throws Exception {
		Patient patient = new Patient();

		patient.departmentid = 1;
		patient.firstname = form.getJsonObject("Name").getString("first", null);
		patient.lastname = form.getJsonObject("Name").getString("last", null);
		patient.address1 = form.getJsonObject("Address").getString("address", null);
		patient.city = form.getJsonObject("Address").getString("city", null);
		patient.state = form.getJsonObject("Address").getString("state", null);
		patient.zip = form.getJsonObject("Address").getString("zip", null);
		patient.homephone = form.getString("Home Phone", null);
		patient.mobilephone = form.getString("Mobile Phone", null);
		patient.dob = LocalDate.parse(form.getString("DOB", null), DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		AthenaHealthClient client = CDI.current().select(AthenaHealthClient.class).get();
//		return client.practice().patients().post(patient);
		return client.practice().patients().post(
				1,
				patient.firstname,
				patient.lastname,
				new LocalDateXmlAdapter().marshal(patient.dob),
				patient.homephone,
				patient.mobilephone
		);
	}

}
