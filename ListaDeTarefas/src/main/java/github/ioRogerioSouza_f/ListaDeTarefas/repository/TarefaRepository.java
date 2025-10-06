package github.ioRogerioSouza_f.ListaDeTarefas.repository;

import github.ioRogerioSouza_f.ListaDeTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
