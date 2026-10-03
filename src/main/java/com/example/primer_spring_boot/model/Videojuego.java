package com.example.primer_spring_boot.model;




public class Videojuego {
    private long id;
    private String name;
    private Integer hours;
    private Boolean completed;

    public Videojuego(String name,Integer hours, Boolean completed){

        this.name = name;
        this.hours = hours;
        this.completed = completed;
    }

    public Videojuego(){

    }

    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public Integer getHours(){return this.hours;}
    public Boolean getCompleted(){return this.completed;}


    public void setName(String name) {
        this.name = name;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setId(long id){
        this.id = id;
    }
}
