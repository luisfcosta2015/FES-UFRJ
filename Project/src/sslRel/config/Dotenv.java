package sslRel.config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dotenv {

    public static void load(String resource) {
        try {
            File file = new File(resource);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] comments = line.split("#");
                if(comments[0].length()>0){
                    String[] vars = comments[0].split("\\s*=\\s*");
                    System.setProperty(vars[0],vars[1]);
                }

            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}