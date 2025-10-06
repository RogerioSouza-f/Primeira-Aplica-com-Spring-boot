package github.ioRogerioSouza_f.ListaDeTarefas.controller;

import github.ioRogerioSouza_f.ListaDeTarefas.model.Tarefa;
import github.ioRogerioSouza_f.ListaDeTarefas.repository.TarefaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("") // Permite chamadas do front-end
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa existente = repository.findById(id).orElseThrow();
        existente.setDescricao(tarefa.getDescricao());
        existente.setConcluida(tarefa.isConcluida());
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}