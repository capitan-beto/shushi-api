package com.capitanbeto.sushi;

import com.capitanbeto.sushi.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SushiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SushiApplication.class, args);
	}

	@GetMapping(path = "/")
	public List<Product> getNames() {
		return List.of(
		 new Product(
				 1,
				"Poshi",
				500,
				"Roll",
				"Roll de pollo",
				"imagen.com"
		 )
		);
	}

}
