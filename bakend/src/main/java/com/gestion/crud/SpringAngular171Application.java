package com.gestion.crud;
/*
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import com.gestion.crud.modelo.empleado;
import com.gestion.crud.repositorio.EmpleadoRepositorio;
import org.springframework.boot.CommandLineRunner;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringAngular171Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngular171Application.class, args);
	}
/*
	@Bean
	CommandLineRunner runner(EmpleadoRepositorio empleadoRepositorio) {
		
		return args ->{
			
			
				List<empleado> Empleado = Arrays.asList(
						new empleado(null, "Carlos","vegas","stevemedrano@gmail.com"),
						new empleado(null, "Aaron","Torres","Aaronisais@gmail.com"),
						new empleado(null, "Jaime","Perez","Pudencioalmes@gmail.com"),
						new empleado(null, "ortiz","pablo","oroscovultres@gmail.com"),
						new empleado(null, "hurbina","salmeron","yamitometo@gmail.com")
						);
				
				empleadoRepositorio.saveAll(Empleado);
			
		};
	}*/
	
}
