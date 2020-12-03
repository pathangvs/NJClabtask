package com.example.NJCTask;

import com.example.NJCTask.Model.Product;
import com.example.NJCTask.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class NjcTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjcTaskApplication.class, args);
	}

/*	@Component
	class productCommandlineRunner implements CommandLineRunner {

		@Autowired
		private ProductRepository productRepository;

		@Override
		public void run(String... args) throws Exception {

			Product product = new Product();
			product.setProductId(1);
			product.setProductName("Buiscut");
			product.setBrandName("Britania");
			product.setPrice(30);
			productRepository.save(product);
		}
	}*/
}