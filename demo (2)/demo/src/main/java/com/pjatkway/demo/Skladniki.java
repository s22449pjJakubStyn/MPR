package com.pjatkway.demo;

public class Skladniki {

    public Skladniki(Integer id, String nazwa, Double cena, Integer kalorie) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.kalorie = kalorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getKalorie() {
        return kalorie;
    }

    public void setKalorie(Integer kalorie) {
        this.kalorie = kalorie;
    }

    @Override
    public String toString() {
        return "Skladniki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", kalorie=" + kalorie +
                '}';
    }

    private Integer id;
    private String nazwa;
    private Double cena;
    private Integer kalorie;
}
