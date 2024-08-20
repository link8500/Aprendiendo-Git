package com.gestion.crud.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.crud.modelo.empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<empleado,Long>{

	
}
