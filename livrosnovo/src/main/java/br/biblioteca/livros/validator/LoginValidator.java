package br.biblioteca.livros.validator;

import br.biblioteca.livros.entities.Login;
import br.biblioteca.livros.service.SecurityService;
import br.biblioteca.livros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
	
	@Autowired
	private UserService userService;

    @Autowired
    private SecurityService securityService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Login.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Login user = (Login) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		
		if (userService.findByUsername(user.getUsername()) == null) {
			errors.rejectValue("username", "NotExist.userForm.username");
		}

        try {
            securityService.login(user.getUsername(), user.getPassword());
        }catch (BadCredentialsException e){
            errors.rejectValue("password", "BadCredentials.userForm.username");
        }
		
	}
}