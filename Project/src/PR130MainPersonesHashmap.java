import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PR130MainPersonesHashmap {
    
    public static void main(String args[]) {
        
        HashMap<String, Integer> dades = new HashMap<String, Integer>();
        dades.put("Pepito Grillo", 33);
        dades.put("Leo Messi", 35);
        dades.put("Jose Hernandez", 23);
        dades.put("Maria Lopez", 20);
        dades.put("Peter Pan", 27);

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
            DataOutputStream dos = new DataOutputStream(fos);
            for (Map.Entry<String,Integer> d : dades.entrySet()) {
                dos.writeUTF(d.getKey());
                dos.writeInt(d.getValue());
            }

            dos.flush();
            dos.close();
            fos.close();

            System.out.println("Write Done");

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }

        try {
            FileInputStream fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);

            try {
                while(true) {
                    String clave = dis.readUTF();
                    Integer valor = dis.readInt();
                    System.out.println("Nom: " + clave + ", edat: " + valor);
                }
            } catch (IOException e) { 
                System.out.println("Read Done");
            }

            dis.close();
            fis.close();

        } catch (IOException e) { 
            e.printStackTrace(); 
        }


        
    }

}
