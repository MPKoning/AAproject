import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    private File input;
    private ArrayList<Machine> machines;

    private void start(String fileName){
        input = new File(fileName);
        parse(input);
    }

    private void parse(File file){
        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                Scanner line = new Scanner(fileScanner.nextLine());
                parseLine(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void parseLine(Scanner lineScanner){
        while(lineScanner.hasNext()){
            Machine machine = new Machine(lineScanner.next(), lineScanner.next(), lineScanner.next(), lineScanner.nextInt());
            machines.add(machine);
        }
    }

    public static final void main(String argv[]) {
        new Main().start(argv[0]);
    }

    private class Machine{
        public String machineName;
        public String resourceSource;
        public String resoruceDestination;
        public int cost;
        Machine(String name, String source, String dest, int cost){
            machineName = name.substring(1, name.length());
            resourceSource = source;
            resoruceDestination = dest;
            this.cost = cost;
        }
    }

}
