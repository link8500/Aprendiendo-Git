package com.gestion.crud.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.gestion.crud.modelo.empleado;

import com.gestion.crud.service.EmpleadoService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class EmpleadoControlador {
	@Autowired
	private EmpleadoService repositorio;

	@GetMapping("/empleados")
	public List<empleado> Listartodoslosempleados() {
		return repositorio.findAll();
	}

	@GetMapping("{id}")
	public empleado get(@PathVariable long id) {
		return repositorio.findById(id);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping
	public empleado create(@RequestBody empleado empleado) {
		return repositorio.create(empleado);
	}

	@PutMapping("{id}")
	public empleado update(@PathVariable long id, @RequestBody empleado form) {
		return repositorio.update(id, form);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repositorio.delete(id);
	}

}
