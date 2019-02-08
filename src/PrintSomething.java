import java.util.ArrayList;
import java.util.List;

public class PrintSomething {
    public static void main(String[] args) {
     Integer k = 6;
     List<Integer> lst =  new ArrayList<>();
     for ( int i = 1 ; i<= k ; i++){
         lst.add(i);
        }
        System.out.println(lst);
        PrintIt(lst,k,k);

    }



    private static String PrintIt(List<Integer> lst , Integer k , Integer deep ){
        String res="";
        for(int i = 1; i< lst.size(); i++){
         List<Integer> nxt = new ArrayList<>(lst);
            nxt.remove(0);
            nxt.remove(lst.get(i));
            res =  "(" + lst.get(0) + "," + lst.get(i) + ") " + PrintIt(nxt,k-2,deep);
            if (deep==k) {
                System.out.println(res);
            }
        }

        return res;

    }


}
