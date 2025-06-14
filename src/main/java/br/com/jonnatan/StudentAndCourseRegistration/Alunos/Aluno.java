package br.com.jonnatan.StudentAndCourseRegistration.Alunos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.jonnatan.StudentAndCourseRegistration.Cursos.Curso;
import br.com.jonnatan.StudentAndCourseRegistration.Documento.Documento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(length = 100)
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name  = "documento_id" , referencedColumnName = "id")
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	@JsonBackReference 
	private Curso curso;
}
