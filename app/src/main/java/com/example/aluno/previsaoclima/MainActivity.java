package com.example.aluno.previsaoclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

        EditText lat = (EditText)findViewById(R.id.edlatitude);
        EditText lon = (EditText)findViewById(R.id.edlongitude);

        final double latD = Double.parseDouble(lat.getText().toString());
        final double lonD = Double.parseDouble(lon.getText().toString());

        Button button = (Button) findViewById(R.id.btconsulta);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InterfaceDeServicos services = RetrofitService.getServico();

                Call<DadosClima> call = services.consulta(latD,lonD);

                call.enqueue(new Callback<DadosClima>(){
                    @Override
                    public void onResponse(Call<DadosClima> call, Response<DadosClima> response) {
                        DadosClima dadosClima = response.body();
                        String x=dadosClima.getCurrently().getIcon();
                        ImageView tempo = (ImageView) findViewById(R.id.imclima);

                        if (x.equals("clear-day"))
                            tempo.setImageResource(R.drawable.clearday);
                        else if (x.equals("clear-night"))
                            tempo.setImageResource(R.drawable.clearnight);
                        else if (x.equals("cloudy"))
                            tempo.setImageResource(R.drawable.cloudy);
                        else if (x.equals("fog"))
                            tempo.setImageResource(R.drawable.fog);
                        else if (x.equals("partly-cloudy-day"))
                            tempo.setImageResource(R.drawable.partlycloudday);
                        else if (x.equals("partly-cloudy-night"))
                            tempo.setImageResource(R.drawable.partlycloudynight);
                        else if (x.equals("rain"))
                            tempo.setImageResource(R.drawable.rain);
                        else if (x.equals("sleet"))
                            tempo.setImageResource(R.drawable.sleet);
                        else if (x.equals("snow"))
                            tempo.setImageResource(R.drawable.snow);
                        else if (x.equals("wind"))
                            tempo.setImageResource(R.drawable.wind);
                    }

                    @Override
                    public void onFailure(Call<DadosClima> call, Throwable t) {

                    }
                });

            }
        });

    }

}
