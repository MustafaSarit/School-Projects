

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;

public class MainProgram extends constants{

    static int width = 28;
    static int height = 28;

    static class aSample {
        public int image[][];
        public int label;
    }

    static aSample TrainingSample[];
    static aSample TestingSample[];

    public static void input(BufferedInputStream image, int Matrix[][]) throws IOException{
        int u, v;
        for (v = 0; v < height; v++)
            for (u = 0; u < width; u++)
                Matrix[u][v] = image.read();
    }

    public static int Manhattan(int Matrix1[][], int Matrix2[][]){
        int sum = 0;
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                sum += Math.abs(Matrix1[i][j] - Matrix2[i][j]);
        return sum;
    }

    public static int Euclid(int Matrix1[][], int Matrix2[][]){
        int sum = 0;
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                sum += Math.pow(Matrix1[i][j] - Matrix2[i][j], 2);
        return (int) Math.sqrt(sum);
    }

    public static void drawSample(int Matrix[][], int x0, int y0, int CellLength){
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++){
                MainCanvas.setColor(new Color(Matrix[i][j], Matrix[i][j], Matrix[i][j]));
                MainCanvas.drawRect(x0 + i * CellLength, y0 + j * CellLength, CellLength, CellLength);
            }
    }

    public static void undrawSample(int x0, int y0, int CellLength){
        MainCanvas.setColor(MainPanel.getBackground());
        MainCanvas.fillRect(x0, y0, width * CellLength + 1, height * CellLength + 1);
    }

    public static void Process() throws IOException {
        while (true){
            EventObject AnEvent = Events.waitEvent();
            String name = Events.getName(AnEvent);

            if (name.equals("Training")) new Training();

            if (name.equals("Testing")){
                Testing.count = 0;
                new Testing();
            }

        }
    }

    public static void main(String args[]) throws IOException {
        MyInterface.InitGUI();
        MyInterface.InitEventListener();
        Process();
    }

}

