package br.edu.famper.project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_init", nullable = false)
    private Date dateInit;

    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

}
