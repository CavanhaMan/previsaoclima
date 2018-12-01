package com.example.aluno.previsaoclima.model;

public class DadosClima {
//    private Double latitude;
//    private Double longitude;

    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude=minutely,hourly,daily,flags,alerts")
    Call<DadosClima> consulta(@Path("latitude") double latitude,
                              @Path("longitude") double longitude);
}
