import java.util.Random;
import java.util.ArrayList;


public class RandomLists<T extends Comparable<T>>{

    ArrayList<T> list = new ArrayList<T>();

    public RandomLists(){
        this.list = null;
    }

    public RandomLists(int min, int max, int length){
        Random rand = new Random();
        for(int index = 0; index < length; index++){
            T r = (T) (Integer.valueOf(rand.nextInt(max)));
            this.list.add(r);
        }
    }


    public int compareTo(T o){
        return 0;
    }


    public T swap(ArrayList<T> list, int i, int j){
        T tmp;
        tmp = list;

    }

    public ArrayList<Integer> generateRandomly(int min, int max, int length){
        RandomLists listOfIntegers = new RandomLists(min, max, length);
    }

    public ArrayList<Character> generateRandomly(T o){
        return null;
    }

    public ArrayList<Double> generateRandomly(int a){
        return null;
    }






    //faire méthodes statiques pour chaque tri dans cette classe
}
