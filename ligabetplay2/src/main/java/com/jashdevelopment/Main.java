package com.jashdevelopment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jashdevelopment.model.Equipo;
import com.jashdevelopment.model.Fecha;

public class Main {

    @SuppressWarnings({ "unused", "resource" })
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void listarOpc(ArrayList<String> opciones) {
        int idx = 0;
        for (String opcion : opciones) {
            idx++;
            System.out.println(MessageFormat.format("{0}. {1}", idx, opcion));
        }
    }

    public static void listarEquipos(ArrayList<Equipo> equipos) {
        int idx = 0;
        for (Equipo equipo : equipos) {
            idx++;
            System.out.println(MessageFormat.format("{0}. {1}", idx, equipo.getNombreEquipo()));
        }
    }

    public static void menuPrincipal() {
        limpiarConsola();

        String banner = "                                                                             \n" +
                "#                          ######               ######                       \n" +
                "#       #  ####    ##      #     # ###### ##### #     # #        ##   #   #  \n" +
                "#       # #    #  #  #     #     # #        #   #     # #       #  #   # #   \n" +
                "#       # #      #    #    ######  #####    #   ######  #      #    #   #    \n" +
                "#       # #  ### ######    #     # #        #   #       #      ######   #    \n" +
                "#       # #    # #    #    #     # #        #   #       #      #    #   #    \n" +
                "####### #  ####  #    #    ######  ######   #   #       ###### #    #   #    \n" +
                "                                                                             \n";

        String[] opcMenu = { "Registrar Team", "Registro De Fechas", "Reportes", "Salir" };

        System.out.println(banner);

        int idx = 0;
        for (String opc : opcMenu) {
            idx++;
            System.out.println(MessageFormat.format("{0}. {1}", idx, opc));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Fecha> fechas = new ArrayList<>();

        boolean isActive = true;
        while (isActive) {
            limpiarConsola();
            menuPrincipal();
            try {
                int opMain = Integer.parseInt(sc.nextLine().trim());

                switch (opMain) {
                    case 1 -> {
                        limpiarConsola();
                        ArrayList<String> menuRegEquipo = new ArrayList<>(Arrays.asList("Registrar Club", "Registrar Jugadores", "Registrar Cuerpo Tecnico", "Registrar Equipo Medico", "Salir"));
                        System.out.println("********** REGISTRAR EQUIPO **********");
                        listarOpc(menuRegEquipo);
                        int opRegEquipo = Integer.parseInt(sc.nextLine().trim());

                        switch (opRegEquipo) {
                            case 1 -> {
                                String isActiveRegTeam = "S";
                                while (isActiveRegTeam.equalsIgnoreCase("S")) {
                                    Equipo myEquipo = new Equipo();

                                    limpiarConsola();
                                    System.out.println("------- Registrar Equipo -------");

                                    System.out.println("[?] Ingresa el nombre del equipo: ");
                                    myEquipo.setNombreEquipo(sc.nextLine());

                                    // Designar el ID del equipo
                                    
                                    if (equipos.isEmpty()) {
                                        myEquipo.setEquipoID(1);
                                    } else {
                                        int lastID = (equipos.get(equipos.size() -1)).getEquipoID();
                                        myEquipo.setEquipoID(lastID + 1);
                                    }

                                    // Inicialización de variables en 0
                                    myEquipo.setPartidosJugados(0);
                                    myEquipo.setPartidosGanados(0);
                                    myEquipo.setPartidosPerdidos(0);
                                    myEquipo.setPartidosEmpatados(0);
                                    myEquipo.setGolesFavor(0);
                                    myEquipo.setGolesContra(0);

                                    equipos.add(myEquipo);

                                    String mensajeRegistro = MessageFormat.format(
                                            " [*] PARTIDOS JUGADOS   :        {0}\n" +
                                                    " [*] PARTIDOS GANADOS   :        {1}\n" +
                                                    " [*] PARTIDOS PERDIDOS  :        {2}\n" +
                                                    " [*] PARTIDOS EMPATADOS :        {3}\n" +
                                                    " [*] GOLES A FAVOR      :        {4}\n" +
                                                    " [*] GOLES EN CONTRA    :        {5}\n" +
                                                    " [*] ID EQUIPO  =>  {6}\n",
                                            myEquipo.getPartidosJugados(), myEquipo.getPartidosGanados(),
                                            myEquipo.getPartidosPerdidos(), myEquipo.getPartidosEmpatados(),
                                            myEquipo.getGolesFavor(), myEquipo.getGolesContra(), myEquipo.getEquipoID());

                                    System.out.println(mensajeRegistro + "\n");

                                    System.out.println(" [?] Deseas ingresar otro equipo? (Ingresa [S] - Si | Presiona cualquier tecla para volver)");

                                    isActiveRegTeam = sc.nextLine().trim().toUpperCase();
                                }
                            }
                            case 5 -> {
                                // Salir del menú de registro de equipo
                                limpiarConsola();
                            }
                            default -> {
                                System.out.println("Ingresaste una opción inválida.");
                                sc.nextLine();
                            }
                        }
                    }
                    case 4 -> {
                        // Salir del programa
                        isActive = false;
                        System.out.println("Saliendo del programa...");
                    }
                    default -> {
                        System.out.println("Ingresaste una opción inválida.");
                        sc.nextLine();
                    }
                }
            } catch (NumberFormatException e) {
                limpiarConsola();
                System.out.println("Ingresaste una opción inválida.");
                sc.nextLine(); // Limpia el buffer
            }
        }
    }
}
