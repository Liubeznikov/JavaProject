public class Sortirovka {
    public static void Sort(int[] A, int p, int r){
        if(p<r) {
            int q = (p+r)/2;
            Sort(A,p,q);
            Sort(A,q+1,r);
            Merge(A,p,q,r);
        }
    }

    private static void Merge(int [] A,int p, int q,int r) {
        int a = p;
        int b = q+1;
        int ind = p;
        int Dat[] = new int[A.length];
        for(int i = p; i <= r ; i++){ Dat[i] = A[i];}
        while (ind <=  r) {
            if ( b > r || Dat[a] < Dat[b] && a<=q  ) {
                A[ind] = Dat[a];
                a++;
            }
            else {
                A[ind] = Dat[b];
                b++;
            }
            ind++;
        }
    }
}
