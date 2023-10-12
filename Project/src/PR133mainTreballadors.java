import java.io.*;
import java.util.Scanner;

public class PR133mainTreballadors {
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "PR133treballadors.csv";
        String filePath = basePath + fileName;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introdueix l'identificador del treballador: ");
        String id = sc.nextLine();

        System.out.print("Quina data vols modificar (nom, cognom, departament, salari)? ");
        String datoAModificar = sc.nextLine();

        System.out.print("Introdueix el nou valor: ");
        String nuevoValor = sc.nextLine();

        boolean modificado = modificarDato(filePath, id, datoAModificar, nuevoValor);

        if (modificado) {
            System.out.println("Dada modifacada correctament.");
        } else {
            System.out.println("No s'ha trobat el treballador.");
        }
    }

    public static boolean modificarDato(String filePath, String id, String datoAModificar, String nuevoValor) {
        try {
            File archivo = new File(filePath);
            File archivoTemporal = new File("temporal.csv");

            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;
            boolean modificado = false;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5 && partes[0].equals(id)) {
                    // Modificar el valor deseado
                    if (datoAModificar.equals("nom")) {
                        partes[1] = nuevoValor;
                    } else if (datoAModificar.equals("cognom")) {
                        partes[2] = nuevoValor;
                    } else if (datoAModificar.equals("departament")) {
                        partes[3] = nuevoValor;
                    } else if (datoAModificar.equals("salari")) {
                        partes[4] = nuevoValor;
                    }
                    modificado = true;
                }
                writer.write(String.join(",", partes) + "\n");
            }

            reader.close();
            writer.close();

            // Reemplazar el archivo original con el archivo temporal
            if (modificado) {
                archivo.delete();
                archivoTemporal.renameTo(archivo);
            } else {
                archivoTemporal.delete();
            }

            return modificado;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
