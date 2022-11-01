package br.unicamp.dynamicshape;
import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Exercicioo implements Serializable{
    @SerializedName("id")
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("quantVezes")
    private Integer quantVezes;
    @SerializedName("sessoes")
    private Integer sessoes;
    @SerializedName("idAmbiente")
    private Integer idAmbiente;
    @SerializedName("idObjetivo")
    private Integer idObjetivo;

    public Exercicioo(String id,String nome, Integer quantVezes,Integer sessoes,Integer idAmbiente,Integer idObjetivo) {
        this.id         = id;
        this.nome       = nome;
        this.quantVezes = quantVezes;
        this.sessoes    = sessoes;
        this.idAmbiente = idAmbiente;
        this.idObjetivo = idObjetivo;
    }
    public Exercicioo() {}
    public Exercicioo(String nome,Integer quantVezes) {
        this.nome       = nome;
        this.quantVezes = quantVezes;
    }

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

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }
}
