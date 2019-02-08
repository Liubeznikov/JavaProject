class Lambda{
    public static void main (String[] args) {

        Calculable cal = (a,b)->a-b;
        System.out.println(calculate(3,5,cal));
    }

    public static double calculate(Integer a, Integer b,Calculable c){
        return c.calc(a,b);
    }
}

interface Calculable{double calc(Integer a, Integer b);}
