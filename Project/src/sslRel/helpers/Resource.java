package sslRel.helpers;

import sun.misc.Regexp;

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
}