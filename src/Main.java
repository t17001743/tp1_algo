import java.util.ArrayList;

public class Main<T> {

   /* static public void bubbleSort(Sequence seq){        // tri à bulles
        for(int i = seq.list.size(); i < 2; i++){
            for(int j = 1; j < i - 1; j++){
                if(seq.list.get(j) > seq.list.get(j+1)){
                    seq.swap(seq, j, j+1);
                }
            }
        }
    }

    static public void mergeSort(Sequence seq){         // tri par fusion

    }

    static public void quickSort(Sequence seq){         // tri rapide avec la partition dite du drapeau

    } */


    public static void main(String[] args) {

        Sequence list = new Sequence(0, 10, 11);
        System.out.println("Size of list is " + list.getSizeOf(list));

    }
}
