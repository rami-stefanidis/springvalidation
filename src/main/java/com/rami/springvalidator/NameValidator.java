package com.rami.springvalidator;

import com.rami.exception.MyException;
import com.rami.vo.Address;
import com.rami.vo.ResponseCodeAndMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// https://stackoverflow.com/questions/39001106/implementing-custom-validation-logic-for-a-spring-boot-endpoint-using-a-combinat

@Component
public class NameValidator implements Validator {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supports(Class<?> aClass) {
        LOG.info("In Supports.");
        return Address.class.equals(aClass);
    }

    //Validator service can be called from here.
    //No need in main code to check if there are errors. IF error throw exception and advise will handle it.
    @Override
    public void validate(Object o, Errors errors) {
        LOG.info("In Validate.");
        final Address address = (Address) o;
        final String name = address.getName();

        if(name.length() < 6) {
            LOG.info("Rejecting");
            ResponseCodeAndMessage responsCodeAndMessage = new ResponseCodeAndMessage();
            responsCodeAndMessage.setCode("123");
            responsCodeAndMessage.setDescription("Test");

            errors.reject(name,new ResponseCodeAndMessage[]{responsCodeAndMessage},"Error in name");
        }

        if(errors.hasErrors()) {
            LOG.info("Has errors");
            throw new MyException();
        }

    }
}
