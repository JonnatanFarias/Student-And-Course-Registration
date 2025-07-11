package br.com.jonnatan.StudentAndCourseRegistration.Cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping()
	public List<Curso> listar(){
		return cursoService.listarCursos();
	}
	
	@PostMapping
	public Curso criarCurso(@RequestBody Curso curso){
		return cursoService.salvarCurso(curso);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		cursoService.deletar(id);
		return  ResponseEntity.noContent().build();
	}
}
