package br.edu.famper.project.repository;

import br.edu.famper.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
