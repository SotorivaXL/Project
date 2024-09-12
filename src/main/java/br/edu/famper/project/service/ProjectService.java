package br.edu.famper.project.service;

import br.edu.famper.project.model.Project;
import br.edu.famper.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<List<Project>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findAll());
    }

    public ResponseEntity<Project> findById(Long id) {
        return projectRepository.findById(id)
                .map(projeto -> ResponseEntity.status(HttpStatus.OK).body(projeto)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Project save(Project projeto) {
        return projectRepository.save(projeto);
    }

    public Project update(Project projeto) {
        Project projectSave = projectRepository.findById(projeto.getId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));

        projectSave.setName(projeto.getName());
        projectSave.setDescription(projeto.getDescription());
        projectSave.setDateInit(projeto.getDateInit());
        projectSave.setDateEnd(projeto.getDateEnd());

        return projectRepository.save(projectSave);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

}
