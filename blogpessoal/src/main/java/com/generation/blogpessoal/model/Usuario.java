package com.generation.blogpessoal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O Atributo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "O Atributo usuário é obrigatório.")
    @Email(message = "O atributo Email deve ser um Email válido")
    private String usuario;
    @NotBlank(message = "O Atributo senha é obrigatório.")
    @Size(min = 8,message = "A senha deve ter no minimo 8 caracteres.")
    private String senha;
    @Size(max = 5000 ,message = "O link da foto não pode ser maior do que" +
            "5000 caracteres.")
    private String foto;

    public Usuario(Long id, String nome, String usuario, String senha, String foto) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.foto = foto;
    }

    public Usuario() {

    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}
