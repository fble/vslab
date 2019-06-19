package de.hska.iwi.vslab.contentmanagementservice;



import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value= "/test")
public class TestController {
	
	private RestTemplate restTemplate;
	
	@GetMapping
	public Response getTestString() {
		restTemplate = new RestTemplate();
		String s =restTemplate.getForObject("http://category-service/test", String.class);
		
		return Response.ok(s).build();
	}

}
