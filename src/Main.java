import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = "numbers.txt";
        ArrayList<String> inputList = parseInputData(nameFile);
        ArrayList<Double> numderList = convertIntoNumber(inputList);

        double sum = 0;
        for (Double d : numderList)
            sum += d;

        System.out.println("Sum: " + sum);
    }

    private static ArrayList<Double> convertIntoNumber(ArrayList<String> inputList) {
        ArrayList<Double> resultList = new ArrayList<>();
        for (String line : inputList) {
            try {
                double value = Double.parseDouble(line);
                resultList.add(value);
            } catch (NumberFormatException e) {
                // do nothing
            }
        }
        return resultList;
    }

    private static ArrayList<String> parseInputData(String nameFile) throws IOException {
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<String>();
        String str;

        try {
            reader = new BufferedReader(new FileReader("numbers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        return list;
    }
}