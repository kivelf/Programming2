package ex5;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("Enter a path:");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        File directory = new File(path);
        // display the size
        System.out.println("Size: " + getSize(directory) + " bytes");
    }

    public static long getSize(File directory){
        long size = 0;  // stores the total size of all files
        Queue<File> q = new LinkedList<>(); // create a queue for the directories

        q.offer(directory);     //adding the initial directory to the queue

        while (q.size() > 0){
            File current = q.remove();    // removes the front directory/file from the queue

            if(current.isDirectory()){
                File[] files = current.listFiles();
                if (files != null && files.length > 0){
                    for (File f : files){
                        q.offer(f);     // adding files and subdirectories to the queue
                    }
                }
            } else {
                size += current.length();   // it's a file so we're adding its size to the total
            }
        }
        return size;
    }
}
