import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MineSweeperPlayer {

    private String name;

    public MineSweeperPlayer(String name) {
        this.name = name;

    }

    public String getName(){
        return name;
    }

    public void savePlayer(MineSweeperPlayer player) {
        String name = player.getName();
        //boolean found = false;

        try {
            File f = new File("src/MSPlayer.data");
            f.createNewFile();
            /*Scanner s = new Scanner(f);
            int line = 1;
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (data.equals(name)) {
                    found = true;
                }
                line++;
            }
            s.close();*/
            FileWriter fw = new FileWriter("src/MSPlayer.data");
            /*if (!found){
                fw.write(name + "\n");
            }*/
            fw.write(name + "\n");
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

}
