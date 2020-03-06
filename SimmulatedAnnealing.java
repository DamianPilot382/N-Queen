public class SimmulatedAnnealing {

    public static Board simmulatedAnnealing(int size, double T, double rate){
        return simmulatedAnnealing(new Board(size), T, rate);
    }

    public static Board simmulatedAnnealing(Board initialBoard, double T, double rate){
        Board current = initialBoard;
        Board next = null;

        while(T > 1){

            if(current.getAttackingValue() <= 0)
                return current;
            
            next = current.getRandomSuccessor();

            double deltaE = current.getAttackingValue() - next.getAttackingValue();

            if(deltaE > 0 || Math.exp(deltaE/T) < Math.random())
                current = next;

            T = T * (1-rate);

        }

        return current;
    
    }
}