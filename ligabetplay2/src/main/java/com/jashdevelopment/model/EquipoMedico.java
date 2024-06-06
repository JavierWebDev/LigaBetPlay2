package com.jashdevelopment.model;

public class EquipoMedico extends Equipo {
    int equipoID;
    String nombreMedico;
    
    public EquipoMedico() {}

    public EquipoMedico(int equipoID, String nombreMedico) {
        super(equipoID);
        this.nombreMedico = nombreMedico;
    }

    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
}

