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


    final static double MUTATION_PROB = 0.1;
    final static int FITNESS_THRESHHOLD = 0;
    final static int ITERATIONS = 10000;
    final static double TOP_POPULATION = 0.2;
    
    /**
     * Solves the N-Queen problem using a genetic algorithm
     * @param popSize population size
     * @param n size of the board
     * @return Board configuration for the solution
     */
    public static Board geneticAlgorithm(int popSize, int n){

        //Create a new population
        ArrayList<Board> population = new ArrayList<Board>();

        //Fill the population with random values
        for(int i = 0; i < popSize; i++){
            population.add(new Board(n));
        }

        //Call the genetic algorithm function with this population
        return geneticAlgorithm(population);
    }

    /**
     * Solves the N-Queen problem using a genetic algorithm
     * @param population initial population
     * @return Board configuration for the solution
     */
    public static Board geneticAlgorithm(ArrayList<Board> population){

        int iterations = ITERATIONS;

        //Loop while there are still iterations.
        while(iterations-- > 0){
            
            //Create a new population
            ArrayList<Board> newPopulation = new ArrayList<Board>();

            //Fill the population with the same size as the original population.
            for(int i = 0; i < population.size(); i++){
                //Choose the parents and create a child from them.
                Board[] parents = chooseParents(population);
                Board child = reproduce(parents);

                //Small probability of a random mutation
                if(Math.random() <= MUTATION_PROB)
                    //Mutate the child
                    child = child.getRandomSuccessor();

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
     * Chooses two random individuals from the population.
     * Will choose from the top percentage specified.
     * @param population Population to choose from
     * @return array with 2 boards.
     */
    private static Board[] chooseParents(ArrayList<Board> population){

        //Get a random index from the most fit to the top percent specified.
        int indexOne = (int)(Math.random() * population.size() * TOP_POPULATION);

        //Choose a second random index and make sure that is not the same as the first.
        int indexTwo = 0;
        do{
            indexTwo = (int)(Math.random() * population.size() * TOP_POPULATION);
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

        //Choose a random pivot
        //TODO Fix pivot
        int n = (int)(Math.random() * (x.getSize()+1));

        //Create a new array for the child
        int[] arr = new int[x.getSize()];

        //Get the data from the 2 parents
        int[] xData = x.getData();
        int[] yData = y.getData();

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