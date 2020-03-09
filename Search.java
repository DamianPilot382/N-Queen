/**
 * @author Damian Ugalde
 * @date 2020-03-08
 * @version 1.0
 *
 * Project 2
 * CS 4200 - Artificial Intelligence
 * California State Polytechnic University, Pomona
 * Computer Science Department
 *
 * Instructor: Dominick A. Atanasio
 *
 */
public class Search{

    public static void testSimAnn(Tester tester) throws Exception {

        int iter = 400;
        int size = 25;
        int temp = 10000000;
        double rate = 0.0001;

        tester.testSimAnn("SA_size", iter, new int[]{4, 8, 16, 25, 40, 50}, temp, rate);
        tester.testSimAnn("SA_temp", iter, size, new int[]{1000, 10000, 100000, 1000000, 10000000}, rate);
        tester.testSimAnn("SA_rate", iter, size, temp, new double[]{0.01, 0.001, 0.0001});

    }

    public static void testGenAlg(Tester tester) throws Exception {

        int iter = 100;
        int size = 25;
        
        int popSize = 300;
        double mutProb = 0.1;
        int iterations = 5000;
        double popTop = 0.1;

        tester.testGenAlg("GA_size", iter, new int[]{4, 8, 16, 25, 40, 50}, popSize, mutProb, iterations, popTop);
        tester.testGenAlg("GA_popSize", iter, size, new int[]{100, 200, 300, 400, 500, 600}, mutProb, iterations, popTop);
        tester.testGenAlg("GA_mutProb", iter, size, popSize, new double[]{0.05, 0.1, 0.2, 0.25}, iterations, popTop);
        tester.testGenAlg("GA_iterations", iter, size, popSize, mutProb, new int[]{1000, 2500, 5000, 7500, 10000}, popTop);
        tester.testGenAlg("GA_popTop", iter, size, popSize, mutProb, iterations, new double[]{0.05, 0.1, 0.2, 0.3, 0.4});


    }

    public static void main(String[] args){

        try{
            Tester tester = new Tester();

            testSimAnn(tester);

            testGenAlg(tester);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }

    }

}