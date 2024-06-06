package com.jashdevelopment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jashdevelopment.model.CuerpoTecnico;
import com.jashdevelopment.model.Equipo;
import com.jashdevelopment.model.Fecha;
import com.jashdevelopment.model.Jugador;
import com.jashdevelopment.model.EquipoMedico;;

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
        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<CuerpoTecnico> tecnicos = new ArrayList<>();
        ArrayList<EquipoMedico> medicos = new ArrayList<>();

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

                                    limpiarConsola();

                                    System.out.println("[*] Equipo registrado exitosamente!\n");

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

                                    System.out.println(" [?] Deseas ingresar otro equipo? [S (SI) | Cualquier tecla (NO)]");

                                    isActiveRegTeam = sc.nextLine().trim().toUpperCase();
                                }
                            }
                            case 2 -> {
                                if (equipos.size() < 1) {
                                    limpiarConsola();
                                    System.out.println("[!] No hay ningun equipo registrado, registra uno para poder registrar jugadores");
                                    sc.nextLine();
                                } else {
                                    limpiarConsola();

                                    String isActiveRegPlayer = "S";
                                    while (isActiveRegPlayer.equalsIgnoreCase("S")) {
                                        Jugador myPlayer = new Jugador();

                                        System.out.println("********** REGISTRAR JUGADOR ***********");

                                        /* Elegir Equipo Jugador */

                                        listarEquipos(equipos);
                                        System.out.println("[?] Ingresa el equipo al cual pertenece el jugador: ");
                                        int equipoJugador = Integer.parseInt(sc.nextLine().trim());
                                        myPlayer.setEquipoID(equipoJugador);

                                        /* Guardar Equipo */

                                        Equipo playerTeam = equipos.get(equipoJugador - 1);

                                        /* Registrar Nombre */

                                        System.out.println("[?] Ingresa el nombre del jugador: ");
                                        myPlayer.setNombreJugador(sc.nextLine());

                                        /* Registrar Dorsal */

                                        System.out.println("[?] Ingresa el dorsal del jugador: ");
                                        myPlayer.setDorsalJugador(Integer.parseInt(sc.nextLine().trim()));

                                        /* Registrar PosJugador  */

                                        System.out.println("[?] Ingresa la posicion del jugador: ");
                                        myPlayer.setPosJugador(sc.nextLine());

                                        /* Registrar nacionalidad */
                                        
                                        System.out.println("[?] Ingresa la nacionalidad: ");
                                        myPlayer.setNacionalidadJugador(sc.nextLine());

                                        /* Registar fecha ingreso */

                                        System.out.println("[?] Ingresa la fecha de ingreso (dd/mm/aaaa): ");
                                        myPlayer.setNacionalidadJugador(sc.nextLine());

                                        /* Registrar Goles Anotados */
                                        if (playerTeam.getGolesFavor() >= 0) {
                                            System.out.println("[?] Ingresa el numero de goles anotados por el jugador");
                                            int golesPlayer = (Integer.parseInt(sc.nextLine().trim()));

                                            if (golesPlayer > playerTeam.getGolesFavor()) {
                                                System.out.println("[!] No puedes registrar mas goles de los que ha anotado el equipo!");
                                                sc.nextLine();
                                                isActiveRegPlayer = sc.nextLine();
                                            } else {
                                                myPlayer.setGoles(golesPlayer);
                                            }

                                        } else {
                                            limpiarConsola();
                                            System.out.println("[!] El equipo debe tener registrado algun gol para poder registrar goles a los jugadores!");

                                            sc.nextLine();
                                        }

                                        /* Registrar Tarjetas Rojas */

                                        System.out.println("[?] Ingresa la cantidad de tarjetas rojas del jugador: ");
                                        myPlayer.setTarjetasR(Integer.parseInt(sc.nextLine().trim()));

                                        /* Registrar Tarjetas Amarillas */

                                        System.out.println("[?] Ingresa la cantidad de tarjetas amarillas del jugador: ");
                                        myPlayer.setTarjetasA(Integer.parseInt(sc.nextLine().trim()));


                                        jugadores.add(myPlayer);

                                        System.out.println("[*] Jugador registrado exitosamente!");

                                        System.out.println("[?] Deseas registrar otro jugador? [S (SI) | Cualquier tecla (NO)]");

                                        isActiveRegPlayer = sc.nextLine();
                                    }
                                }
                            }

                            case 3 -> {
                                if (equipos.size() < 1) {
                                    limpiarConsola();
                                    System.out.println("[!] No hay ningun equipo registrado, registra uno para poder registrar el cuerpo tecnico.");
                                    sc.nextLine();
                                } else {
                                    String isActiveRegTecnicTeam = "S";
                                    while (isActiveRegTecnicTeam.equals("S")) {
                                        CuerpoTecnico myTecnics = new CuerpoTecnico();

                                        System.out.println("********** REGISTRAR CUERPO TECNICO ***********");

                                        /* Elegir Equipo Cuerpo Tecnico */

                                        listarEquipos(equipos);
                                        System.out.println("[?] Ingresa el equipo al cual pertenece el Cuerpo Tecnico: ");
                                        int equipoCuerpoTecnico = Integer.parseInt(sc.nextLine().trim());
                                        myTecnics.setEquipoID(equipoCuerpoTecnico);

                                        /* Guardar Equipo

                                        Equipo tecnicsTeam = equipos.get(equipoCuerpoTecnico - 1); */

                                        /* Registrar Director Tecnico */

                                        System.out.println("[?] Ingresa el nombre del DT (Director Tecnico): ");
                                        myTecnics.setDirectorTecnico(sc.nextLine());

                                        /* Registrar Asistente Tecnico */

                                        System.out.println("[?] Ingresa el nombre del AT (Asistente Tecnico): ");
                                        myTecnics.setAsistenteTecnico(sc.nextLine());

                                        /* Registrar Preparador Fisico */

                                        System.out.println("[?] Ingresa el nombre del PF (Preparador Fisico): ");
                                        myTecnics.setPrepFisico(sc.nextLine());

                                        tecnicos.add(myTecnics);

                                        System.out.println("[?] Desea ingresar otro Cuerpo Tecnico? [S (SI) | Cualquier tecla (NO)]");

                                        isActiveRegTecnicTeam = sc.nextLine();
                                    }
                                }

                            }

                            // Registrar Equipo Medico
                            case 4 -> {
                                if (equipos.size() < 1) {
                                    limpiarConsola();
                                    System.out.println("[!] No hay ningun equipo registrado, registra uno para poder registrar el equipo medico.");
                                    sc.nextLine();
                                } else {
                                    String isActiveRegMed = "S";
                                    while (isActiveRegMed.equals("S")) {
                                        EquipoMedico medico = new EquipoMedico();

                                        System.out.println("********** REGISTRAR CUERPO TECNICO ***********");

                                        /* Elegir Equipo Cuerpo Medico */

                                        listarEquipos(equipos);
                                        System.out.println("[?] Ingresa el equipo al cual pertenece el Cuerpo Medico: ");
                                        int equipoMed = Integer.parseInt(sc.nextLine().trim());
                                        medico.setEquipoID(equipoMed);

                                        /* Registrar Nombre Medico */

                                        System.out.println("[?] Ingresa el nombre del Medico Principal: ");
                                        medico.setNombreMedico(sc.nextLine());

                                        medicos.add(medico);
                                        
                                        System.out.println("[?] Desea ingresar otro Cuerpo Medico? [S (SI) | Cualquier tecla (NO)]");

                                        isActiveRegMed = sc.nextLine();

                                    }
                                }
                            }

                            case 5 -> {
                                // Salir del menú de registro de equipo
                                limpiarConsola();
                            }

                            default -> {
                                System.out.println("[!] Ingresaste una opción inválida.");
                                sc.nextLine();
                            }
                        }
                    }

                    case 2 -> {
                        if (equipos.size() >= 2) {

                            String isActiveRegMatch = "S";
                            while (isActiveRegMatch.equals("S")) {
                                Fecha fecha = new Fecha();

                                int marcadorEquipoLocal = 0;
                                int marcadorEquipoVisitante = 0;

                                int opGen = 0;

                                /* Registrar Equipo Local */
                                limpiarConsola();
                                System.out.println("********** Registrar Fecha **********");
                                listarEquipos(equipos);
                                System.out.println("[?] Ingresa el equipo local:");
                                
                                opGen = Integer.parseInt(sc.nextLine().trim());

                                Equipo local = equipos.get(opGen - 1);

                                fecha.setEquipoLocal(local.nombreEquipo);

                                local.setPartidosJugados(local.getPartidosJugados() + 1);

                                /* Registrar Equipo Visitante */
                                limpiarConsola();
                                System.out.println("********** Registrar Fecha **********");
                                listarEquipos(equipos);
                                System.out.println("[?] Ingresa el equipo visitante:");
                                
                                opGen = Integer.parseInt(sc.nextLine().trim());

                                Equipo visitante = equipos.get(opGen - 1);

                                fecha.setEquipoVisitante(visitante.nombreEquipo);

                                visitante.setPartidosJugados(visitante.getPartidosJugados() + 1);

                                /* Marcador equipo local  */

                                limpiarConsola();
                                System.out.println("********** Registrar Fecha **********");

                                String mensajeGoles1 = MessageFormat.format(" [?] Ingresa la cantidad de goles del equipo ( {0} ):", local.getNombreEquipo());

                                System.out.println(mensajeGoles1);

                                marcadorEquipoLocal = sc.nextInt();

                                local.setGolesFavor(marcadorEquipoLocal);
                                visitante.setGolesContra(marcadorEquipoLocal);
                                fecha.setGolesEquipo1(marcadorEquipoLocal);

                                /* Marcador equipo local */

                                limpiarConsola();
                                System.out.println("********** Registrar Fecha **********");

                                String mensajeGoles2 = MessageFormat.format(" [?] Ingresa la cantidad de goles del equipo ( {0} ):", visitante.getNombreEquipo());

                                System.out.println(mensajeGoles2);

                                marcadorEquipoVisitante = sc.nextInt();

                                visitante.setGolesFavor(marcadorEquipoVisitante);
                                local.setGolesContra(marcadorEquipoVisitante);
                                fecha.setGolesEquipo2(marcadorEquipoVisitante);

                                fechas.add(fecha);


                                if (marcadorEquipoLocal > marcadorEquipoVisitante) {
                                    local.setPartidosGanados(local.getPartidosGanados() + 1);
                                    visitante.setPartidosPerdidos(visitante.getPartidosPerdidos() + 1);

                                    local.setPuntosTotales(local.getPuntosTotales() + 3);
                                } else if (marcadorEquipoVisitante > marcadorEquipoLocal) {
                                    visitante.setPartidosGanados(visitante.getPartidosGanados() + 1);
                                    local.setPartidosPerdidos(local.getPartidosPerdidos() + 1);

                                    visitante.setPuntosTotales(visitante.getPuntosTotales() + 3);
                                } else {
                                    local.setPartidosEmpatados(local.getPartidosEmpatados() + 1);
                                    visitante.setPartidosEmpatados(visitante.getPartidosEmpatados() + 1);

                                    local.setPuntosTotales(local.getPuntosTotales() + 1);
                                    visitante.setPuntosTotales(visitante.getPuntosTotales() + 1);
                                }

                                System.out.println(" [?] Deseas ingresar otra fecha? [S (SI) | Cualquier tecla (NO)]");

                                isActiveRegMatch = sc.next().toUpperCase();

                            }
                        } else {
                            limpiarConsola();
                            System.out.println("[!] Debes ingresar al menos 2 equipos para registrar una fecha!");
                            sc.nextLine();
                        }
                    }

                    // REPORTES
                    case 3 -> {
                        limpiarConsola();

                        boolean isActiveReportMenu = true;
                        ArrayList<String> menuReportes = new ArrayList<>(Arrays.asList("Reportes Partidos", "Reportes Jugadores", "Salir"));

                        while (isActiveReportMenu) {
                            System.out.println("********** MENU REPORTES **********");

                            listarOpc(menuReportes);

                            int opReportes = Integer.parseInt(sc.nextLine().trim());

                            switch (opReportes) {
                                
                                // Reportes partidos
                                case 1 -> {
                                    String isActiveResumen = "S";
                                    while (isActiveResumen.equals("S")) {
                                        if (equipos.size() > 1 && fechas.size() >= 1) {
                                            limpiarConsola();
                                            System.out.println("********* RESUMEN LIGA BETPLAY *********");
                                            
                                            // Equipo con mas goles
                                            String nombreMaxGoles = "";
                                            String nombreMaxPuntos = "";
                                            String nombreMasGanados = "";
                                            int maxPuntos = 0;
                                            int maxGoles = 0;
                                            int maxGanados = 0;
                                            int sumGoles = 0;
                                            
                                            for (Equipo eqp : equipos) {
                                                int goles = eqp.getGolesFavor();
                                                int puntos = eqp.getPuntosTotales();
                                                int ganados = eqp.getPartidosGanados();
                                                sumGoles = sumGoles + eqp.getGolesFavor();
            
                                                if (goles > maxGoles) {
                                                    maxGoles = goles;
                                                    nombreMaxGoles = eqp.getNombreEquipo();
                                                }
                                                if (puntos > maxPuntos) {
                                                    nombreMaxPuntos = eqp.getNombreEquipo();
                                                }
                                                if (ganados > maxGanados) {
                                                    nombreMasGanados = eqp.getNombreEquipo();
                                                }
                                            }
            
                                            float pGoles = sumGoles / equipos.size();
            
                                            String mensajeResumen = MessageFormat.format(
                                                " [*] EQUIPO QUE MAS ANOTO    :       {0}\n" +
                                                " [*] EQUIPO CON MAS PUNTOS   :       {1}\n" +
                                                " [*] EQUIPO QUE MAS GANO     :       {2}\n" +
                                                " [*] GOLES ANOTADOS EN TOTAL :       {3}\n" +
                                                " [*] PROMEDIO DE GOLES       :       {4}\n"
                                            , nombreMaxGoles, nombreMaxPuntos, nombreMasGanados, sumGoles, pGoles);
            
                                            System.out.println(mensajeResumen);
                                            
                                            System.out.println(" [?] Volver... (Presiona cualquier tecla para volver)");
            
                                            isActiveResumen = sc.nextLine().toUpperCase();
            
                                        } else {
                                            limpiarConsola();
                                            System.out.println("[!] Necesitas al menos 1 fecha para ver el resumen\n[!] Ingresa cualquier tecla para volver");
                                            sc.nextLine();
                                        }
                                }
                            }

                                // Reportes Jugadores
                                case 2 -> {
                                    
                                }

                                default -> {
                                    System.out.println("[!] Ingresaste una opción inválida.");
                                    sc.nextLine();
                                }
                            }

                            
                        }
                    }

                    case 4 -> {
                        // Salir del programa
                        isActive = false;
                        System.out.println("[!] Saliendo del programa...");
                    }
                    default -> {
                        System.out.println("[!] Ingresaste una opción inválida.");
                        sc.nextLine();
                    }
                }
            } catch (NumberFormatException e) {
                limpiarConsola();
                System.out.println("[!] Ingresaste una opción inválida.");
                sc.nextLine(); // Limpia el buffer
            }
        }
    }
}
