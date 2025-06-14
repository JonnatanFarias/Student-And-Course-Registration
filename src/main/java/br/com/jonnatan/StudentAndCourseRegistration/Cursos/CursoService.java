package br.com.jonnatan.StudentAndCourseRegistration.Cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void deletar(Integer id) {
		cursoRepository.deleteById(id);
	}
	
}
