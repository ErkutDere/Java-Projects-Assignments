package cse222map;

import java.util.Scanner;
import java.io.File;
import java.lang.Integer;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class CSE222Map {

    private int[][] map;
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;

    public CSE222Map(String InputFile, int x_length, int y_length) {
        try {
            this.map = new int[x_length][y_length];
            String folder = "cse222map/";
            File file = new File("cse222map/" + InputFile);
            Scanner scanner = new Scanner(file);
            int i = 0;
            String[] start_end = scanner.nextLine().split(",");
            this.start_x = Integer.parseInt(start_end[0]);
            this.start_y = Integer.parseInt(start_end[1]);
            String[] end = scanner.nextLine().split(",");
            this.end_x = Integer.parseInt(end[0]);
            this.end_y = Integer.parseInt(end[1]);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split(",");
                for (int j = 0; j < numbers.length; j++) {
                    this.map[i][j] = Integer.parseInt(numbers[j]);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Errormap::" + e);
        }
    }

    public int[][] getMap() {
        return this.map;
    }

    public int getStartX() {
        return this.start_x;
    }

    public int getStartY() {
        return this.start_y;
    }

    public int getEndX() {
        return this.end_x;
    }

    public int getEndY() {
        return this.end_y;
    }

    public int getMapXLength() {
        return this.map[0].length;
    }

    public int getMapYLength() {
        return this.map.length;
    }

    public void convertMapPNG(int[][] map, String outputFile) {
        int width = map[0].length;
        int height = map.length;

        // set pixels
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int pixel = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    pixel = 0xFF000000;
                    image.setRGB(i, j, pixel);
                } else {
                    pixel = 0xFFFFFFFF;
                    image.setRGB(i, j, pixel);
                }
            }
        }
        // write image to file
        try {
            File outputfile = new File(outputFile);
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}