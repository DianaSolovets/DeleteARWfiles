package com.company;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "C:\\Users\\diana_solovets\\Desktop\\NICE";
        File folder = new File(path);
        File[] folderFiles = folder.listFiles();
        List<File> arwFiles = new ArrayList<File>();
        List<File> jpgFiles = new ArrayList<File>();
        List<String> arrArwFiles = new ArrayList<String>();
        List<String> arrJpgFiles = new ArrayList<String>();
        String delete = "";

        for (File file : folderFiles) {
            if (file.getName().endsWith(".JPG")) {
                jpgFiles.add(file);
            } else if (file.getName().endsWith(".ARW")) {
                arwFiles.add(file);
            } else
                System.out.println("В папке есть не только ARW и JPG.");
        }

        for (File a : arwFiles){
            String e = a.getName().replace(path, "").split("\\.")[0];
            arrArwFiles.add(e);
        }

        for (File j : jpgFiles){
            String e = j.getName().replace(path, "").split("\\.")[0];
            arrJpgFiles.add(e);
        }

        for (String f: arrArwFiles) {
            if (!arrJpgFiles.contains(f)) {
                delete = path + "\\" + f + ".ARW";
                File fileDelete = new File(delete);
                fileDelete.delete();
            }
        }
    }
}
