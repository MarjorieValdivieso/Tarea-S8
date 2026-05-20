
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Persona> lista = new ArrayList<>();

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar persona");
            System.out.println("2. Mostrar registros");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> registrar();
                    case 2 -> mostrar();
                    case 3 -> actualizar();
                    case 4 -> eliminar();
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Error: opcion invalida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar solo numeros.");
                sc.nextLine();
            }

        } while (opcion != 5);
    }

    // Validar cedula repetida
    static boolean existeCedula(String cedula) {
        for (Persona p : lista) {
            if (p.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    // Crear
    static void registrar() {

        try {
            System.out.println("\n1. Estudiante");
            System.out.println("2. Docente");
            System.out.print("Tipo: ");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.print("Ingrese cedula: ");
            String cedula = sc.nextLine();

            if (cedula.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            if (existeCedula(cedula)) {
                System.out.println("Error: ya existe una persona con esa cedula.");
                return;
            }

            System.out.print("Ingrese nombre: ");
            String nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            System.out.print("Ingrese edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if (tipo == 1) {

                System.out.print("Ingrese carrera: ");
                String carrera = sc.nextLine();

                if (carrera.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                lista.add(new Estudiante(cedula, nombre, edad, carrera));

            } else if (tipo == 2) {

                System.out.print("Ingrese asignatura: ");
                String asignatura = sc.nextLine();

                if (asignatura.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                lista.add(new Docente(cedula, nombre, edad, asignatura));

            } else {
                System.out.println("Tipo invalido.");
                return;
            }

            System.out.println("Registro agregado correctamente.");

        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar solo numeros.");
            sc.nextLine();
        }
    }

    //mostrar
    static void mostrar() {

        if (lista.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nPosicion: " + i);
            lista.get(i).mostrarDatos();
        }
    }

    // actualizar
    static void actualizar() {

        try {
            System.out.print("\nIngrese posicion: ");
            int pos = sc.nextInt();
            sc.nextLine();

            if (pos < 0 || pos >= lista.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            Persona p = lista.get(pos);

            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Nueva edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            p.setNombreCompleto(nombre);
            p.setEdad(edad);

            System.out.println("Actualizado correctamente.");

        } catch (InputMismatchException e) {
            System.out.println("Error de entrada.");
            sc.nextLine();
        }
    }

    // eliminar
    static void eliminar() {

        try {

            System.out.print("Ingrese posicion: ");
            int pos = sc.nextInt();
            sc.nextLine();

            if (pos < 0 || pos >= lista.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            lista.remove(pos);
            System.out.println("Eliminado correctamente.");

        } catch (InputMismatchException e) {
            System.out.println("Error de entrada.");
            sc.nextLine();
        }
    }
}
