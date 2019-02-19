import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Main<T> {

    static public void bubbleSort(Sequence sequence) {              // tri à bulles
            for (int i = sequence.getSizeOf() - 1; i >= 1; i--) {
                for (int j = 0; j <= i - 1; j++) {
                    if (sequence.get(j).compareTo(sequence.get(j+1))>0) {
                        sequence.swap(j, j+1);
                    }
                }
            }
        }


    static public void mergeSort(LinkedList<Integer> list){                     // tri par fusion
        if(list.size() > 1){
            LinkedList<Integer> list1 = new LinkedList<Integer>();
            LinkedList<Integer> list2 = new LinkedList<Integer>();
            while(list1.size() != 1 && list2.size() != 1){
                for(int i = 0; i < (list.size()/2)-1; i++){
                    for(int j = list.size()/2; j < list.size(); j++){
                        list1.set(i, list.get(i));
                        list2.set(j, list.get(j));
                    }
                }
            }



        }

    }


    static public void quickSort(Sequence sequence){                     // tri rapide avec la partition dite du drapeau
        int g = 0;
        int d = 0;
    }


    static public void heapSort(Sequence sequence){                      // tri par tas

    }


    static public void radixSort(Sequence sequence){                     // tri par base

    }


    public static void main(String[] args) {

        Sequence sequence = new Sequence(0, 9, 10);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        Random rand = new Random();
        for(int index = 0; index < linkedList.size(); index++){
            linkedList.add(rand.nextInt(10));
        }

        System.out.println("Liste avant le tri :");
        System.out.println(sequence.list.toString());
        System.out.println("Size of list is " + sequence.getSizeOf());

        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le tri à effectuer :\n 1) Tri à bulles\n 2) Tri par fusion\n 3) Tri rapide (avec la partition dite du drapeau)\n 4) Tri par tas\n 5) Tri par base\n");
        int str = sc.nextInt();

        switch(str){
            case 1:
                bubbleSort(sequence);
                System.out.println("Liste après le tri à bulles :");
                System.out.println(sequence.list.toString());
                break;

            case 2:
                mergeSort(linkedList);
                System.out.println("Liste après le tri par fusion :");
                System.out.println(sequence.list.toString());
                break;

            case 3:
                quickSort(sequence);
                System.out.println("Liste après le tri rapide :");
                System.out.println(sequence.list.toString());
                break;

            case 4:
                heapSort(sequence);
                System.out.println("Liste après le tri par tas :");
                System.out.println(sequence.list.toString());
                break;

            case 5 :
                radixSort(sequence);
                System.out.println("Liste après le tri par base:");
                System.out.println(sequence.list.toString());
                break;

            default:
                break;
        }
    }
}
