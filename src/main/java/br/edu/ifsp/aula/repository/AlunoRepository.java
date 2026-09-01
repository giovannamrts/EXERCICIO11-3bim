package br.edu.ifsp.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.aula.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
    Aluno findByProntuario(String prontuario);
}




