package com.gestion.crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.crud.modelo.empleado;
import com.gestion.crud.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepositorio repositorio;

	public List<empleado> findAll() {
		return repositorio.findAll();
	}

	public empleado findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public empleado create(empleado empleado) {
		return repositorio.save(empleado);
	}

	public empleado update(long id, empleado form) {

		empleado EmpleadofromDb = findById(id);

		EmpleadofromDb.setNombre(form.getNombre());
		EmpleadofromDb.setApellido(form.getApellido());
		EmpleadofromDb.setEmail(form.getEmail());

		return repositorio.save(EmpleadofromDb);
	}

	public void delete(long id) {

		empleado EmpleadofromDb = findById(id);

		repositorio.delete(EmpleadofromDb);
	}

}
