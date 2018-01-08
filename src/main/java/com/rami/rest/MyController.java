package com.rami.rest;

import com.rami.vo.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/acceptAddress" , method = RequestMethod.POST)
    public ResponseEntity postAddress(final Address address) {
        LOG.info("postAddress invoked. address = {}",address);


        return  new ResponseEntity<Address>(address, HttpStatus.OK);
    }

}
