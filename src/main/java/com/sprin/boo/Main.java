package com.sprin.boo;

import com.sprin.boo.*;
import com.sprin.boo.Gestiondueno;
import com.sprin.boo.dueno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Hola mundo");
        int Opc = 0;
        while (Opc != 8) {
            System.out.println("Digite la accion que desea  hacer\n1.Insertar Dueño \n2.Insertar Mascotas \n3.Consultar Mascota por raza \n4.Consultar Mascota por tipo \n5.Consultar las mascotas que tengan paseos \n6.Modificar el dueño de una mascota \n7.Eliminar un dueño \n8.Salir del programa");
            Opc = teclado.nextInt();
            switch (Opc) {
                case 1:
                    Gestiondueno due = new Gestiondueno();
                    System.out.println("Ingresa el Nro_ID: ");
                    String Nro_ID = teclado.next();
                    System.out.println("Ingresa el Nombres: ");
                    String Nombres = teclado.next();
                    System.out.println("Ingresa los Apellido: ");
                    String Apellido = teclado.next();
                    System.out.println("Ingresa la Dirección: ");
                    String Dirección = teclado.next();
                    System.out.println("Ingresa el Telefono: ");
                    String Telefono = teclado.next();
                    dueno duenos = new dueno(Nro_ID, Nombres, Apellido, Dirección, Telefono);
                    due.insertarDueno(duenos);
                    break;
                case 2:
                    int Opc1 = 0;
                    String Id_cliente;
                    while (Opc1 != 4) {
                        System.out.println("Digite la accion que desea hacer\n1.Insertar Mascota nueva sin dueño insertado anteriormente \n2.Insertar Mascotas nueva con dueño ya insertado \n3.Saber que Dueños ya estan registrados \n4.Salir del programa");
                        Opc1 = teclado.nextInt();
                        switch (Opc1) {
                            case 1:
                                System.out.println("Primero Inserta el Nuevo dueño");
                                due = new Gestiondueno();
                                System.out.println("Ingresa el Nro_ID: ");
                                Nro_ID = teclado.next();
                                System.out.println("Ingresa el Nombres: ");
                                Nombres = teclado.next();
                                System.out.println("Ingresa los Apellido: ");
                                Apellido = teclado.next();
                                System.out.println("Ingresa la Dirección: ");
                                Dirección = teclado.next();
                                System.out.println("Ingresa el Telefono: ");
                                Telefono = teclado.next();
                                duenos = new dueno(Nro_ID, Nombres, Apellido, Dirección, Telefono);
                                due.insertarDueno(duenos);
                                System.out.println("Ahora inserta la nueva mascota");
                                Gestionmascota masc = new Gestionmascota();
                                System.out.println("Ingresa el Nro_mascota: ");
                                String Nro_mascota = teclado.next();
                                System.out.println("Ingresa el Nombre_mascota: ");
                                String Nombre_mascota = teclado.next();
                                System.out.println("Ingresa los Raza_mascota: ");
                                String Raza_mascota = teclado.next();
                                System.out.println("Ingresa la Clase_Animal: ");
                                String Clase_Animal = teclado.next();
                                System.out.println("Ingresa el Id_cliente: ");
                                Id_cliente = teclado.next();
                                mascota mascotas = new mascota(Nro_mascota, Nombre_mascota, Raza_mascota, Clase_Animal, Id_cliente);
                                masc.insertarmascota(mascotas);
                                System.out.println("Mascota y Dueño insertados exitosamente");
                                break;
                            case 2:
                                masc = new Gestionmascota();
                                System.out.println("Ingresa el Nro_mascota: ");
                                Nro_mascota = teclado.next();
                                System.out.println("Ingresa el Nombre_mascota: ");
                                Nombre_mascota = teclado.next();
                                System.out.println("Ingresa los Raza_mascota: ");
                                Raza_mascota = teclado.next();
                                System.out.println("Ingresa la Clase_Animal: ");
                                Clase_Animal = teclado.next();
                                System.out.println("Ingresa el Id_cliente: ");
                                Id_cliente = teclado.next();
                                mascotas = new mascota(Nro_mascota, Nombre_mascota, Raza_mascota, Clase_Animal, Id_cliente);
                                masc.insertarmascota(mascotas);
                                break;
                            case 3:
                                due = new Gestiondueno();
                                due.consultaD();
                                System.out.println("Digite el ID  del dueño que desea consultar");
                                String id = teclado.next();
                                if (due.buscarD(id) == null) {
                                    System.out.println("El dueño no se encontro registrado (POR LO TANTO ELIGE LA OPCION 1)");
                                } else {
                                    System.out.println(due.buscarD(id).toString());
                                    System.out.println(" ");
                                    System.out.println("EL DUEÑO SI SE ENCUENTRA REGISTRADO (POR LO TANTO ELIGE LA OPCION 2)");
                                    System.out.println(" ");
                                }
                                break;
                        }
                    }
                    break;
                case 3:
                    Gestionmascota masc = new Gestionmascota();
                    masc.consultaM();
                    System.out.println("Digite la raza de la mascota que desea consultar");
                    String raza = teclado.next();
                    if (masc.buscarraza(raza) == null) {
                        System.out.println("La mascota no se encontro");
                    } else {
                        System.out.println(masc.buscarraza(raza).toString());
                        System.out.println(" ");
                        System.out.println("LA MASCOTA SI SE ENCUENTRA REGISTRADA");
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    masc = new Gestionmascota();
                    masc.consultaM();
                    System.out.println("Digite el tipo de la mascota que desea consultar");
                    String tipo = teclado.next();
                    if (masc.buscartipo(tipo) == null) {
                        System.out.println("La mascota no se encontro");
                    } else {
                        System.out.println(masc.buscartipo(tipo).toString());
                        System.out.println(" ");
                        System.out.println("LA MASCOTA SI SE ENCUENTRA REGISTRADA");
                        System.out.println(" ");
                    }
                    break;
                case 5:
                    Gestionpaseo pas = new Gestionpaseo();
                    pas.consultaP();
                    System.out.println("Digite El Id de la mascota de la cual desea consultar sus paseos");
                    String mascotaid = teclado.next();
                    if (pas.buscarpaseomasc(mascotaid) == null) {
                        System.out.println("La mascota no tiene paseos pendientes");
                        System.out.println("");
                    } else {
                        System.out.println(pas.buscarpaseomasc(mascotaid).toString());
                        System.out.println(" ");
                        System.out.println("LA MASCOTA SI TIENE PASEOS PENDIENTES");
                        System.out.println(" ");
                    }
                    break;
                case 6:
                    int Opc2 = 0;
                    while (Opc2 != 3) {
                        System.out.println("Digite la accion que desea  hacer\n1.Actualizar el Telefono del dueño \n2.Actualizar Todos los datos del dueño \n3.Salir del programa");
                        Opc2 = teclado.nextInt();
                        switch (Opc2) {
                            case 1:
                                due = new Gestiondueno();
                                System.out.println("Ingresa el Id del dueño deseas modificar");
                                Nro_ID = teclado.next();
                                if (due.buscarD(Nro_ID) == null) {
                                    System.out.println("El dueño no esta registrado");
                                } else {
                                    System.out.println("modifica el dueño");
                                    System.out.println("Ingresa el NUEVO Telefono: ");
                                    Telefono = teclado.next();
                                    duenos = new dueno(Telefono);
                                    due.modificarduenotel(duenos);
                                    System.out.println("SE MODIFICO EL TELEFONO DEL DUEÑO");
                                    System.out.println(" ");
                                }
                                break;
                            case 2:
                                due = new Gestiondueno();
                                System.out.println("Ingresa el Id del dueño deseas modificar");
                                Nro_ID = teclado.next();
                                if (due.buscarD(Nro_ID) == null) {
                                    System.out.println("El dueño no esta registrado");
                                } else {
                                    System.out.println("modifica el apellido del dueño");
                                    System.out.println("Ingresa el NUEVO Nombre: ");
                                    Nombres = teclado.next();
                                    System.out.println("Ingresa el NUEVO Apellido: ");
                                    Apellido = teclado.next();
                                    System.out.println("Ingresa la NUEVA Dirección: ");
                                    Dirección = teclado.next();
                                    System.out.println("Ingresa el NUEVO Telefono: ");
                                    Telefono = teclado.next();
                                    duenos = new dueno(Nombres,Apellido,Dirección,Telefono);
                                    due.modificarduenodemasc(duenos);
                                    System.out.println("LA DUEÑO SE MODIFICO");
                                    System.out.println(" ");
                                }
                                break;
                        }
                    }
                    break;
                case 7:
                    int Opc3 = 0;
                    while (Opc3 != 4) {
                        System.out.println("Digite la accion que desea  hacer\n1.Eliminar dueño que tiene mascota y su mascota tiene paseos \n2.Eliminar dueño que tiene mascota y su mascota NO tiene paseos \n3.Eliminar dueño sin mascota \n4.Salir del programa");
                        Opc3 = teclado.nextInt();
                        switch (Opc3) {
                            case 1:
                                // Eliminar paseo
                                pas = new Gestionpaseo();
                                System.out.println("Para eliminar el dueño primero eliminaremos el paseo de su mascota");
                                System.out.println("Ingresa el paseo que deseas eliminar");
                                int Id_Paseo = teclado.nextInt();
                                if (pas.buscarpaseo(Id_Paseo) == null) {
                                    System.out.println("El paseo no se encontro");
                                } else {
                                    pas.eliminarPaseo(Id_Paseo);
                                    System.out.println("EL PASEO SE HA ELIMINADO CORRECTAMENTE");
                                    System.out.println(" ");

                                    // Eliminar mascota
                                    masc = new Gestionmascota();
                                    System.out.println("Para eliminar el dueño primero eliminaremos su mascota");
                                    System.out.println("Ingresa la mascota que deseas eliminar");
                                    String Nro_mascota = teclado.next();
                                    if (masc.buscarmascota(Nro_mascota) == null) {
                                        System.out.println("La mascota no se encontro");
                                    } else {
                                        masc.eliminarMascota(Nro_mascota);
                                        System.out.println("LA MASCOTA SE HA ELIMINADO CORRECTAMENTE");
                                        System.out.println(" ");

                                        // Eliminar dueño
                                        due = new Gestiondueno();
                                        System.out.println("Ingresa el Nro_ID del Dueño que deseas eliminar");
                                        Nro_ID = teclado.next();
                                        if (due.buscarD(Nro_ID) == null) {
                                            System.out.println("El Dueño no se encontro");
                                        } else {
                                            due.eliminarDueno(Nro_ID);
                                            System.out.println("EL DUEÑO SE HA ELIMINADO CORRECTAMENTE");
                                            System.out.println(" ");
                                        }
                                    }
                                }
                                break;
                            case 2:
                                // Eliminar mascota
                                masc = new Gestionmascota();
                                System.out.println("Para eliminar el dueño primero eliminaremos su mascota");
                                System.out.println("Ingresa la mascota que deseas eliminar");
                                String Nro_mascota = teclado.next();
                                if (masc.buscarmascota(Nro_mascota) == null) {
                                    System.out.println("La mascota no se encontro");
                                } else {
                                    masc.eliminarMascota(Nro_mascota);
                                    System.out.println("LA MASCOTA SE HA ELIMINADO CORRECTAMENTE");
                                    System.out.println(" ");

                                    // Eliminar dueño
                                    due = new Gestiondueno();
                                    System.out.println("Ingresa el Nro_ID del Dueño que deseas eliminar");
                                    Nro_ID = teclado.next();
                                    if (due.buscarD(Nro_ID) == null) {
                                        System.out.println("El Dueño no se encontro");
                                    } else {
                                        due.eliminarDueno(Nro_ID);
                                        System.out.println("EL DUEÑO SE HA ELIMINADO CORRECTAMENTE");
                                        System.out.println(" ");
                                    }
                                }
                                break;
                            case 3:
                                // Eliminar dueño
                                due = new Gestiondueno();
                                System.out.println("Ingresa el Nro_ID del Dueño que deseas eliminar");
                                Nro_ID = teclado.next();
                                if (due.buscarD(Nro_ID) == null) {
                                    System.out.println("El Dueño no se encontro");
                                } else {
                                    due.eliminarDueno(Nro_ID);
                                    System.out.println("EL DUEÑO SE HA ELIMINADO CORRECTAMENTE");
                                    System.out.println(" ");
                                }
                                break;
                        }
                    }
            }
        }
    }
}