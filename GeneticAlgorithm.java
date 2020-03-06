import java.util.ArrayList;
import java.util.Collections;

public class GeneticAlgorithm {

    public static Board geneticAlgorithm(int popSize, int n){

        ArrayList<Board> population = new ArrayList<Board>();

        for(int i = 0; i < popSize; i++){
            population.add(new Board(n));
        }

        return geneticAlgorithm(population);
    }

    public static Board geneticAlgorithm(ArrayList<Board> population){

        final double MUTATION_PROB = 0.1;

        final int FITNESS_THRESHHOLD = 0;
        
        int iterations = 10000;

        while(iterations-- > 0){
            ArrayList<Board> newPopulation = new ArrayList<Board>();

            for(int i = 0; i < population.size(); i++){
                Board[] parents = chooseParents(population);
                Board child = reproduce(parents);

                if(Math.random() <= MUTATION_PROB)
                    child = child.getRandomSuccessor();

                newPopulation.add(child);
            }

            population = newPopulation;

            Collections.sort(population);

            if(population.get(0).getAttackingValue() <= FITNESS_THRESHHOLD)
                return population.get(0);

        }

        return population.get(0);

    }

    private static Board[] chooseParents(ArrayList<Board> population){

        double top = .2;

        int indexOne = (int)(Math.random() * population.size() * top);
        int indexTwo = 0;

        do{
            indexTwo = (int)(Math.random() * population.size() * top);
        }while(indexOne == indexTwo);

        return new Board[]{population.get(indexOne), population.get(indexTwo)};


    }

    private static Board reproduce(Board[] parents){

        Board x = parents[0];
        Board y = parents[1];

        int n = (int)(Math.random() * (x.getSize()+1));

        int[] arr = new int[x.getSize()];

        int[] xData = x.getData();
        int[] yData = y.getData();

        for(int i = 0; i < arr.length; i++){
            if(i < n)
                arr[i] = xData[i];
            else
                arr[i] = yData[i];
        }

        return new Board(arr);
    }

}