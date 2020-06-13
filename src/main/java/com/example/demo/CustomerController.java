package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//You might want to annotate CustomerController class
public class CustomerController {

    //You might want to annotate customerRepo attribute
	CustomerRepo customerRepo;

}