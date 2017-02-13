package com.samples.io;
/**
 * Java IO write file
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class JavaIOWriteFile {
	
	public static void main(String[] args) throws IOException {
        String Path="Files";
        File file=new File("Files","IOWriteTest.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * Java写入文件的三种方法
         * */
        FileOutputStream fos=null;
        BufferedWriter bw=null;
        FileWriter fw=null;
        int value=1000;
        
        try {
        	//write binary data
            fos=new FileOutputStream(new File(Path+"/"+"fos.txt"));
            long begin=System.currentTimeMillis();
            for (int i=1; i<=value; i++) {
                fos.write(5);
            }
            long end=System.currentTimeMillis();
            System.out.println("TheCostTime of FileOutputStream is : " + (end-begin));
            fos.close();
            
            //write data to buffer
            //OutputStreamWriter is the bridge between BufferedWriter and FileOutputStream
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(Path+"/"+"br.txt")),"UTF8"));
            begin=System.currentTimeMillis();
            for (int i=1; i<=value; i++) {
                bw.write(5);
                bw.newLine();
            }
            bw.close();
            end=System.currentTimeMillis();
            System.out.println("TheCostTime of BufferedWriter is : " + (end-begin));
            
            //write character
            fw=new FileWriter(Path+"/"+"fw.txt");
            begin=System.currentTimeMillis();
            for (int i=1; i<=value; i++) {
                fw.write(5);                
            }
            fw.close();
            end=System.currentTimeMillis();
            System.out.println("TheCostTime of FileWriter is : " + (end-begin));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close(); //FileOutputStream
                bw.close(); //BufferedWriter
                fw.close(); //FileWriter
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
