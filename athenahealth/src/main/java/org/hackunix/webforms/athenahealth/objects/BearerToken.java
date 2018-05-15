package org.hackunix.webforms.athenahealth.objects;

public class BearerToken {

	public String token_type;
	public String mapi;
	public String access_token;
	public int expires_in;
	public String refresh_token;

	@Override
	public String toString() {
		return "Bearer " + access_token;
	}

}
