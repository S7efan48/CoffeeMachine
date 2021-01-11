import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try{
            File myFile = new File("C:\\Users\\40732\\IdeaProjects\\CoffeeMachine\\src\\fileoutput.txt");
            if (myFile.createNewFile()){
                System.out.println("Fisier creat");
            }
        }
        catch (IOException e){
            System.out.println("A aparut o eroare");
            e.printStackTrace();
        }
    }
}

class WriteFile{
    public static void main(String[] args) {
        try {
            FileWriter writeFile = new FileWriter("C:\\Users\\40732\\IdeaProjects\\CoffeeMachine\\src\\fileoutput.txt");
            writeFile.write("Write action (buy, fill, take, remaining, exit: ");
            writeFile.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
