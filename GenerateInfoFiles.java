import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateInfoFiles {

    // Método para crear el archivo de ventas para un vendedor
    public static void createSalesMenFile(List<String[]> salesData, String name, int id) {
        // Nombre del archivo
        String filename = name + "_" + id + "_sales.csv";
        try (FileWriter writer = new FileWriter(filename)) {
            // Escribir la cabecera del archivo CSV
            writer.append("TipoDocumentoVendedor,NúmeroDocumento\n");
            // Escribir datos de ventas en el archivo
            for (String[] sale : salesData) {
                writer.append("cedula;" + id + "," + sale[0] + ";" + sale[1] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para crear el archivo de información de productos
    public static void createProductsFile(List<String[]> productsData) {
        try (FileWriter writer = new FileWriter("products_info.csv")) {
            // Escribir la cabecera del archivo CSV
            writer.append("IDProducto,NombreProducto,PrecioPorUnidad\n");
            // Escribir datos de productos en el archivo
            for (String[] product : productsData) {
                writer.append("IDProducto" + product[0] + "," + product[1] + "," + product[2] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para crear el archivo de información de vendedores
    public static void createSalesManInfoFile(List<String[]> salesmenData) {
        try (FileWriter writer = new FileWriter("salesmen_info.csv")) {
            // Escribir la cabecera del archivo CSV
            writer.append("TipoDocumento,NúmeroDocumento,NombresApellidos\n");
            // Escribir datos de vendedores en el archivo
            for (String[] salesman : salesmenData) {
                writer.append("Cedula," + salesman[0] + "," + salesman[1] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método principal (main)
    public static void main(String[] args) {
        // Datos de muestra
        List<String[]> salesData = List.of(new String[]{"1", "10"}, new String[]{"2", "5"}, new String[]{"3", "8"});
        List<String[]> productsData = List.of(new String[]{"1", "Reloj", "10.99"}, new String[]{"2", "Collar", "20.99"}, new String[]{"3", "Anillo", "15.99"});
        List<String[]> salesmenData = List.of(new String[]{"1", "Tatiana Rua"}, new String[]{"2", "David Rodriguez"}, new String[]{"3", "Miguel Rodriguez"});

        // Generar archivos de muestra
        createSalesMenFile(salesData, "Tatiana_Rua", 1);
        createProductsFile(productsData);
        createSalesManInfoFile(salesmenData);
    }
}
