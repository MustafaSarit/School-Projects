import java.io.*;
import java.util.Random;

public class MLP {

    private double Epochs       = 1000;
    private double LearningRate = 1e-3;
    private double Momentum     = 0.9;
    private double Lambda       = 0.0;
    private double Epsilon      = 1e-3;

    private int nLayers;
    class aLayer {
        int n;
        double out[], theta[];
        double delta[][], weight[][];
    }
    aLayer Layer[];

    private double Expected[];

    private Random generator = new Random();

    private BufferedInputStream FileInput;

    private int randomInt(int number){
        return generator.nextInt(number);
    }

    private void initMemory(int nLayers){
        this.nLayers = nLayers;
        Layer = new aLayer[this.nLayers];
        for (int i = 0; i < this.nLayers; i++)
            Layer[i] = new aLayer();
    }

    private void initCoefficient(){
        Expected = new double [Layer[nLayers - 1].n];

        for (int i = 0; i < nLayers; i++){
            if (i != 0)
                Layer[i].theta = new double [Layer[i].n];

            Layer[i].out = new double [Layer[i].n];

            if (i != nLayers - 1){
                Layer[i].weight = new double [Layer[i].n][Layer[i + 1].n];
                Layer[i].delta = new double [Layer[i].n][Layer[i + 1].n];
            }
        }

        for (int i = 0; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++)
                for (int v = 0; v < Layer[i + 1].n; v++){
                    Layer[i].weight[j][v] = (double)(randomInt(10)) / (10.0 * Layer[i + 1].n);
                    int t = randomInt(2);
                    if (t == 1) Layer[i].weight[j][v] = - Layer[i].weight[j][v];
                }
    }

    public MLP(int InputLayer, int OutputLayer){
        initMemory(2);

        Layer[0].n = InputLayer;
        Layer[1].n = OutputLayer;

        initCoefficient();
    }


    public MLP(int InputLayer, int HiddenLayer, int OutputLayer){
        initMemory(3);

        Layer[0].n = InputLayer;
        Layer[1].n = HiddenLayer;
        Layer[2].n = OutputLayer;

        initCoefficient();
    }

    public MLP(int InputLayer, int HiddenLayer1, int HiddenLayer2, int OutputLayer){
        initMemory(4);

        Layer[0].n = InputLayer;
        Layer[1].n = HiddenLayer1;
        Layer[2].n = HiddenLayer2;
        Layer[3].n = OutputLayer;

        initCoefficient();
    }

    public MLP(int InputLayer, int HiddenLayer1, int HiddenLayer2, int HiddenLayer3, int OutputLayer){
        initMemory(5);

        Layer[0].n = InputLayer;
        Layer[1].n = HiddenLayer1;
        Layer[2].n = HiddenLayer2;
        Layer[3].n = HiddenLayer3;
        Layer[4].n = OutputLayer;

        initCoefficient();
    }

    private double readDouble() throws IOException {
        String str = "";

        while (true){
            int aByte = FileInput.read();
            char aChar = (char)(aByte);
            if (aChar != ' '){
                str += aChar;
                break;
            }
        }

        while (true){
            int aByte = FileInput.read();
            if (aByte == -1) break;
            char aChar = (char)(aByte);
            if (aChar == ' ') break;
            str += aChar;
        }

        return Double.parseDouble(str);
    }

    public void setWeights(String FileName) throws IOException {
        FileInput = new BufferedInputStream (new FileInputStream(FileName));

        for (int i = 0; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++)
                for (int v = 0; v < Layer[i + 1].n; v++)
                    Layer[i].weight[j][v] = readDouble();

        FileInput.close();
    }

    public void setMomentum(double value){
        Momentum = value;
    }

    public void setEpochs(int value){
        Epochs = value;
    }

    public void setLearningRate(double value){
        LearningRate = value;
    }

    public void setRegularizationParameter(double value){
        Lambda = value;
    }

    public void setEpsilon(double value){
        Epsilon = value;
    }

    public void writeWeights(String FileName) throws IOException {
        FileWriter FileOutput = new FileWriter(FileName);
        PrintWriter Writer = new PrintWriter(FileOutput);

        for (int i = 0; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++)
                for (int v = 0; v < Layer[i + 1].n; v++)
                    Writer.print(Layer[i].weight[j][v] + " ");

        Writer.close();
    }

    private double Sigmoid(double x){
        return 1.0 / (1.0 + Math.exp(-x));
    }

    private void Perceptron(){
        for (int i = 1; i < nLayers; i++)
            for (int j = 0; j < Layer[i].n; j++){
                double net = 0.0;
                for (int v = 0; v < Layer[i - 1].n; v++)
                    net += Layer[i - 1].out[v] * Layer[i - 1].weight[v][j];
                Layer[i].out[j] = Sigmoid(net);
            }
    }

    private double SquareError(){
        double res = 0.0;

        for (int i = 0; i < Layer[nLayers - 1].n; i++){
            double diff = Expected[i] - Layer[nLayers - 1].out[i];
            res += 0.5 * diff * diff;
        }

        return res;
    }

    private void initGradients(){
        for (int i = 0; i < Layer[nLayers - 1].n; i++){
            double out = Layer[nLayers - 1].out[i];
            Layer[nLayers - 1].theta[i] = out * (1 - out) * (Expected[i] - out);
        }

        for (int i = 1; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++){
                double sum = 0.0;
                for (int v = 0; v < Layer[i + 1].n; v++)
                    sum += Layer[i + 1].theta[v] * Layer[i].weight[j][v];
                double out = Layer[i].out[j];
                Layer[i].theta[j] = out * (1 - out) * sum;
            }
    }

    private void StochasticBackPropagation(){
        initGradients();

        for (int i = 0; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++)
                for (int v = 0; v < Layer[i + 1].n; v++){
                    double delta = Layer[i].delta[j][v];
                    double out = Layer[i].out[j];
                    double theta = Layer[i + 1].theta[v];

                    Layer[i].delta[j][v] = LearningRate * theta * out + Momentum * delta;
                    Layer[i].weight[j][v] += Layer[i].delta[j][v];
                }
    }

    public double StochasticLearning(double Input[], double ExpectedOutput[]){
        for (int i = 0; i < Layer[0].n; i++)
            Layer[0].out[i] = Input[i];

        for (int i = 0; i < Layer[nLayers - 1].n; i++)
            Expected[i] = ExpectedOutput[i];

        for (int i = 0; i < nLayers - 1; i++)
            for (int j = 0; j < Layer[i].n; j++)
                for (int v = 0; v < Layer[i + 1].n; v++)
                    Layer[i].delta[j][v] = 0.0;

        for (int iter = 0; iter < Epochs; iter++){
            Perceptron();
            StochasticBackPropagation();

            double error = SquareError();
            if (error < Epsilon)
                return error;
        }

        return SquareError();
    }

    public void Predict(double Input[], double PredictedOutput[]){
        for (int i = 0; i < Layer[0].n; i++)
            Layer[0].out[i] = Input[i];

        Perceptron();

        for (int i = 0; i < Layer[nLayers - 1].n; i++)
            PredictedOutput[i] = Layer[nLayers - 1].out[i];
    }


}