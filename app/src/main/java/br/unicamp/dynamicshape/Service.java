package br.unicamp.dynamicshape;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {
    @GET("/api/academia/get")
    Call<List<Usuario>> getUsuario();

    @GET("/api/academia/getNome/{nome}")
    Call<Usuario> selecionarNome(@Path("nome") String Nome);

    @POST("/api/academia/post")
    Call<Usuario> incluirUsuario(@Body Usuario usuario);

    @PUT("/api/academia/{email}")
    Call<Usuario> alterarUsuario(@Path("email") String email,@Body Usuario usuario);

    @GET("/api/academia/delete/{id}")
    Call<Usuario> excluirUsuario(@Path("id") String id);

    @POST("/api/login")
    Call<Usuario> getLogin (@Body Usuario usuario);

    @GET("/api/academia/{email}")
    Call<Usuario> getUsuarioByEmail(@Path("email") String email);

    //Exercicios
    @GET("/api/exercicios/50_150")
    Call<ArrayList<Peso>> getExercicio50_150();

    @GET("/api/exercicios/60_160")
    Call<ArrayList<Peso>> getExercicio60_160();

    @GET("/api/exercicios/70_170")
    Call<ArrayList<Peso>> getExercicio70_170();

    @GET("/api/exercicios/padrao")
    Call<ArrayList<Peso>> getExercicioPadrao();

    @POST("/api/exercicios/post")
    Call<Exercicioo> incluirExercicio(@Body Exercicioo exercicioo);
}