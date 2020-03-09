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
public class SimulatedAnnealing {

    /**
     * Solves the N-Queen problem using simulated annealing
     * @param size Size of the n x n board.
     * @param T Initial temperature
     * @param rate rate of cooling for the temperature.
     * @return Board configuration for the solution found.
     */
    public static Board simulatedAnnealing(int size, double T, double rate){
        //Call the simulated annealing method with a new board and the T and rate specified.
        return simulatedAnnealing(new Board(size), T, rate);
    }

    /**
     * Solves the N-Queen problem using simulated annealing
     * @param initialBoard Initial board to use for solution
     * @param T Initial temperature
     * @param rate rate of cooling for the temperature.
     * @return Board configuration for the solution found.
     */
    public static Board simulatedAnnealing(Board initialBoard, double T, double rate){

        //Create current and next Board pointers.
        Board current = initialBoard;
        Board next = null;

        //While the temperature is greater than 1, keep searching
        while(T > 1){

            //If the solution is found, return it.
            if(current.getAttackingValue() <= 0)
                return current;
            
            //Get a random successsor
            next = current.getRandomSuccessor();

            //Compare the result of the current and the next board.
            //delatE is < 0 if current is better. > 0 if next is better. 0 if equal.
            double deltaE = current.getAttackingValue() - next.getAttackingValue();

            //Set current to the next board if next is better than current
            //OR by random probability based on the difference of fitness of the two and decreasing with time.
            if(deltaE > 0 || Math.exp(deltaE/T) < Math.random())
                current = next;

            //Decrease the temperature proportional to the rate of cooling.
            T = T * (1-rate);

        }

        //If no solution found by the time the temperature has cooled, return the best one found so far.
        return current;
    
    }
}