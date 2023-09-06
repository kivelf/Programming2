package opg5;

import java.io.File;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("Enter a path:");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        scanDir(path);
    }

    public static void scanDir(String path){
        File file = new File(path);
        if (file.isDirectory()){
            System.out.println(file.getName());
            File[] files = file.listFiles();
            for (int i = 0; i < files.length && files != null; i++){
                scanDir(files[i].getPath());
            }
        } else {
            System.out.println(file.getName());
        }
    }
}
