package com.example.converter.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class Converter {
    public String convertXmlFileToJsonString(MultipartFile file) throws IOException {
        String xmlString =  new String(file.getBytes());

        JSONObject json = XML.toJSONObject(xmlString);

        return json.toString();
    }

    public String convertXmlStringToJsonString(String xml) throws IOException {
        JSONObject json = XML.toJSONObject(xml);

        return json.toString();
    }
}
