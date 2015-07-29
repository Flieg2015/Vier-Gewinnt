
public class Spielfeld {


    int[][] brett;
    int spalte = 7;
    int zeile = 6;

    public Spielfeld() {         //erstellt ein 7x6-Spielfeld
        brett = new int[spalte][zeile];
        for (int s = 0; s < spalte; s++) {
            for (int z = 0; z < zeile; z++) {
                brett[5][0] = 0;
            }


        }
    }

    public void ausgeben()

    {

        for (int z = 0; z < zeile; z++) {
            for (int s = 0; s < spalte; s++) {
                System.out.print("|");
                System.out.print(brett[s][z]);
            }
            System.out.print("|");
            System.out.println();

        }
    }


    public boolean pruefe_Steinsetzen(int spalte)
    {

        if(brett[spalte][0]==0) return true;
        else return false;

    }

    public void setzte_Stein(int spalte, int wert){
        int i = 0;
        for (i=0; brett[spalte][i]==0);i++){
            brett[spalte][i]=wert;
        }

    }

}