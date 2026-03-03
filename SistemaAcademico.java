package main;

import java.util.ArrayList;
import java.util.Scanner;


public class SistemaAcademico {
    
    
  
    private static ArrayList<String> estudiantes = new ArrayList<>();
    
   
    private static ArrayList<String> asignaturas = new ArrayList<>();
    
    
    private static ArrayList<Double> notas = new ArrayList<>();
    
   
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    public static void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("\n=== SISTEMA ACADÉMICO ===");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Actualizar Estudiante");
            System.out.println("5. Eliminar Estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch(opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    System.out.println("2: Listar Estudiantes");
                    listarEstudiantes();
                    break;
                case 3:
                    System.out.println("3: Buscar Estudiante");
                    buscarEstudiante();
                    break;
                case 4:
                    System.out.println("4: Actualizar Estudiante");
                    actualizarEstudiante();
                    break;
                case 5:
                    System.out.println("5: Eliminar Estudiante");
                     eliminarEstudiante();
                    break;
                case 6:
                    System.out.println("¡BYE!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 6);
    }
    
    // Método para registrar estudiante (CREATE)
    public static void registrarEstudiante() {
        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        estudiantes.add(nombre);
        System.out.println("Estudiante registrado exitosamente!");
        System.out.println("Total de estudiantes: " + estudiantes.size());
    }
    
    
    
    
    // Método para listar estudiantes (READ)
public static void listarEstudiantes() {
    System.out.println("\n--- LISTA DE ESTUDIANTES ---");
    
    if(estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes registrados.");
    } else {
        for(int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i));
        }
        System.out.println("Total: " + estudiantes.size() + " estudiantes");
    }
}






// Método para buscar estudiante (READ)
public static void buscarEstudiante() {
    System.out.println("\n--- BUSCAR ESTUDIANTE ---");
    System.out.print("Ingrese el nombre del estudiante a buscar: ");
    String nombreBuscado = scanner.nextLine();
    
    boolean encontrado = false;
    for(int i = 0; i < estudiantes.size(); i++) {
        if(estudiantes.get(i).equalsIgnoreCase(nombreBuscado)) {
            System.out.println("Estudiante encontrado en posición: " + (i + 1));
            System.out.println("Nombre: " + estudiantes.get(i));
            encontrado = true;
            break;
        }
    }
    
    if(!encontrado) {
        System.out.println("Estudiante no encontrado.");
    }
}





// Método para actualizar estudiante (UPDATE)
public static void actualizarEstudiante() {
    System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
    
    if(estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes para actualizar.");
        return;
    }
    
    // Mostrar lista de estudiantes
    for(int i = 0; i < estudiantes.size(); i++) {
        System.out.println((i + 1) + ". " + estudiantes.get(i));
    }
    
    System.out.print("Seleccione el número del estudiante a actualizar: ");
    int indice = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer
    
    if(indice > 0 && indice <= estudiantes.size()) {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        
        String nombreAnterior = estudiantes.get(indice - 1);
        estudiantes.set(indice - 1, nuevoNombre);
        
        System.out.println("Estudiante actualizado exitosamente!");
        System.out.println("Nombre anterior: " + nombreAnterior);
        System.out.println("Nombre nuevo: " + nuevoNombre);
    } else {
        System.out.println("Número de estudiante no válido.");
    }
}


// Método para eliminar estudiante (DELETE)
public static void eliminarEstudiante() {
    System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
    
    if(estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes para eliminar.");
        return;
    }
    
    // Mostrar lista de estudiantes
    for(int i = 0; i < estudiantes.size(); i++) {
        System.out.println((i + 1) + ". " + estudiantes.get(i));
    }
    
    System.out.print("Seleccione el número del estudiante a eliminar: ");
    int indice = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer
    
    if(indice > 0 && indice <= estudiantes.size()) {
        String estudianteEliminado = estudiantes.remove(indice - 1);
        System.out.println("Estudiante eliminado exitosamente: " + estudianteEliminado);
        System.out.println("Total de estudiantes ahora: " + estudiantes.size());
    } else {
        System.out.println("Número de estudiante no válido.");
    }
}
}