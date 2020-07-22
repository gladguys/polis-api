package com.gladguys.polisapi;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class PolisApiApplication {

	static String ENV = "dev";

	public static void main(String[] args) {
		if (args.length == 0 || !args[0].equals("dev")) ENV = "prod";
		else ENV = "dev";

		SpringApplication.run(PolisApiApplication.class, args);
	}

	@Bean
	public Firestore getFirestore() throws IOException {

		InputStream serviceAccount;
		if (ENV.equals("dev")) {
			serviceAccount = new ClassPathResource("fb_dev.json").getInputStream();
		} else {
			serviceAccount = new ClassPathResource("fb_prod.json").getInputStream();
		}

		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);

		return FirestoreClient.getFirestore();
	}
}
