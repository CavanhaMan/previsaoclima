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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                        String tempox=dadosClima.getCurrently().getIcon();
                        ImageView tempo = (ImageView) findViewById(R.id.imclima);

                        if (tempox.equals("clear-day"))
                            tempo.setImageResource(R.drawable.clearday);
                        else if (tempox.equals("clear-night"))
                            tempo.setImageResource(R.drawable.clearnight);
                        else if (tempox.equals("cloudy"))
                            tempo.setImageResource(R.drawable.cloudy);
                        else if (tempox.equals("fog"))
                            tempo.setImageResource(R.drawable.fog);
                        else if (tempox.equals("partly-cloudy-day"))
                            tempo.setImageResource(R.drawable.partlycloudday);
                        else if (tempox.equals("partly-cloudy-night"))
                            tempo.setImageResource(R.drawable.partlycloudynight);
                        else if (tempox.equals("rain"))
                            tempo.setImageResource(R.drawable.rain);
                        else if (tempox.equals("sleet"))
                            tempo.setImageResource(R.drawable.sleet);
                        else if (tempox.equals("snow"))
                            tempo.setImageResource(R.drawable.snow);
                        else if (tempox.equals("wind"))
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
