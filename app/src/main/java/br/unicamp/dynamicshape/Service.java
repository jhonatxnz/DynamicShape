package br.unicamp.dynamicshape;

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

    @PUT("/api/academia/put")
    Call<Usuario> alterarUsuario(@Path("id") String id,@Body Usuario usuario);

    @GET("/api/academia/delete/{id}")
    Call<Usuario> excluirUsuario(@Path("id") String id);

    @POST("/api/login")
    Call<Usuario> getLogin (@Body Usuario usuario);

    @GET("/api/academia/{email}")
    Call<Usuario> getUsuarioByEmail(@Path("email") String email);

}