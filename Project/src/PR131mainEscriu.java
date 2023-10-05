import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PR131mainEscriu {
    
    public static void main(String args[]) {

        PR131hashmap persones = new PR131hashmap();
        persones.addHashMap("Pepito Grillo", 33);
        persones.addHashMap("Leo Messi", 35);
        persones.addHashMap("Jose Hernandez", 23);
        persones.addHashMap("Maria Lopez", 20);
        persones.addHashMap("Peter Pan", 27);
        
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
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(persones);

            oos.close();
            fos.close();

        } catch (IOException e) { e.printStackTrace(); }
    }
}
