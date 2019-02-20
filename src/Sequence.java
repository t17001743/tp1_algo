import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sequence<T extends Comparable<T>>{

    ArrayList<T> list;

    public Sequence(){
        list = null;
    }

    public Sequence(int min, int max, int length){
        list = new ArrayList<T>(length);
        Random rand = new Random();
        for(int index = 0; index < length; index++){
            list.add((T) Integer.valueOf(rand.nextInt(max)));
        }
    }


    public void swap(int i, int j){
            T tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
    }

    public T get(int i){
        return list.get(i);
    }

    public T set(int i, T elt){
        return list.set(i, elt);
    }

    public int getSizeOf(){
        return list.size();
    }
}

