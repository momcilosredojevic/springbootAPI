package com.example.converter.apis;

import com.example.converter.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    public Converter converter;

    @GetMapping("/hello")
    public String hello() {
        return "Momo";
    }

    @PostMapping("/convert")
    public String convertFile(@RequestParam("file")MultipartFile file) {
        try {
            return converter.convertXmlFileToJsonString(file);
        } catch (IOException e) {
            return "IOException occurred on server side";
        }
    }

    @PostMapping("/convert/xml")
    public String convertXMLToJsonString(@RequestBody String xml) {
        try {
            return converter.convertXmlStringToJsonString(xml);
        } catch (IOException e) {
            return "IOException occurred on server side";
        }
    }
}
