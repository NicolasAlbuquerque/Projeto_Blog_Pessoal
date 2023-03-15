package com.generation.blogpessoal.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table(name="tb_postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @NotBlank(message = "O atributo é Obrigatório.")
    @Size(min=5, max = 100, message = "O atributo deve conter no minimo 05" +
            "e no máximo 100 caracteres")
     private String titulo;

    @NotBlank(message = "O atributo texto é Obrigatório.")
    @Size(min = 10, max = 1000, message = "O atributo texto deve conter" +
            "no minimo 10 e no máximo 1000 caracteres.")
     private String texto;

    @UpdateTimestamp
     private LocalDateTime data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}