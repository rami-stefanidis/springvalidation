package com.rami.rest;

import com.rami.springvalidator.NameValidator;
import com.rami.vo.Address;
import com.rami.vo.ResponseCodeAndMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

//http://localhost:8080/swagger-ui.html#!/my-controller/postAddressUsingPOST
@RestController
public class MyController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NameValidator nameValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(nameValidator);
    }


    @RequestMapping(value = "/acceptAddress" , method = RequestMethod.POST)
    public ResponseEntity postAddress(@Valid final Address address) {
        LOG.info("postAddress invoked. address = {}",address);

/*        if (bindingResult.hasErrors()) {
            LOG.info("There are errors");
            List<ObjectError> errors = bindingResult.getAllErrors();
            for(ObjectError objectError : errors) {
                LOG.info("Errors code = {}",objectError.getCode());
                LOG.info("Errors name = {}",objectError.getObjectName());
                LOG.info("Errors default message= {}",objectError.getDefaultMessage());
                ResponseCodeAndMessage[] responseCodeAndMessages = (ResponseCodeAndMessage[]) objectError.getArguments();
                LOG.info("Err={}",responseCodeAndMessages[0]);
            }
        } else {
            LOG.info("There are not errors");
        }*/

        return  new ResponseEntity<Address>(address, HttpStatus.OK);
    }

}
