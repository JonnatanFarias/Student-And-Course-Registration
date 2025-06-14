package br.com.jonnatan.StudentAndCourseRegistration.Alunos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public List<Aluno>listaTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> pesquisarAlunoPeloCodigo(Integer id){
		return alunoRepository.findById(id);
	}
	
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void deletar(Integer id) {
		alunoRepository.deleteById(id);
	}
	
}	
