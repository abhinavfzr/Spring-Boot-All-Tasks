package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.exception.RestaurentAlreadyException;
import com.stackroute.userservice.exception.RestaurentNotFoundException;
import com.stackroute.userservice.service.RestaurentService;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class RestaurentController
{
    private RestaurentService restaurentService;

    @Autowired
    public RestaurentController(RestaurentService restaurentService) {

        this.restaurentService = restaurentService;
    }


    @PostMapping("/food")
    public ResponseEntity<?> saveRest(@RequestBody  Restaurent restaurent)
    {
        ResponseEntity responseEntity;
        try {
            restaurentService.saveRest(restaurent);
            responseEntity= new ResponseEntity<String>("succefullly created", HttpStatus.OK);
        }   catch (RestaurentAlreadyException ex){
            responseEntity= new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }

        return responseEntity;
    }

    @GetMapping("foods")
    public  List<Restaurent> getALlUsers()
    {
        List<Restaurent> list=restaurentService.getALLRest();
        return list;
    }

    @GetMapping("food/{name}")
    public  ResponseEntity<?>SEARCH(@PathVariable String name)
    {
        try {
            List<Restaurent> saved=restaurentService.findRest(name);
             return new ResponseEntity<List<Restaurent>>(saved, HttpStatus.OK);

        }
        catch (RestaurentNotFoundException ex)
        {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

    }

}
