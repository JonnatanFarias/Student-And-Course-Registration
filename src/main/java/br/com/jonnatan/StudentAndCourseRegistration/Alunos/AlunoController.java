package br.com.jonnatan.StudentAndCourseRegistration.Alunos;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping()
	public List<Aluno> listarTodos(){
		return alunoService.listaTodosAlunos();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> pesquisarPeloCodigo(@PathVariable Integer id){
		Optional<Aluno> alunoEncontrado = alunoService.pesquisarAlunoPeloCodigo(id);
		
		if(alunoEncontrado.isPresent()) {
			return ResponseEntity.ok(alunoEncontrado.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return alunoService.salvarAluno(aluno);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		alunoService.deletar(id);
		return  ResponseEntity.noContent().build();
	}
}
