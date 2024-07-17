package com.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SecurePasswordService {


    public List<String> validatePassword(String pass){
        List<String> failures = new ArrayList<>();

        validateLenght(pass,failures);
        validateUpperCase(pass,failures);
        validateLowerCase(pass,failures);
        validateNumber(pass,failures);
        validateSpecialCharacter(pass,failures);

        return failures;
    }

    private void validateLenght(String pass, List<String> failures) {
        if(pass != null && pass.length() < 8){
            failures.add("- A senha deve possuir pelo menos 8 caracteres.");
        }
    }

    private void validateUpperCase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add("- A senha deve possuiar pelo menos uma letra maíscula.");
        }
    }

    private void validateLowerCase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[a-z].*", pass)) {
            failures.add("- A senha deve possuiar pelo menos uma letra minúscula.");
        }
    }
    private void validateNumber(String pass, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("- A senha deve possuiar pelo menos um dígito numérico.");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", pass)) {
            failures.add("- A senha deve possuiar pelo menos um caracter especial(exemplo:!@#$%).");
        }

    }



}
