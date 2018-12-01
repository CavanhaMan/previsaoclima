package com.example.aluno.previsaoclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aluno.previsaoclima.model.DadosClima;
import com.example.aluno.previsaoclima.model.InterfaceDeServicos;
import com.example.aluno.previsaoclima.service.RetrofitService;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void obtemClima(){
        InterfaceDeServicos services = RetrofitService.getServico();
        Call<DadosClima> call = services.consulta(1,1);
        call.enqueue(new Callback<DadosClima>(){

            @Override
            public void onResponse(Call<DadosClima> call, Response<DadosClima> response) {

            }

            @Override
            public void onFailure(Call<DadosClima> call, Throwable t) {

            }
        }
    }
}
