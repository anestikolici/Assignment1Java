import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Assignment1main {

    //owid-covid-data.csv min 5 ndpc date

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command with format: <filename> <stat> <limit> <by> <display>");

        String filename=scanner.next();
        String stat=scanner.next();
        String limit=scanner.next();
        String by=scanner.next();
        String display=scanner.next();

        generateData(filename,stat, Integer.parseInt(limit), by, display);

    }

    public static void generateData(String filePath, String stat, int limit, String by, String display) throws IOException {


        List<String> fileData = Files.readAllLines(Path.of(filePath));

        List<List<String>> fdFixed = fileData.stream().skip(1).map(x -> Arrays.asList(x.split(",", -1)))
                .collect(Collectors.toList());;


        Map<String,CovidData> mapData = new HashMap<>();

        fdFixed.forEach((x)-> mapData.put(x.get(0)+x.get(3), new CovidData(x.get(0), x.get(1), x.get(2), x.get(3), x.get(4), x.get(5), x.get(6),
                x.get(7), x.get(8), x.get(9), x.get(16), x.get(25), x.get(26), x.get(47), x.get(48), x.get(50) )));


        if(stat.equals("max")){

            mapData.values().stream()
                    .filter(x->!x.getContinent().equals(""))
                    .sorted(Comparator.comparingDouble((CovidData x)->x.getBy(by)).reversed())
                    .limit(limit)
                    .forEach(x->System.out.println(x.getDisplay(display)));

        }
        else if(stat.equals("min")){
            mapData.values().stream()
                    .filter(x->!x.getContinent().equals(""))
                    .sorted(Comparator.comparingDouble((CovidData x)->x.getBy(by)))
                    .limit(limit)
                    .forEach(x->System.out.println(x.getDisplay(display)));

        }
        else{
            System.out.println("Invalid STAT input");
        }

    }


}



