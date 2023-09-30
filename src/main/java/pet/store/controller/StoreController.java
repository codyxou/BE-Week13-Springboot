package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.StoreController;
import pet.store.controller.model.CustomerData;
import pet.store.service.PetService;

@RestController
@RequestMapping("/pet_store")
@Slf4j

	public class StoreController {
		@Autowired
		private PetService petService;
		
		@PostMapping("/customer")
		@ResponseStatus(code = HttpStatus.CREATED)
		public CustomerData insertCustomer(
				@RequestBody CustomerData customerData) {
			log.info("Creating customer {}", customerData);
			return petService.saveCustomer(customerData);
			
		}

	}

