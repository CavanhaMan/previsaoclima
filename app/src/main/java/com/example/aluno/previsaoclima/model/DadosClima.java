package com.example.aluno.previsaoclima.model;

public class DadosClima {
    private Double latitude;
    private Double longitude;

    public DadosClima(Double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {return latitude;}
    public void setLatitude(Double latitude) {this.latitude = latitude;}

    public Double getLongitude() {return longitude;}
    public void setLongitude(Double longitude) {this.longitude = longitude;}
}
