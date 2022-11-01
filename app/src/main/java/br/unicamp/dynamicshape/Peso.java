package br.unicamp.dynamicshape;
import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Peso implements Serializable{
    @SerializedName("nome")
    private String nome;
    @SerializedName("quantVezes")
    private Integer quantVezes;
    @SerializedName("sessoes")
    private Integer sessoes;

    public Peso(String nome,Integer quantVezes,Integer sessoes) {
        this.nome       = nome;
        this.quantVezes = quantVezes;
        this.sessoes    = sessoes;
    }

    public Peso() {}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantVezes() {
        return quantVezes;
    }
    public void setQuantVezes(Integer quantVezes) {
        this.quantVezes = quantVezes;
    }
    public Integer getSessoes() {
        return sessoes;
    }
    public void setSessoes(Integer sessoes) {
        this.sessoes = sessoes;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
