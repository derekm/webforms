package org.hackunix.webforms.athenahealth.client;

//import java.util.logging.Level;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
//import org.glassfish.jersey.logging.LoggingFeature;
import org.hackunix.webforms.athenahealth.objects.BearerToken;
import org.hackunix.webforms.athenahealth.resources.AthenaHealthResource;
import org.hackunix.webforms.athenahealth.resources.PracticeResource;
import org.hackunix.webforms.athenahealth.resources.RootResource;

@Dependent
public class AthenaHealthClient {

	private final RootResource root;
	private final PracticeResource practice;

	@Inject
	public AthenaHealthClient(
			@ConfigProperty(name = "athenahealth.url") String url,
			@ConfigProperty(name = "athenahealth.key") String key,
			@ConfigProperty(name = "athenahealth.secret") String secret,
			@ConfigProperty(name = "athenahealth.practiceid") int practiceId
	) {
		WebTarget authTarget = ClientBuilder.newClient()
				.register(HttpAuthenticationFeature.basic(key, secret))
				.target(url);

		RootResource authRoot = WebResourceFactory.newResource(RootResource.class, authTarget);
		BearerToken bearerToken = authRoot.oauthpreview().token().post("client_credentials");

		WebTarget clientTarget = ClientBuilder.newClient()
//				.property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, Level.INFO.getName())
//				.register(new LoggingFeature())
				.target(url);

		AthenaHealthResource athena = WebResourceFactory.newResource(AthenaHealthResource.class, clientTarget);
		root = athena.withBearerToken(bearerToken.toString());
		practice = root.preview1().practice(practiceId);
	}

	public RootResource root() {
		return root;
	}

	public PracticeResource practice() {
		return practice;
	}

}
