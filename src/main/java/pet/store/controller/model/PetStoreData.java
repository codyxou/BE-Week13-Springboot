package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	


	public PetStoreData(PetStore petStore) {
		petStoreId = petStore.getPetStoreId();
		petStoreName = petStore.getPetStoreName();
		petStoreAddress = petStore.getPetStoreAddress();
		petStoreState = petStore.getPetStoreState();
		petStoreZip = petStore.getPetStoreZip();
		petStorePhone = petStore.getPetStorePhone();
		
        for (Customer customer : petStore.getCustomers()) {
            PetStoreCustomer petStoreCustomer = new PetStoreCustomer();
            petStoreCustomer.setCustomerId(customer.getCustomerId());
            petStoreCustomer.setCustomerFirstName(customer.getCustomerFirstName());
            petStoreCustomer.setCustomerLastName(customer.getCustomerLastName());
            petStoreCustomer.setCustomerEmail(customer.getCustomerEmail());
            customers.add(petStoreCustomer);
        }

        for (Employee employee : petStore.getEmployees()) {
            PetStoreEmployee petStoreEmployee = new PetStoreEmployee();
            petStoreEmployee.setEmployeeId(employee.getEmployeeId());
            petStoreEmployee.setEmployee_first_name(employee.getEmployee_first_name());
            petStoreEmployee.setEmployee_last_name(employee.getEmployee_last_name());
            petStoreEmployee.setEmployeePhone(employee.getEmployeePhone());
            petStoreEmployee.setEmployeeJobTitle(employee.getEmployeeJobTitle());
            employees.add(petStoreEmployee);
        }
	}


	@Data
	@NoArgsConstructor
	public static class PetStoreCustomer {
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

		public PetStoreCustomer(Customer customer) {

			customerId = customer.getCustomerId();
			customerFirstName = customer.getCustomerFirstName();
			customerLastName = customer.getCustomerLastName();
			customerEmail = customer.getCustomerEmail();


		}
	}

		@Data
		@NoArgsConstructor
		public static class PetStoreEmployee {
			
			private Long employeeId;
			private String employee_first_name;
			private String employee_last_name;
			private String employeePhone;
			private String employeeJobTitle;
			
			public PetStoreEmployee(Employee employee) {
				
			}
			
		}
	

}