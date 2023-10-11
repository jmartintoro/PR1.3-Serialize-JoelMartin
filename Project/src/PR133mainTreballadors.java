import java.io.File;
import java.util.List;

public class PR133mainTreballadors {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "Arxiu.csv";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        List<String> csv = UtilsCSV.read(filePath);
    }
}
