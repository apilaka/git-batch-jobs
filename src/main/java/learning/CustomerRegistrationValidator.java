package learning;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import ch.qos.logback.core.rolling.helper.PeriodicityType;
import function.Customer;

public interface CustomerRegistrationValidator extends Function<Customer, learning.CustomerRegistrationValidator.CustomerValidationResult>{
	
	enum CustomerValidationResult{
		SUCCESS,
		PHONE_NOT_VALID,
		EMAIL_NOT_VALID,
		IS_NOT_ADULT
		
	}
	static CustomerRegistrationValidator isEmailValid( ) {
		return customer -> customer.getEmail().contains("@")?CustomerValidationResult.SUCCESS:   CustomerValidationResult.EMAIL_NOT_VALID;
		
	}
	
	static CustomerRegistrationValidator isPhoneValid( ) {
		return customer -> customer.getPhone().contains("0")?CustomerValidationResult.SUCCESS : CustomerValidationResult.PHONE_NOT_VALID;
	}
	
	static CustomerRegistrationValidator isAdult() {
	
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears()>16?CustomerValidationResult.SUCCESS
				: CustomerValidationResult.IS_NOT_ADULT;
				
	}
	default CustomerRegistrationValidator and (CustomerRegistrationValidator other)
	{
		
	return customer->
	{
		CustomerValidationResult result =this.apply(customer);
		return result.equals(CustomerValidationResult.SUCCESS)? other.apply(customer): result;
		
	};
	}

}
