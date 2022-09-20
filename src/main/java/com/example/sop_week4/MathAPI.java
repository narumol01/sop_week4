package com.example.sop_week4;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/add/{n1}/{n2}", method = RequestMethod.GET)
    public String add(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1+n2);
    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public String minus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return Double.toString(n1-n2);
    }

    @RequestMapping(value = "/multiply/{n1}/{n2}",  method = RequestMethod.GET)
    public String multiply(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return  Double.toString(n1*n2);
    }

    @RequestMapping(value = "/divide/{n1}/{n2}",  method = RequestMethod.GET)
    public String divide(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return  Double.toString(n1/n2);
    }

    @RequestMapping(value = "/mod/{n1}/{n2}",  method = RequestMethod.GET)
    public String mod(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return  Double.toString(n1%n2);
    }

    @RequestMapping(value = "/max",  method = RequestMethod.POST)
    public String max(@RequestBody MultiValueMap<String, String> n){
        Map<String,String> d = n.toSingleValueMap();
        double out = Double.parseDouble(d.get("n1"));
        double out2 = Double.parseDouble(d.get("n2"));
        if(out>out2){
            return Double.toString(out);
        }
        return  Double.toString(out2);
    }

}
