package at.free23.order.process;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class OrderProcessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessServiceApplication.class, args);
	}
}
