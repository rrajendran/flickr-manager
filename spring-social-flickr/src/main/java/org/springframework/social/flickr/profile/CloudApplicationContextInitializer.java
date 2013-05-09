package org.springframework.social.flickr.profile;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 
 * @author ramesh
 */
public class CloudApplicationContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		CloudEnvironment env = new CloudEnvironment();
		if (env.getInstanceInfo() != null) {
			System.out
					.println("************Selected cloud profile***************");
			applicationContext.getEnvironment().setActiveProfiles(
					new String[] { "cloud" });
			applicationContext.refresh();
		} else {
			System.out
					.println("************Selected local profile***************");
			applicationContext.getEnvironment().setActiveProfiles(
					new String[] { "localhost" });
			applicationContext.refresh();

		}
	}
}