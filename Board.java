import java.util.ArrayList;
import java.util.Collections;

public class Board implements Comparable<Board> {
    private int data[];

    public Board(int size){
        randomBoard(size);
    }

    public Board(int data[]){
        this.data = data;
    }

    private void randomBoard(int size){
        this.data = new int[size];

        ArrayList<Integer> temp = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            temp.add(i);
        }

        Collections.shuffle(temp);

        for(int i = 0; i < this.data.length; i++){
            this.data[i] = temp.get(i);
        }

    }

    public int getAttackingValue(){

        int count = 0;

        for(int i = 0; i < data.length; i++){
            for(int j = i + 1; j < data.length; j++){
                if((j - i) == Math.abs(data[j] - data[i]))
                    count++;
            }
        }

        return count;
    }

    public int[] getData(){
        return this.data;
    }

    public int getSize(){
        return this.data.length;
    }

    public Board getRandomSuccessor(){

        int row1 = (int)(Math.random() * this.data.length);
        int row2 = 0;
        do{
            row2 = (int)(Math.random() * this.data.length);
        }while(row1 == row2);

        int[] arr = this.data.clone();

        int temp = arr[row1];
        arr[row1] = arr[row2];
        arr[row2] = temp;

        return new Board(arr);

    }

    @Override
    public int compareTo(Board other){
        return this.getAttackingValue() - other.getAttackingValue();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(this.data.length * 2);

        for(int i : this.data){
            builder.append(i + " ");
        }

        builder.append("\nAttacking: " + this.getAttackingValue());

        return builder.toString();
    }
    
}