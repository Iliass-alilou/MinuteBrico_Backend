package com.pi.MinuteBrico.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration")
//@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    

    public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	@PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
