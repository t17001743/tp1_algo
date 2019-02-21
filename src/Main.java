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

        while(list1.size() > 1 && list2.size() > 1){
            for(int i = 0; i < list1.size()-1; i++){
                for(int j = 0; j < list2.size()-1; j++){
                    if(list1.get(i) < list2.get(j)){
                        newList.add(list1.get(i));
                        list1.remove(i);
                    }
                    else{
                        newList.add(list2.get(j));
                        list2.remove(j);
                    }
                }
            }
            list1.clear();
            list2.clear();
        }
        return newList;
    }


   static public LinkedList<Integer> mergeSort(LinkedList<Integer> list) {                     // tri par fusion
        System.out.println(list.size());
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

    static public void quickSort(Sequence sequence){                     // tri rapide avec la partition dite du drapeau
        int firstEqual = 0;   //premier égal
        int firstTaller = 0;   //premier plus grand
        for(int i = sequence.getSizeOf() - 1; i >= 1; i--){
            for(int j = 0; j <= i - 1; j++){
                if(sequence.get(i) == sequence.get(j)){
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

    //*****************************************************************************************************************

    static public void heapSort(Sequence sequence){                      // tri par tas
        Sequence newSequence = new Sequence();
        for (int i = 0; i < sequence.getSizeOf() - 1; i++) {
            newSequence.set(i, sequence.get(i));

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

        System.out.println(linkedList.toString());
        LinkedList<Integer> listA = splitInAFirstList(linkedList);
        System.out.println(listA.toString());
        LinkedList<Integer> listB = splitInASecondList(linkedList);
        System.out.println(listB.toString());
        LinkedList<Integer> mergedLists = new LinkedList<Integer>();
        mergedLists = mergeTwoLists(listA, listB);
        System.out.println(mergedLists.toString());


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
                quickSort(sequence);
                System.out.println("Liste après le tri rapide :");
                System.out.println(sequence.list.toString());
                break;

            case 4:
                System.out.println("Liste avant le tri :");
                System.out.println(sequence.list.toString());
                System.out.println("La taille de la liste est " + sequence.getSizeOf());
                System.out.println("\n");
                heapSort(sequence);
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