  
/**
 * @author Damian Ugalde
 * @date 2020-03-08
 * @version 1.0
 *
 * Project 1
 * CS 4200 - Artificial Intelligence
 * California State Polytechnic University, Pomona
 * Computer Science Department
 *
 * Instructor: Dominick A. Atanasio
 *
 */
public class Search{

    public static void main(String[] args){

        int size = 25;

        System.out.println(SimmulatedAnnealing.simmulatedAnnealing(size, 10000000, 0.0001));
        System.out.println(GeneticAlgorithm.geneticAlgorithm(100, size));

    }

}