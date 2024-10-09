package com.employee.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

	 @Bean
	    public OpenAPI defineOpenApi() {
	        Server server = new Server();
	        server.setUrl("http://localhost:8080");
	        server.setDescription("Development");
	        Contact myContact = new Contact();
	        myContact.setName("Er.SAMEER");
	        myContact.setEmail("sameer.tech@gmail.com");
	        myContact.setUrl("www.google.com");
	        Info information = new Info()
	                .title("Employee Management")
	                .version("1.0")
	                .summary("Room Api for legends only")
	                .description("This Application is Learning purpose where we are learning with cheers!!!")
	                .contact(myContact);
	        return new OpenAPI().info(information).servers(List.of(server));
	    }

}
