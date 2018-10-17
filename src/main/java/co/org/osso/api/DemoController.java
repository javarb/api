//package co.org.osso.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// this classes small and delegate to services
/*
@RestController
@RequestMapping ("/api")
public class DemoController {

    // tdd in the service
    
    // I don't need to instanciate Srping does it
    // this say t spring I need a demoservice
    @Autowired
    private DemoService service;

    @GetMapping("/{id}")
    public MyPojo getData(@PathVariable("id") String id)){
        return service.MyPojo();
    }
    */
    /*
    public Map<String, Object> getData(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> innerMap = new HashMap<>();
        map.put("ok", 123);
        innerMap.put("name", "asd asdf");
        map.put("asd", innerMap);
        return new HashMap<>();
        //return new HashMap<>();
    }
    */
/*
    // see http codes
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postData(@RequestBody myPojo){
        // this method is in the service
        if (!service.isValid(MyPojo)){
            return "NOt Ok";
        }
        return "OK";
    }

    // OWASP vulneabilidades en codigo
}


class MyPojo{

}*/