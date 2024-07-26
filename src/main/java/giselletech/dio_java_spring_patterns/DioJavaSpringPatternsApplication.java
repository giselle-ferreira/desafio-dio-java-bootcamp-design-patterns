package giselletech.dio_java_spring_patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioJavaSpringPatternsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DioJavaSpringPatternsApplication.class, args);
	}

}
