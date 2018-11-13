package nauka.training.core.inOut;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileExerciseEx1 {
    public static void main(String[] args) throws IOException {
        Scanner skaner = new Scanner(System.in);
        String path = null;
        System.out.println("Podaj ścieżkę i nazwę pliku: ");
        FileWriter fileWriter = null;
        path = skaner.nextLine();
        if (path != null){
            String linia = null;
            fileWriter = new FileWriter(path);
            do {
                try{
                    System.out.println("Podaj dane do zapisania w linii - \"-\" aby zakończyć!");
                    linia = skaner.nextLine();
                    fileWriter.write(linia);
                    fileWriter.write(System.lineSeparator());
                } catch (IOException ex){
                    System.out.println("Błąd! Problem z dostepem do pliku!");
                    fileWriter.close();
                } finally {
                    fileWriter.close();
                    skaner.close();
                }
            } while (linia != "-");
        }


    }

}