import java.io.Serializable;

public class PR132persona implements Serializable {
    String nom;
    String cognom;
    int edat;

    PR132persona (String nom, String cognom, Integer edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    @Override
    public String toString () {
        return "Nom: " + this.nom + ", Cognom: " + this.cognom + ", Edat: " + this.edat;
    }
}
