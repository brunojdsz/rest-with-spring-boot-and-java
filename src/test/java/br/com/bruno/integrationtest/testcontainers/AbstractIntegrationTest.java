package br.com.bruno.integrationtest.testcontainers;

import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
		static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.29");
		
		private static void startContainers() {
			Startables.deepStart(Stream.of(mysql)).join();
		}

		@SuppressWarnings({"unchecked","rawtypes"})
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			startContainers();
			ConfigurableEnvironment environment = applicationContext.getEnvironment(); 
			MapPropertySource testcontainers = new MapPropertySource("testcontainers", (Map) creatConnectionConfiguration()); 
			
			environment.getPropertySources().addFirst(testcontainers);
		}

		private static Map<String, String> creatConnectionConfiguration() {
			
			return Map.of(
				"spring.datasource.url", mysql.getJdbcUrl(),
				"spring.datasource.username", mysql.getUsername(),
				"spring.datasource,password", mysql.getPassword()
					);
		}
	}

}
