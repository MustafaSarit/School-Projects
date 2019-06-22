import java.io.*;

public class testing_mnist {

    static String TestingImageFileName  = "C:\\Users\\Mustafa\\Desktop\\ceng3\\ai\\project4\\dataBase\\t10k-images.idx3-ubyte";
    static String TestingLabelFileName  = "C:\\Users\\Mustafa\\Desktop\\ceng3\\ai\\project4\\dataBase\\t10k-labels.idx1-ubyte";
    static String ReportFileName        = "testing-report.txt";
    static String WeightsFileName       = "MLP.dat";

    static int widthImage   = 28;
    static int heightImage  = 28;

    static int nInput   = widthImage * heightImage + 1;
    static int nHidden  = 128;
    static int nOutput  = 10;

//    static MLP myNet    = new MLP(nInput, nOutput);
  static MLP myNet    = new MLP(nInput, nHidden, nOutput);
//  static MLP myNet    = new MLP(nInput, nHidden, nHidden, nOutput);
//  static MLP myNet    = new MLP(nInput, nHidden, nHidden, nHidden, nOutput);


    static int nSamples     = 10000;
    static int image[][]    = new int [widthImage][heightImage];
    static double input[]   = new double [nInput];
    static double output[]  = new double [nOutput];

    static BufferedInputStream imageFile, labelFile;
    static PrintWriter reportFile;

    private static void getImage() throws IOException {
        for (int i = 0; i < heightImage; ++i) {
            for (int j = 0; j < widthImage; ++j) {
                image[i][j] = imageFile.read();
            }
        }
    }

    private static void getInput() throws IOException {
        getImage();

        for (int i = 0; i < heightImage; ++i) {
            for (int j = 0; j < widthImage; ++j) {
                if (image[i][j] > 0) {
                    input[j + i * widthImage] = 1.0;
                } else {
                    input[j + i * widthImage] = 0.0;
                }
            }
        }
        input[widthImage * heightImage] = 1.0; // bias
    }

    private static int getOutput(double output[]) {
        int predict = 0;
        for (int i = 1; i < nOutput; ++i) {
            if (output[i] > output[predict]) {
                predict = i;
            }
        }
        return predict;
    }

    public static void main(String args[]) throws IOException {
        imageFile   = new BufferedInputStream(new FileInputStream(TestingImageFileName));
        labelFile   = new BufferedInputStream(new FileInputStream(TestingLabelFileName));
        reportFile  = new PrintWriter(new FileWriter(ReportFileName));

        for (int i = 0; i < 16; ++i) {
            imageFile.read();
        }

        for (int i = 0; i < 8; ++i) {
            labelFile.read();
        }

        myNet.setWeights(WeightsFileName);

        int nCorrect = 0;
        for (int sample = 1; sample <= nSamples; ++sample){
            getInput();
            int label = labelFile.read();

            myNet.Predict(input, output);
            int predict = getOutput(output);

            if (label == predict) {
                ++nCorrect;
                System.out.println("Sample " + Integer.toString(sample) + ": YES");
                reportFile.println("Sample " + Integer.toString(sample) + ": YES");
            } else {
                System.out.println("Sample " + Integer.toString(sample) + ": NO");
                reportFile.println("Sample " + Integer.toString(sample) + ": NO");
            }
        }

        double percent = (double)(nCorrect) / nSamples * 100.0;

        System.out.println("Number of correct samples: " + Integer.toString(nCorrect) + " / " + Integer.toString(nSamples));
        System.out.println("Accuracy: " + Double.toString(percent));

        reportFile.println("Number of correct samples: " + Integer.toString(nCorrect) + " / " + Integer.toString(nSamples));
        reportFile.println("Accuracy: " + Double.toString(percent));

        imageFile.close();
        labelFile.close();
        reportFile.close();
    }

}
