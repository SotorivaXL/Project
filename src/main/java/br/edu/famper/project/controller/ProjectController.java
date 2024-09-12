package br.edu.famper.project.controller;

import br.edu.famper.project.model.Project;
import br.edu.famper.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Project> save(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(project));
    }

    @PutMapping
    public ResponseEntity<Project> update(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.save(project));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Project project) {
        projectService.deleteById(project.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}

