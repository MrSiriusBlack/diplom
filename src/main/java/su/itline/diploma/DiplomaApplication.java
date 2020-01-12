package su.itline.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "su.itline.diploma")
@EnableSwagger2
@EntityScan(basePackages = {"su.itline.diploma"})
public class DiplomaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public PasswordEncoder delegatingPasswordEncoder() {
		PasswordEncoder defaultEncoder = NoOpPasswordEncoder.getInstance();
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		encoders.put("noop", NoOpPasswordEncoder.getInstance());

		DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
				"bcrypt", encoders);
		passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

		return passworEncoder;
	}
}
