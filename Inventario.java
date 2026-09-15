import java.util.Scanner;

// Clase molde para los productos requerida por la guía
class Producto {
    private String id;
    private String nombre;
    private String numSerie;
    private double valor;
    private String proveedor;
    private int cantidad;

    public Producto(String id, String nombre, String numSerie, double valor, String proveedor, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.valor = valor;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
}

public class Inventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== COMERCIALIZADORA OLIVANDERS ===");
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (n < 1) {
            n = 3; // Valor por defecto si ingresan 0 o menos
        }

        // 1. Arreglo unidimensional de objetos (Productos)
        Producto[] arregloProductos = new Producto[n];

        // 2. Arreglo bidimensional para gestionar existencias y reportes estructurados
        String[][] arregloExistencias = new String[n][2];

        // Ciclo para registrar los datos del inventario
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Producto " + (i + 1) + " ---");
            System.out.print("Número de identificación: ");
            String id = scanner.nextLine();

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Número de serie (Opcional): ");
            String numSerie = scanner.nextLine();

            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            System.out.print("Cantidad (Existencias): ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Nombre del proveedor: ");
            String proveedor = scanner.nextLine();

            // Guardamos el objeto en el arreglo unidimensional
            arregloProductos[i] = new Producto(id, nombre, numSerie, valor, proveedor, cantidad);

            // Almacenamos los datos en el arreglo bidimensional de existencias
            arregloExistencias[i][0] = nombre;
            arregloExistencias[i][1] = String.valueOf(cantidad);
        }

        // Listas finales solicitadas en la guía (Nombre, identificación y cantidad)
        System.out.println("\n==================================================");
        System.out.println("     LISTA DE EXISTENCIAS - OLIVANDERS            ");
        System.out.println("==================================================");
        System.out.println(String.format("%-20s | %-15s | %-10s", "NOMBRE PRODUCTO", "IDENTIFICACIÓN", "CANTIDAD"));
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%-20s | %-15s | %-10s", 
                arregloProductos[i].getNombre(), 
                arregloProductos[i].getId(), 
                arregloExistencias[i][1]));
        }
        System.out.println("==================================================");

        scanner.close();
    }
}