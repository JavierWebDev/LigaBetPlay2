package com.jashdevelopment.model;

public class Equipo {
    String nombreEquipo;
    int equipoID = 0;
    int partidosJugados = 0;
    int partidosGanados = 0;
    int partidosPerdidos = 0;
    int partidosEmpatados = 0;
    int golesFavor = 0;
    int golesContra = 0;
    int puntosTotales = 0;
    
    public Equipo() {
    }

    public Equipo(int equipoID) {
        this.equipoID = equipoID;
    }

    public Equipo(String nombreEquipo, int partidosJugados, int partidosGanados, int partidosPerdidos,
            int partidosEmpatados, int golesFavor, int golesContra, int puntosTotales) {
        this.nombreEquipo = nombreEquipo;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.puntosTotales = puntosTotales;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }
}
