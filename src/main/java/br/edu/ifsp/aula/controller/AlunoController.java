package br.edu.ifsp.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsp.aula.model.Aluno;
import br.edu.ifsp.aula.repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("alunos", repository.findAll());
        model.addAttribute("novoAluno", new Aluno());
        return "index";
    }

    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute Aluno aluno) {
        repository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String remover(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = repository.findById(id).get();
        model.addAttribute("aluno", aluno);
        return "editar";
    }


    @PostMapping("/editar")
    public String editar(Aluno aluno) {
        repository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/buscarPorProntuario/{prontuario}")
    public String buscarProntuario(@PathVariable String prontuario, Model model) {
        Aluno aluno = repository.findByProntuario(prontuario);

        model.addAttribute("alunos", List.of(aluno));
        model.addAttribute("novoAluno", new Aluno());
        return "index";
    }

    

}
