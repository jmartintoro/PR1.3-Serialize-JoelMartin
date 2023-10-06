import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PR132main {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR132people.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        System.out.println("");

        try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            
            PR132persona obj0 = new PR132persona("Leo", "Messi", 35);
            PR132persona obj1 = new PR132persona("Pepito" , "Grillo", 33);
            PR132persona obj2 = new PR132persona("Jose", "Hernandez", 23);
            PR132persona obj3 = new PR132persona("Maria", "Lopez", 20);
            PR132persona obj4 = new PR132persona("Peter", "Pan", 27);

			oos.writeObject(obj0);
			oos.writeObject(obj1);
			oos.writeObject(obj2);
			oos.writeObject(obj3);
			oos.writeObject(obj4);

			oos.close();
			fos.close();

            System.out.println("Write Done");

            FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
            
            try {
                while(true){
                    PR132persona obj = (PR132persona) ois.readObject();
                    System.out.println(obj);
                }
            } catch (IOException e) { 
                System.out.println("Read Done");
            }

			ois.close();
			fis.close();

		} catch (IOException e) { e.printStackTrace(); 
        } catch (ClassNotFoundException e) { e.printStackTrace();}
    }
}
