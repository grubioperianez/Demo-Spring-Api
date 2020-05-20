package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.AccesoExternoServiceImpl;

@RestController
public class MyController {

	private static final String template = "Hola %s %s";
	private final AtomicLong counter = new AtomicLong();	

	@GetMapping("/saluda")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = " a todos	") String name,
			@RequestParam(value = "apellido") String apellido) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name, apellido));
	}
	
	@GetMapping("/llamaUrlExterna")
	public String llamaUrl() {
		AccesoExternoServiceImpl objServicio = new AccesoExternoServiceImpl();
		String respuesta = "Fallo en la llamada";
		try {
			respuesta = objServicio.getAccesoUrl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}
	
}