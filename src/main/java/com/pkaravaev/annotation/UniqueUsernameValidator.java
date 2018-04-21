package com.pkaravaev.annotation;

import com.pkaravaev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (repository == null){
            return true;
        }
        return repository.findByName(username) == null;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }
}
