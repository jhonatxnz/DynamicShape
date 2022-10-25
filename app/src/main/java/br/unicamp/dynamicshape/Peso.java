package br.unicamp.dynamicshape;
import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Peso implements Serializable{
    @SerializedName("nome")
    private String nome;

    public Peso(String nome) {
        this.nome = nome;
    }

    public Peso() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
