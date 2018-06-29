package sslRel.helpers;

import sun.misc.Regexp;

import javax.servlet.http.Part;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resource
{
    public ArrayList<File> files = new ArrayList<>();
    public ArrayList<File> directories = new ArrayList<>();

    private void _findResource(File root,String regex,boolean recursive){
        File[] listOfFiles = root.listFiles();
        if(listOfFiles!=null){
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String fileName = listOfFiles[i].getName();
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(fileName);
                    if (m.find()) files.add(listOfFiles[i]);
                } else if (listOfFiles[i].isDirectory()) {
                    this.directories.add(listOfFiles[i]);
                    if(recursive)this._findResource(listOfFiles[i],regex,true);
                }
            }
        }
    }
    public void findResource(File root,String regex,boolean recursive){
        this.files.clear();
        this.directories.clear();
        this._findResource(root,regex,recursive);
    }
    public static String getFileContent(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String         line;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");
        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }


    public static boolean setFileContent(String path, Part part) throws IOException{
        FileOutputStream out = null;
        InputStream fileContent = null;
        try {
            out = new FileOutputStream(new File(path));
            fileContent = part.getInputStream();
            int size = fileContent.available();
            int read = 0;
            final byte[] bytes = new byte[size];
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            return true;
        } catch (FileNotFoundException fne) {
            return false;
        } finally {
            if (out != null) {
                out.close();
            }
            if (fileContent != null) {
                fileContent.close();
            }
        }
    }

    public static void setFileContent(File file,String content) throws IOException{
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i] ));
                if (!success) {
                    return false;
                }
            }
        }

        // The directory is now empty so delete it
        return dir.delete();
    }
}