import java.util.Random;
import java.util.ArrayList;

public class Sequence<T extends Comparable<T>>{

    ArrayList<T> list;

    public Sequence(){
        this.list = null;
    }

    public Sequence(int min, int max, int length){
        this.list = new ArrayList<T>(length);
        Random rand = new Random();
        for(int index = 0; index < length; index++){
            this.list.add((T) Integer.valueOf(rand.nextInt(max)));
        }
    }

    public void swap(ArrayList<T> list, int i, int j){
            T tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
    }

    public T get(int i){
        return this.list.get(i);
    }

    public int getSizeOf(){
        return this.list.size();
    }

}
