package com.ayushi.crudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.ayushi.crudoperation.Entity")
@ComponentScan("com.ayushi.crudoperation")
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
	}

}
