import java.io.*;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

public class App {

    public static void main(String[] args) throws IOException {
        // Actividad 1
        File file = new File("AE1Ficheros.txt");
        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        long starTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            printer.println((int)(Math.random() * 100));
        }
        long endTime = System.currentTimeMillis();
        printer.println(MessageFormat.format("El proceso de escritura ha tardado {0}", (endTime - starTime)+" ms"));
        printer.close();

        // Actividad 2
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        int total = 0;
        long starTimeLectura = System.currentTimeMillis();
        try {
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
        } catch (Exception NumberFormatException) {
            System.out.println(line);
        }
        long endTimeLectura = System.currentTimeMillis();
        System.out.println(MessageFormat.format("El proceso de Lectura ha tardado {0}", (endTimeLectura - starTimeLectura)+" ms"));
        System.out.println(total);
        reader.close();
    }
}



