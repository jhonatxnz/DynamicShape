package br.unicamp.dynamicshape;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;


public class Usuario implements Serializable{
    @SerializedName("id")
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("idade")
    private Integer idade;
    @SerializedName("telefone")
    private String telefone;
    @SerializedName("email")
    private String email;
    @SerializedName("peso")
    private Float peso;
    @SerializedName("altura")
    private Float altura;
    @SerializedName("senha")
    private String senha;
    @SerializedName("imagem")
    private String imagem;
    @SerializedName("genero")
    private Integer genero;
    @SerializedName("objetivo")
    private Integer objetivo;
    @SerializedName("tempo")
    private Float tempo;


    public Usuario(String id, String nome, Integer idade, String telefone, String email, Float peso,Float altura, String senha, String imagem, Integer genero, Integer objetivo,Float tempo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.peso = peso;
        this.senha = senha;
        this.imagem = imagem;
        this.genero = genero;
        this.objetivo = objetivo;
        this.altura = altura;
        this.tempo = tempo;
    }

    public Usuario() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getGenero() {return genero;}

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public Integer getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Integer objetivo) {
        this.objetivo = objetivo;
    }

    public Float getTempo() {return tempo;}

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }
}
