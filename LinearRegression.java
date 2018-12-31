import java.math.BigDecimal;
import java.util.Scanner;

public class LinearRegression {
    static int[] size = {1100, 1400, 1425, 1550, 1600, 1700, 1700, 1875, 2350, 2450};
    static int[] price = {199000, 245000, 319000, 240000, 312000, 279000, 310000, 308000, 405000, 324000};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float[] sizeStandard = minMaxScaling(size);                                                 //X
        float[] priceStandard = minMaxScaling(price);                                               //Y
        float cordX = 0.45f;                                                                        //a
        float cordY = 0.75f;                                                                        //b
        float[] predictLine = line(cordX, cordY, sizeStandard);                                     //yp
        float predictError = error(priceStandard, predictLine);                                     //SSE
        float gradientX = totalGradientX(priceStandard, predictLine);                               //SSE/a
        float gradientY = totalGradientY(priceStandard, predictLine, sizeStandard);                 //SSE/b
        float learnRate = 0.01f;                                                                    //r
        cordX = round(cordX - (learnRate * gradientX), 2);
        cordY = round(cordY - (learnRate * gradientY), 2);
        float[] predictLine2 = line(cordX, cordY, sizeStandard);
        float predictError2 = error(priceStandard, predictLine2);

        while (predictError2 < predictError){
            predictError = predictError2;
            predictLine = predictLine2;
            gradientX = totalGradientX(priceStandard, predictLine);
            gradientY = totalGradientY(priceStandard, predictLine, sizeStandard);
            cordX = round(cordX - (learnRate * gradientX), 2);
            cordY = round(cordY - (learnRate * gradientY), 2);
            predictLine2 = line(cordX, cordY, sizeStandard);
            predictError2 = error(priceStandard, predictLine2);
        }

        System.out.print("Enter size of house: ");
        int inputSize = scanner.nextInt();
        int outPrice = findPrice(inputSize, predictError, cordX, cordY);

        System.out.println("Predicted price is: "+ outPrice);
    }

    private static int findPrice(int inputSize, float SSE, float a, float b) {
        float standardISize = scale(inputSize);
        float YP = round(a+(b*standardISize), 2);
        float floatPrice = (float) YP;
        int price = normalize(floatPrice);
        return price;
    }

    private static int normalize(float floatPrice) {
        int max = findMax(price);
        int min = findMin(price);
        return (int) (floatPrice*(max-min) + min);
    }

    public static float scale(int inputSize) {
        int max = findMax(size);
        int min = findMin(size);
        float scaled = round((float) (inputSize - min) / (max - min), 2);
        return scaled;
    }

    public static float totalGradientX(float[] y, float[] yp){
        float total = 0;
        float[] gradx = new float[y.length];
        for(int i = 0; i < y.length; i++){
            total += round((float) -(y[i] - yp[i]), 3);
        }
        return round(total, 3);
    }

    public static float totalGradientY(float[] y, float[] yp, float[] X){
        float total = 0;
        float[] gradx = new float[y.length];
        for(int i = 0; i < y.length; i++){
            total += round( ((float) -(y[i] - yp[i])) * X[i], 3);
        }
        return round(total, 3);
    }

    public static float error(float[] y, float[] yp) {
        float total = 0;
        float[] error = new float[y.length];
        for(int i = 0; i < y.length; i++){
            total += round((float) Math.pow(y[i]-yp[i], 2) /2, 3);
        }
        return round(total, 3);
    }

    public static float[] line(float a, float b, float[] x){
        float[] line = new float[x.length];
        for (int i = 0; i < x.length; i++){
            line[i] = round(a+(b*x[i]),2);
        }
        return line;
    }

    public static float[] minMaxScaling(int[] set){
        int max = findMax(set);
        int min = findMin(set);
        float[] scaled = new float[set.length];
        for(int i = 0; i < set.length; i++){
            scaled[i] =round((float) (set[i] - min) / (max - min), 2);
        }
        return scaled;
    }

    public static int findMax(int[] set){
        int max = set[0];
        for(int i = 1; i < set.length; i++){
            if(set[i] > max) max = set[i];
        }
        return max;
    }

    public static int findMin(int[] set){
        int min = set[0];
        for(int i = 1; i < set.length; i++){
            if(set[i] < min) min = set[i];
        }
        return min;
    }

    public static float round(float number, int point) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(point, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
