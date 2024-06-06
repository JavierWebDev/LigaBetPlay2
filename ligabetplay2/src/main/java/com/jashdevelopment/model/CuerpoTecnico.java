package com.jashdevelopment.model;

public class CuerpoTecnico extends Equipo {
    int equipoID;
    String directorTecnico;
    String asistenteTecnico;
    String prepFisico;

    public CuerpoTecnico() {}

    public CuerpoTecnico(int equipoID, String directorTecnico, String asistenteTecnico, String prepFisico) {
        super(equipoID);
        this.directorTecnico = directorTecnico;
        this.asistenteTecnico = asistenteTecnico;
        this.prepFisico = prepFisico;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public String getAsistenteTecnico() {
        return asistenteTecnico;
    }

    public void setAsistenteTecnico(String asistenteTecnico) {
        this.asistenteTecnico = asistenteTecnico;
    }

    public String getPrepFisico() {
        return prepFisico;
    }

    public void setPrepFisico(String prepFisico) {
        this.prepFisico = prepFisico;
    }

    
    
    
}
