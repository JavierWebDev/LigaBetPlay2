package com.jashdevelopment.model;

public class Jugador extends Equipo {
    private int equipoID;
    private String nombreJugador;
    private int dorsalJugador;
    private String posJugador;
    private String nacionalidadJugador;
    private String fechaIngreso;
    private int goles;
    private int tarjetasR;
    private int tarjetasA;
    
    public Jugador() {}



    public Jugador(String nombreEquipo, int partidosJugados, int partidosGanados, int partidosPerdidos,
            int partidosEmpatados, int golesFavor, int golesContra, int puntosTotales, int equipoID,
            String nombreJugador, int dorsalJugador, String nacionalidadJugador, String posJugador, String fechaIngreso, int goles,
            int tarjetasR, int tarjetasA) {
        super(equipoID);
        this.equipoID = equipoID;
        this.nombreJugador = nombreJugador;
        this.dorsalJugador = dorsalJugador;
        this.posJugador = posJugador;
        this.nacionalidadJugador = nacionalidadJugador;
        this.fechaIngreso = fechaIngreso;
        this.goles = goles;
        this.tarjetasR = tarjetasR;
        this.tarjetasA = tarjetasA;
    }
    

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getDorsalJugador() {
        return dorsalJugador;
    }

    public void setDorsalJugador(int dorsalJugador) {
        this.dorsalJugador = dorsalJugador;
    }

    public String getNacionalidadJugador() {
        return nacionalidadJugador;
    }

    public void setNacionalidadJugador(String nacionalidadJugador) {
        this.nacionalidadJugador = nacionalidadJugador;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTarjetasR() {
        return tarjetasR;
    }

    public void setTarjetasR(int tarjetasR) {
        this.tarjetasR = tarjetasR;
    }

    public int getTarjetasA() {
        return tarjetasA;
    }

    public void setTarjetasA(int tarjetasA) {
        this.tarjetasA = tarjetasA;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public String getPosJugador() {
        return posJugador;
    }

    public void setPosJugador(String posJugador) {
        this.posJugador = posJugador;
    }
}
