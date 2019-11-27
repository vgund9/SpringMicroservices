package com.vgpr.soc.userservice;

import javax.annotation.security.RolesAllowed;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
public class UserController {

	@GetMapping("/getUser")
	public String getUser() {
		return "Vijay";
	}

	@GetMapping("/{name}/{age}")
	public String getMessage(@PathVariable("name") String name, @PathVariable("age") String age) {
		String msg = String.format("%s is %s years old", name, age);
		return msg;
	}
	

	  @GetMapping("/public")
	  public String welcomePublic() {
	    return "welcome public/guest user";
	  }

	  @RolesAllowed({"ROLE_ADMIN"})
	  @GetMapping("/admin")
	  public String welcomeAdmin() {
	    return "welcome admin";
	  }

	  @RolesAllowed({"ROLE_USER"})
	  @GetMapping("/user")
	  public String welcomeUser() {
	    return "welcome user";
	  }


}
