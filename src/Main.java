import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

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
            System.out.println("oui");
            LinkedList<Integer> list1 = new LinkedList<Integer>();
            LinkedList<Integer> list2 = new LinkedList<Integer>();
            while(list1.size() != 1 && list2.size() != 1){
                for(int i = 0; i < (list.size()/2)-1; i++){
                    for(int j = list.size()/2; j < list.size(); j++){
                        list1.set(i, list.get(i));
                        list2.set(j, list.get(j));
                    }
                }
                mergeSort(list1);
                mergeSort(list2);
            }
            if(list1.getFirst() <= list2.getFirst()){
                list1.addAll(list2);
            }
        }
    }


    static public void quickSort(Sequence sequence){                     // tri rapide avec la partition dite du drapeau
        int firstEqual = 0;   //premier égal
        int firstTaller = 0;   //premier plus grand
        for(int i = sequence.getSizeOf() - 1; i >= 1; i--){
            for(int j = 0; j <= i - 1; j++){
                if(sequence.get(i) == sequence){
                    i++;
                }
                else if(sequence.get(i).compareTo(sequence.get(i)) > 0){
                    sequence.swap(i, firstTaller - 1);
                    firstTaller--;
                }
                else if(sequence.get(i).compareTo(sequence.get(i)) < 0){
                    sequence.swap(firstEqual, i);
                    firstEqual++;
                    i++;
                }
            }
        }
    }


    static public void heapSort(Sequence sequence){                      // tri par tas

    }


    static public void radixSort(Sequence sequence){                     // tri par base
        ArrayList[] digits = new ArrayList[10];
        int numberOfDigits = 0;

        for(int i = 0; i < sequence.getSizeOf(); i++){
            numberOfDigits = String.valueOf(sequence.get(i)).length();      //comptage du nombre de chiffre dans chaque nombre
        }

        for(int j = 0; j < digits.length; j++){
            digits[j] = new ArrayList();
        }

        /*int power = 1;
        for(int numChiffre = 0; numChiffre < numberOfDigits; numChiffre++){
            for(int index = 0; index < sequence.getSizeOf(); index++){
                //digits[(sequence.get(index)/((int)Math.pow(10, numChiffre)))%10].add(new Integer(sequence.get(index)));
                digits[sequence.get(index)/power)%10].add(sequence.get(index));
            }
            sequence.clear();
        }*/
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
        System.out.println("La taille de la liste est " + sequence.getSizeOf());

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