import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class PR131mainLlegeix {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR130persones.dat";

        // Crear la carpeta 'data' si no existe
        File dir = new File(basePath);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.out.println("Error en la creación de la carpeta 'data'");
            }
        }

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            PR131hashmap objetoDeserializado = (PR131hashmap) ois.readObject();

            HashMap<String, Integer> hashMap = objetoDeserializado.getHashMap();

            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String clave = entry.getKey();
                Integer valor = entry.getValue();
                System.out.println("Nom: " + clave + ", edat: " + valor);
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
