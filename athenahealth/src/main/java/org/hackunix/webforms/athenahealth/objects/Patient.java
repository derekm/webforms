package org.hackunix.webforms.athenahealth.objects;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.ws.rs.FormParam;

import org.hackunix.adapters.jsonb.LocalDateJsonbAdapter;

// 32378, 3404, 3403 & 3402
public class Patient {

	public String patientid;

	@FormParam("departmentid")
	public int departmentid;

	public String primarydepartmentid;
	public String status;

	@JsonbTypeAdapter(LocalDateJsonbAdapter.class)
	public LocalDate registrationdate;

	public Boolean portalaccessgiven;
	public Boolean driverslicense;
	public Boolean guarantoraddresssameaspatient;
	public Boolean portaltermsonfile;
	public Boolean privacyinformationverified;
	public Boolean patientphoto;

	@FormParam("firstname")
	public String firstname;

	@FormParam("lastname")
	public String lastname;

	@FormParam("dob")
	@JsonbTypeAdapter(LocalDateJsonbAdapter.class)
	public LocalDate dob;

	@FormParam("address1")
	public String address1;
	@FormParam("address2")
	public String address2;
	@FormParam("city")
	public String city;
	@FormParam("state")
	public String state;
	@FormParam("zip")
	public String zip;

	@FormParam("homephone")
	public String homephone;
	public Boolean consenttocall;

	@FormParam("mobilephone")
	public String mobilephone;
	public Boolean hasmobile;
	public Boolean consenttotext;

	@Override
	public String toString() {
		return "patientid:" + patientid;
	}

}
