package selfstudy.spring.security.SpringSecurityApplication;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@RequestMapping (value="/public/accounts/{accountNumber}")
	public String getPublicAccountDataLinkedTo(@PathVariable final int accountNumber) {
		return "Public account: " + accountNumber;
	}
	
	@RequestMapping (value="/user/accounts/{accountNumber}")
	public String getUserAccountDataLinkedTo(@PathVariable final int accountNumber) {
		return "User account: " + accountNumber;
	}
	
	@RequestMapping (value="/admin/accounts/{accountNumber}")
	public String getAdminAccountDataLinkedTo(@PathVariable final int accountNumber) {
		return "Admin account: " + accountNumber;
	}
}
