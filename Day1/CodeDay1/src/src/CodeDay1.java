package src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CodeDay1 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    static int max = 0;

    public static void part1() {
        try {
            File myObj = new File("/Users/yiyehuang/Desktop/myWorkspace/adventofcode-2022/Day1/CodeDay1/src/src/input.txt");
            Scanner myReader = new Scanner(myObj);
            int localMax = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    int cal = Integer.parseInt(data);
                    localMax+=cal;
                } catch (Exception ex) {
                    if (localMax > max) {
                        max = localMax;
                    }
                    localMax = 0;
                }
            }
            System.out.println("Max: " + max);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static PriorityQueue<Integer> queue = new PriorityQueue<>(3);
    public static void part2() {
        try {
            File myObj = new File("/Users/yiyehuang/Desktop/myWorkspace/adventofcode-2022/Day1/CodeDay1/src/src/input.txt");
            Scanner myReader = new Scanner(myObj);
            int localMax = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    int cal = Integer.parseInt(data);
                    localMax+=cal;
                } catch (Exception ex) {
                    if (queue.size() < 3) {
                        queue.add(localMax);
                    } else {
                        queue.poll();
                        queue.add(localMax);
                    }
                    localMax = 0;
                }
            }

            while (!queue.isEmpty()) {
                System.out.println("max: " + queue.poll());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
