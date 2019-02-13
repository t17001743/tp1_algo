import java.util.Scanner;

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


    static public void mergeSort(Sequence sequence){                     // tri par fusion
        if(sequence.getSizeOf() > 1){
            Sequence s1 = new Sequence();
            Sequence s2 = new Sequence();

            while(s1.getSizeOf() != 1 && s2.getSizeOf() != 1){
                for(int i = 0; i < (sequence.getSizeOf()/2)-1; i++){
                    for(int j = sequence.getSizeOf()/2; j < sequence.getSizeOf(); j++){
                        s1.set(i, sequence.get(i));
                        s2.set(j, sequence.get(j));
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
                mergeSort(sequence);
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
