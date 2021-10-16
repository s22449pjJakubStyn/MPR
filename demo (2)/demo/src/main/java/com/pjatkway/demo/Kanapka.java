package com.pjatkway.demo;

import java.util.List;
public class Kanapka {

    public Kanapka(Integer id, String name, Double cena, Integer kalorie, List<Skladniki> skladniki, SandwichSize wielkosc, String rodzaj) {
        this.id = id;
        this.name = name;
        this.cena = cena;
        this.kalorie = kalorie;
        this.skladniki = skladniki;
        this.wielkosc = wielkosc;
        this.rodzaj = rodzaj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Skladniki> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(List<Skladniki> skladniki) {
        this.skladniki = skladniki;
    }

    public SandwichSize getWielkosc() {
        return wielkosc;
    }

    public void setWielkosc(SandwichSize wielkosc) {
        this.wielkosc = wielkosc;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }


    @Override
    public String toString() {
        return "Kanapka{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cena=" + cena +
                ", kalorie=" + kalorie +
                ", skladniki=" + skladniki +
                ", wielkosc=" + wielkosc +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }

    private Integer id;
    private String name;
    private Double cena;
    private Integer kalorie;
    private List <Skladniki> skladniki;
    private SandwichSize wielkosc;
    private String rodzaj;


}