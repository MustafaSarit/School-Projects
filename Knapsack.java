import java.io.*;
import java.util.Random;
import java.util.Scanner;

/****************************************************************************************************
* Input file have to be in this format: 															*
*	First line	: price of items seperated with space.						10 20 30 40 50			*
*	Second line	: weight of items seperated with space.						10 20 30 40 50			*
*	Third line	: capacity of the knapsack.									10						*
*																									*
* First input taken from console is the path of input document.										*
* Rest of the remaining inputs taken from console are integers so inputs have to be integers.		*
* Output will be the fittest of the all created individuals.										*
* However there is an output option that you can see fittest of all populations.					*
* Second output option is not recommended on big populations										*
*****************************************************************************************************/


public class Knapsack {

    static int[] price;                 // Prices from text file
    static int[] weight;                // Weights from text file
    static int knapsack;                // Capacity of knapsack
    static  int position = 0;

    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);
        String path;
        int popul,                          // Size of initial population
                numge,                      // Number of generation (iteration)
                cprob,                      // Crossover probability
                mprob,                      // Mutation probability
                crosp;                      // Crossover point


        System.out.print("Write the path of text document: ");
        path = input.next();
        System.out.print("Enter Size of population: ");
        popul = input.nextInt();
        System.out.print("Enter Number of generation(Bigger number means optimal result but will take long time): ");
        numge = input.nextInt();
        System.out.print("Enter Crossover probability(Between 0-100): ");
        cprob = input.nextInt();
        System.out.print("Enter Mutation probability(Between 0-100): ");
        mprob = input.nextInt();

        price = getPrice(path);
        weight = getWeight(path);
        knapsack = getKnapsack(path);

        int[][] cpopl = new int[popul][price.length];                       // populations chromosomes
        int[] fitsc = new int[popul];                                       // Initial populations fitness scores
        int[][] fittest = new int[numge + 1][price.length];                 // Fittest of the all populations


        System.out.print("Choose Crossover point between 1-" + (price.length-1)+ ": ");
        crosp = input.nextInt();

        for(int i = 0; i < popul; i++){
            cpopl[i] = chromosomeMaker();
            fitsc[i] = fitness(cpopl[i]);
        }
        fittest[position] = cpopl[getFittestPosition(fitsc)];
        position += 1;

        for(int i = 0; i < numge; i++){
            int[][] newgen = new int[popul][price.length];
            newgen[0] = fittest[i];
            for(int j = 1; j < popul; j++){
                int[] child1;
                int[] child2;
                do{
                    int[] parent1 = cpopl[selectParents(fitsc)];
                    int[] parent2 = cpopl[selectParents(fitsc)];
                    if(Prob(cprob)){
                        child1 = crossover1(parent1, parent2, crosp, mprob);
                        child2 = crossover2(parent1, parent2, crosp, mprob);
                    }else{
                        child1 = parent1;
                        child2 = parent2;
                    }
                }while(!(selection(child1) || selection(child2)));
                if(child1 != null && child2 != null){
                    newgen[j] = child1;
                    j += 1;
                    if(j != popul)
                        newgen[j] = child2;
                }else if (child1 != null) newgen[j] = child1;
                else if (child2 != null) newgen[j] = child2;
            }
            cpopl = newgen;
            fittest[position] = cpopl[getFittestPosition(fitsc)];
            position += 1;
        }
        int best[] = new int[fittest.length];
        for(int i = 0; i < popul; i++){
            best[i] = fitness(fittest[i]);
        }

        for (int i = 0; i < price.length; i++){
            System.out.print(price[i]+ "\t");
        }
        System.out.println("Prices");
        for (int i = 0; i < price.length; i++){
            System.out.print(fittest[getFittestPosition(best)][i]+"\t");
        }
        System.out.println("Total Price: " + price(fittest[getFittestPosition(best)]) + " Weight: " + weight(fittest[getFittestPosition(best)])+ " Knapsack Capacity: " + knapsack);
        for (int i = 0; i < price.length; i++){
            System.out.print(weight[i]+ "\t");
        }
        System.out.println("Weights");


        /*for(int i = 0; i < fittest.length; i++){                  //prints all possible solutions
            for (int j = 0; j < price.length; j++){
                if(j == price.length-1) System.out.print(fittest[i][j]+" ");
                System.out.print(fittest[i][j]+", ");
            }
            System.out.println("Total price: " + price(fittest[i]) + " Weight: " + weight(fittest[i]));
        }*/


    }

    private static int price(int[] chro){
        int total = 0;
        for(int i = 0; i < chro.length; i++){
            total += chro[i] * price[i];
        }
        return total;
    }

    private static int weight(int[] chro){
        int total = 0;
        for(int i = 0; i < chro.length; i++){
            total += chro[i] * weight[i];
        }
        return total;
    }

    private static int[] crossover1(int[] parent1, int[] parent2, int crosp, int mprob){
        int[] child = new int[parent1.length];
        for(int i = 0; i < parent1.length; i++){
            if(i < crosp){
                child[i] = parent1[i];
            }else{
                child[i] = parent2[i];
            }
        }
        if(Prob(mprob)){
            child = Mutation(child);
        }
        if(!selection(child)) child = null;
        return child;
    }
    
	private static int[] crossover2(int[] parent1, int[] parent2, int crosp, int mprob){
        int[] child = new int[parent1.length];
        for(int i = 0; i < parent1.length; i++){
            if(i < crosp){
                child[i] = parent2[i];
            }else{
                child[i] = parent1[i];
            }
        }
        if(Prob(mprob)){
            child = Mutation(child);
        }
        if(!selection(child)) child = null;
        return child;
    }

    private static int[] Mutation(int[] child){
        for(int i = 0; i < child.length; i++){
            if(child[i] == 0) child[i] = 1;
            else child[i] = 0;
        }
        return child;
    }

    private static boolean Prob(int prob){
        Random random = new Random();
        if(random.nextInt(100)+1 <= prob) return true;
        return false;
    }

    private static int selectParents(int[] fitsc){
        int totalfit = 0;
        Random random = new Random();
        for (int i = 0; i < fitsc.length; i++){
            totalfit += fitsc[i];
        }
        int rand = random.nextInt(totalfit) + 1;
        totalfit = 0;
        for (int i = 0; i < fitsc.length; i++){
            totalfit += fitsc[i];
            if (rand <= totalfit) return i;
        }

        return 0;
    }

    private static int getFittestPosition(int[] fitsc){
        int score = 0;
        int posit = 0;
        for(int i = 0; i < fitsc.length; i++){
            if(fitsc[i] > score){
                score = fitsc[i];
                posit = i;
            }
        }
        return posit;
    }

    //Create random chromosomes for initial population
    private static int[] chromosomeMaker(){
        Random rand = new Random();
        int[] chromosome = new int[price.length];
        do{
            for(int i = 0; i < chromosome.length; i++){
                chromosome[i] = rand.nextInt(2);
            }
        }while (!selection(chromosome));
        return chromosome;
    }

    //Calculate fitness score of the chromosome
    private static int fitness(int[] chromosome){
        int total = 0;
        int weigh = 0;
        for(int i = 0; i<chromosome.length; i++){
            total += chromosome[i] * price[i];
            //weigh += chromosome[i] * weight[i];
        }
        //if(weigh == 0) return 0;
        return total;//    /weigh;
    }

    //Decide if the chromosome will match with conditions
    private static boolean selection(int[] chromosome){
        if(chromosome == null) return false;
        int total = 0;
        for(int i = 0; i<chromosome.length; i++){
            total += chromosome[i] * weight[i];
        }
        if (total <= knapsack){
            return true;}
        return false;
    }

    //Reads weight of items
    private static int[] getWeight(String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();
        st = br.readLine();
        int length = st.split(" ").length;
        int[] weight = new int[length];
        String[] string = st.split(" ");
        for (int j = 0; j < length; j++){
            weight[j] = Integer.parseInt(string[j]);
        }
        return weight;
    }

    //Reads weight of knapsack's weight from text file
    private static int getKnapsack(String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        br.readLine();
        return Integer.parseInt(br.readLine());
    }

    //Reads price of items from text file
    private static int[] getPrice(String path) throws Exception {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();

        int length = st.split(" ").length;
        int[] price = new int[length];
        String[] string = st.split(" ");
        for (int j = 0; j < length; j++){
            price[j] = Integer.parseInt(string[j]);
        }
        return price;
    }

}