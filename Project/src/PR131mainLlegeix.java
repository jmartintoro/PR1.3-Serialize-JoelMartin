import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PR131mainLlegeix {
    public static void main(String args[] ){
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR130persones.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                while(true) {
                    PR131hashmap obj = (PR131hashmap) ois.readObject();
                    System.out.println(obj);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) { e.printStackTrace(); }

            ois.close();
            fis.close();

        } catch (IOException e) { e.printStackTrace(); }

    }
}
