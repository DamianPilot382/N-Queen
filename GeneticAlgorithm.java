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
import java.util.ArrayList;
import java.util.Collections;

public class GeneticAlgorithm {


    final static int FITNESS_THRESHHOLD = 0;
    
    /**
     * Solves the N-Queen problem using a genetic algorithm
     * @param popSize population size
     * @param n size of the board
     * @return Board configuration for the solution
     */
    public static Board geneticAlgorithm(int popSize, int n, double mutationProb, int iterations, double topPop){

        //Create a new population
        ArrayList<Board> population = new ArrayList<Board>();

        //Fill the population with random values
        for(int i = 0; i < popSize; i++){
            population.add(new Board(n));
        }

        //Call the genetic algorithm function with this population
        return geneticAlgorithm(population, mutationProb, iterations, topPop);
    }

    /**
     * Solves the N-Queen problem using a genetic algorithm
     * @param population initial population
     * @return Board configuration for the solution
     */
    public static Board geneticAlgorithm(ArrayList<Board> population, double mutProb, int iterations, double topPop){

        //Loop while there are still iterations.
        while(iterations-- > 0){
            
            //Create a new population
            ArrayList<Board> newPopulation = new ArrayList<Board>();

            //Fill the population with the same size as the original population.
            for(int i = 0; i < population.size(); i++){
                //Choose the parents and create a child from them.
                Board[] parents = chooseParents(population, topPop);
                Board child = reproduce(parents);

                //Small probability of a random mutation
                if(Math.random() <= mutProb)
                    //Mutate the child
                    mutate(child);

                //Add the child to the population
                newPopulation.add(child);
            }

            //Replace the old population with the new one
            population = newPopulation;

            //Sort the population by fitness at the end to save time
            Collections.sort(population);

            //If the fittest individual (the one at the front) is fit enough, return it.
            if(population.get(0).getAttackingValue() <= FITNESS_THRESHHOLD)
                return population.get(0);

        }

        //If the iterations run out, return the fittest individual (the one at the front).
        return population.get(0);

    }

    /**
     * Changes a random value for the child object
     * @param child board to mutate
     */
    public static void mutate(Board child){
        int row = (int)(Math.random() * child.getSize());
        int val = (int)(Math.random() * child.getSize());

        child.getData()[row] = val;
    }

    /**
     * Chooses two random individuals from the population.
     * Will choose from the top percentage specified.
     * @param population Population to choose from
     * @return array with 2 boards.
     */
    private static Board[] chooseParents(ArrayList<Board> population, double topPopulation){

        //Get a random index from the most fit to the top percent specified.
        int indexOne = (int)(Math.random() * population.size() * topPopulation);

        //Choose a second random index and make sure that is not the same as the first.
        int indexTwo = 0;
        do{
            indexTwo = (int)(Math.random() * population.size() * topPopulation);
        }while(indexOne == indexTwo);

        //Return an array with 2 boards
        return new Board[]{population.get(indexOne), population.get(indexTwo)};


    }

    /**
     * Produce a child from two provided parents
     * @param parents array with 2 boards
     * @return Board child with elements from the parents
     */
    private static Board reproduce(Board[] parents){

        //Get the parents from the array
        Board x = parents[0];
        Board y = parents[1];

        //Create a new array for the child
        int[] arr = new int[x.getSize()];

        //Choose a random pivot
        int n = (int)(Math.random() * (x.getSize()));

        //Get the data from the 2 parents
        int[] xData = x.getData();
        int[] yData = y.getData();

        if(Math.random() > .5){
            xData = y.getData();
            yData = x.getData();
        }

        //Loop through the child array
        for(int i = 0; i < arr.length; i++){

            //Fill the first half of the array with data from the 1st parent.
            if(i < n)
                arr[i] = xData[i];
            //Fill the second half of the array with data from the 2nd parent.
            else
                arr[i] = yData[i];
        }

        //Create a new board with the data and return it.
        return new Board(arr);
    }

}