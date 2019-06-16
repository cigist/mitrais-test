package com.irwan.mitrais.controller;


import com.irwan.mitrais.model.Register;
import com.irwan.mitrais.repository.RegisterRepository;
import com.irwan.mitrais.utilities.RequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by cigist on 15/06/19.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/register")
public class RegisterController {
    @Autowired
    RegisterRepository registerRepository;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Register> index(){
        return registerRepository.findAll();
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public RequestResponse createRegister(@Valid @RequestBody Register register){
        RequestResponse rr = new RequestResponse();
        if (registerRepository.findByPhone(register.getPhoneNumber())) {
            rr.setCode("200");
            rr.setStatus("error");
            rr.setMessage("Phone number already");
            return rr;
        } else {
            try {
                registerRepository.save(register);
                rr.setCode("200");
                rr.setStatus("OK");
                return rr;
            }catch (Exception ex){
                rr.setCode("200");
                rr.setStatus("error");
                rr.setMessage("Error proccess insert");
                return rr;
            }
        }
    }
}
