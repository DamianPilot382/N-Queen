import java.io.FileWriter;
import java.io.IOException;

public class Tester {

    private FileWriter writer;

    public void changeFileName(String name) throws IOException {
        writer = new FileWriter(name+".csv");
    }

    public void writeToFile() throws IOException {
        writer.flush();
        writer.close();
    }

    public void testSimAnn(String fileName, int iter, int size, int[] temps, double rate) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,temperature,rate,attack,time,\n");

        for(int i = 0; i < temps.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = SimulatedAnnealing.simulatedAnnealing(size, temps[i], rate);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+temps[i]+","+rate+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();

    }

    public void testSimAnn(String fileName, int iter, int size, int temp, double[] rates) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,temperature,rate,attack,time,\n");

        for(int i = 0; i < rates.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = SimulatedAnnealing.simulatedAnnealing(size, temp, rates[i]);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+temp+","+rates[i]+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();

    }

    public void testSimAnn(String fileName, int iter, int[] sizes, int temp, double rate) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,temperature,rate,attack,time,\n");

        for(int i = 0; i < sizes.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = SimulatedAnnealing.simulatedAnnealing(sizes[i], temp, rate);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+sizes[i]+","+temp+","+rate+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();

    }

    public void testGenAlg(String fileName, int iter, int[] size, int popSize, double mutProb, int iterations, double popTop) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,popSize,mutProb,iter,popTop,attack,time,\n");

        for(int i = 0; i < size.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = GeneticAlgorithm.geneticAlgorithm(popSize, size[i], mutProb, iterations, popTop);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size[i]+","+popSize+","+mutProb+","+iterations+","+popTop+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();
    }

    public void testGenAlg(String fileName, int iter, int size, int[] popSize, double mutProb, int iterations, double popTop) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,popSize,mutProb,iter,popTop,attack,time,\n");

        for(int i = 0; i < popSize.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = GeneticAlgorithm.geneticAlgorithm(popSize[i], size, mutProb, iterations, popTop);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+popSize[i]+","+mutProb+","+iterations+","+popTop+","+b.getAttackingValue()+","+time+",\n");
                writer.flush();
            }
        }
        this.writeToFile();
    }

    public void testGenAlg(String fileName, int iter, int size, int popSize, double[] mutProb, int iterations, double popTop) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,popSize,mutProb,iter,popTop,attack,time,\n");

        for(int i = 0; i < mutProb.length; i++){
            for(int j = 1; j <= iter; j++){
                System.out.println("Running");
                long time = System.currentTimeMillis();
                Board b = GeneticAlgorithm.geneticAlgorithm(popSize, size, mutProb[i], iterations, popTop);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+popSize+","+mutProb[i]+","+iterations+","+popTop+","+b.getAttackingValue()+","+time+",\n");
                writer.flush();
            }
        }
        this.writeToFile();
    }

    public void testGenAlg(String fileName, int iter, int size, int popSize, double mutProb, int[] iterations, double popTop) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,popSize,mutProb,iter,popTop,attack,time,\n");

        for(int i = 0; i < iterations.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = GeneticAlgorithm.geneticAlgorithm(popSize, size, mutProb, iterations[i], popTop);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+popSize+","+mutProb+","+iterations[i]+","+popTop+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();
    }

    public void testGenAlg(String fileName, int iter, int size, int popSize, double mutProb, int iterations, double[] popTop) throws IOException {
        this.changeFileName(fileName);

        writer.append("iteration,size,popSize,mutProb,iter,popTop,attack,time,\n");

        for(int i = 0; i < popTop.length; i++){
            for(int j = 1; j <= iter; j++){
                long time = System.currentTimeMillis();
                Board b = GeneticAlgorithm.geneticAlgorithm(popSize, size, mutProb, iterations, popTop[i]);
                time = System.currentTimeMillis() - time;
                writer.append(j+","+size+","+popSize+","+mutProb+","+iterations+","+popTop[i]+","+b.getAttackingValue()+","+time+",\n");
            }
        }
        this.writeToFile();
    }

}