import java.util.*;


public class Main<T> {

    //*****************************************************************************************************************

    static public void bubbleSort(Sequence sequence) {              // tri à bulles
        for (int i = sequence.getSizeOf() - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (sequence.get(j).compareTo(sequence.get(j+1))>0) {
                        sequence.swap(j, j+1);
                }
            }
        }
    }

    //*****************************************************************************************************************

    static public LinkedList<Integer> splitInAFirstList(LinkedList<Integer> list){
        LinkedList<Integer> list1 = new LinkedList<>();

        for (int i = 0; i < list.size() / 2; i++) {
            list1.add(list.get(i));
        }
        Collections.sort(list1);
        return list1;
    }


    static public LinkedList<Integer> splitInASecondList(LinkedList<Integer> list){
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = list.size() / 2; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        Collections.sort(list2);
        return list2;
    }


    static public LinkedList<Integer> mergeTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> newList = new LinkedList<>();
        int i = 0, j = 0;

        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                newList.add(list1.get(i));
                i++;
            }
            else{
                newList.add(list2.get(j));
                j++;
            }
        }

        while(i <= list1.size()-1){
            newList.add(list1.get(i));
            i++;
        }

        while(j <= list2.size()-1){
            newList.add(list2.get(j));
            j++;
        }

        return newList;
    }


   static public LinkedList<Integer> mergeSort(LinkedList<Integer> list) {                     // tri par fusion
        if(list.size() > 1) {
            LinkedList<Integer> list1 = splitInAFirstList(list);
            LinkedList<Integer> list2 = splitInASecondList(list);

            list1 = mergeSort(list1);
            list2 = mergeSort(list2);

            list.clear();
            list = mergeTwoLists(list1, list2);
            return list;
        }
        return list;
    }

    //*****************************************************************************************************************

    static public void quickSort(Sequence sequence, int g, int d){                     // tri rapide avec la partition dite du drapeau
        if(g < d){
            int a = g, b = d;
            int v = (int)sequence.get((a+b)/2);
            while(a <= b){
                while(sequence.get(a).compareTo(v) < 0){
                    a++;
                }
                while(sequence.get(b).compareTo(v) > 0){
                    b--;
                }
                if(a <= b){
                    sequence.swap(a, b);
                    a++;
                    b--;
                }
            }
            quickSort(sequence, g, b);
            quickSort(sequence, a, d);
        }
    }

    //*****************************************************************************************************************

    static public void heapSort(Sequence sequence, int size, int root){                      // tri par tas

        int min = 0;          //recherche du minimum de la liste initiale
        for (int i = 0; i < size; i++){
            if((int)sequence.get(i) < min){
                min = (int)sequence.get(i);
            }
        }

        root = min;
        System.out.println(root);
        int largest = root, leftChild = 2*root + 1, rightChild = 2*root + 2;

        if (leftChild < size && sequence.get(leftChild).compareTo(sequence.get(largest)) > 0)
            largest = leftChild;

        if (rightChild < size && sequence.get(rightChild).compareTo(sequence.get(largest)) > 0)
            largest = rightChild;

        if (largest != root){
            sequence.swap((int)(sequence.get(root)), (int)sequence.get(largest));
            heapSort(sequence, size, largest);
        }
    }


    //*****************************************************************************************************************

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

    //*****************************************************************************************************************

    public static void main(String[] args) {

        Sequence sequence = new Sequence(0, 9, 10);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        Random rand = new Random();
        for(int index = 0; index < 10; index++){
            linkedList.add(rand.nextInt(9));
        }

        LinkedList<Integer> listAfterSort = new LinkedList<Integer>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le tri à effectuer :\n 1) Tri à bulles\n 2) Tri par fusion\n 3) Tri rapide (avec la partition dite du drapeau)\n 4) Tri par tas\n 5) Tri par base\n");
        int str = sc.nextInt();

        switch(str){
            case 1:
                System.out.println("Liste avant le tri :");
                System.out.println(sequence.list.toString());
                System.out.println("La taille de la liste est " + sequence.getSizeOf());
                System.out.println("\n");
                bubbleSort(sequence);
                System.out.println("Liste après le tri à bulles :");
                System.out.println(sequence.list.toString());
                break;

            case 2:
                System.out.println("Liste avant le tri :");
                System.out.println(linkedList.toString());
                System.out.println("La taille de la liste est " + linkedList.size());
                System.out.println("\n");
                listAfterSort = mergeSort(linkedList);
                System.out.println("Liste après le tri par fusion :");
                System.out.println(listAfterSort.toString());
                break;

            case 3:
                System.out.println("Liste avant le tri :");
                System.out.println(sequence.list.toString());
                System.out.println("La taille de la liste est " + sequence.getSizeOf());
                System.out.println("\n");
                quickSort(sequence, 0, 9);
                System.out.println("Liste après le tri rapide :");
                System.out.println(sequence.list.toString());
                break;

            case 4:
                System.out.println("Liste avant le tri :");
                System.out.println(sequence.list.toString());
                System.out.println("La taille de la liste est " + sequence.getSizeOf());
                System.out.println("\n");
                heapSort(sequence, 10, 0);
                System.out.println("Liste après le tri par tas :");
                System.out.println(sequence.list.toString());
                break;

            case 5 :
                System.out.println("Liste avant le tri :");
                System.out.println(sequence.list.toString());
                System.out.println("La taille de la liste est " + sequence.getSizeOf());
                System.out.println("\n");
                radixSort(sequence);
                System.out.println("Liste après le tri par base:");
                System.out.println(sequence.list.toString());
                break;

            default:
                break;
        }
    }
}