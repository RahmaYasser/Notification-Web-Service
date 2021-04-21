package com.example.notificationwebservice.controller;


import com.example.notificationwebservice.data_access_layer.TemplateRepository;
import com.example.notificationwebservice.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class TemplateController {

    @Autowired
    private TemplateRepository templateRepo; // should be annotated by @Component

    @PostMapping
    public Template createTemplate(@RequestBody Template template){
        templateRepo.create(template);
        return template;
    }

    @GetMapping
    public List<Template> readTemplates(){
        return templateRepo.readAll();
    }

    @GetMapping(value = {"/{templateType}"})
    public Template read(@PathVariable String templateType){
        return templateRepo.read(templateType);
    }

    @PutMapping(value = "/{templateType}")
    public Template updateCustomer(@PathVariable String templateType,@RequestBody Template template){
        return templateRepo.update(templateType,template);
    }

    @DeleteMapping(value = "/{templateType}")
    public Template deleteCustomer(@PathVariable String templateType){
        return templateRepo.delete(templateType);
    }

}
