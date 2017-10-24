package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.*;

public class Part2 {
    private static String RAW_DATA = "part2.txt";
    private static String SORTED_DATA = "part2_sorted.txt";
    private static final int N = 10;
    private static int[] randomArr = new int[N];
    private static int[] sortedArr = new int[N];
    private static BufferedReader bufReader;
    private static BufferedWriter bufWriter;

    private static int random(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static String randomArray() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            randomArr[i] = random(0, 50);
            stringBuilder.append(randomArr[i]).append(" ");
        }
        randomArr[N - 1] = random(0, 50);
        stringBuilder.append(randomArr[N - 1]);
        return stringBuilder.toString();
    }

    private static String sortArray(int[] rawArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < N; i++) {
            sortedArr[i] = rawArray[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (sortedArr[j - 1] > sortedArr[j]) {
                    temp = sortedArr[j - 1];
                    sortedArr[j - 1] = sortedArr[j];
                    sortedArr[j] = temp;
                }
            }
        }
        for (int i = 0; i < N - 1; i++) {
            stringBuilder.append(sortedArr[i]).append(" ");
        }
        stringBuilder.append(sortedArr[N - 1]);
        return stringBuilder.toString();
    }

    public static int[] readData(String path) throws IOException {
        bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "CP1251"));
        StringBuilder lineBuf = new StringBuilder();
        String line;
        while ((line = bufReader.readLine()) != null) {
            System.out.println(line);
            if (line != null) lineBuf.append(line);
        }
        bufReader.close();
        String[] stringNum = (lineBuf.toString()).split(" ");
        int index = 0;
        int[] array = new int[10];
        for (String str : stringNum) {
            array[index] = Integer.valueOf(str);
            index++;
        }
        return array;
    }

    public static void writeData(String path, String rawArray) throws IOException {
        bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, false), "CP1251"));
        bufWriter.write(rawArray);
        bufWriter.close();
    }

    public static void main(String[] args) throws IOException {
        writeData(RAW_DATA, randomArray());
        System.out.print("input ==> ");
        int[] rawArray = readData(RAW_DATA);
        writeData(SORTED_DATA, sortArray(rawArray));
        System.out.print("output ==> ");
        int[] sortArray = readData(SORTED_DATA);
    }
}

