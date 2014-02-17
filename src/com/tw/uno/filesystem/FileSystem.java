package com.tw.uno.filesystem;

import java.io.*;

public class FileSystem {
    public String readFile(String file){
        String currentLine,text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((currentLine = br.readLine()) != null) {
                text += currentLine+ "\n";
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        text = text.substring(0 , text.length()-1);
        return text;
    }
    public void writeFile(String data , String fileNmae){
        try{
            File file = new File(fileNmae);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}