import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTests {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<Integer>();
        for(int i = 1 ; i<10; i++){
            lst.add(i);
        }
        lst = lst.stream().filter( (a) -> a>4).collect(Collectors.toList());
        Integer a = lst.stream().findFirst().orElse(100);
        List<Integer> task1 = lst.stream().skip(1).limit(3).collect(Collectors.toList());
        List<String> fromFile = null;
        try {
            fromFile = Files.lines(Paths.get("C:\\projects\\TestJava\\src\\sqare.txt"))
                    .map((s) -> s.replace(" ",""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<BigInteger> fib = new ArrayList<>();
                Stream.iterate(new BigInteger[]{ BigInteger.ONE, BigInteger.ONE },
                p->new BigInteger[]{ p[1], p[0].add(p[1]) })
                .limit(20)
                .forEach(s->fib.add(s[0]));



        System.out.println(lst);
        System.out.println(a);
        System.out.println(task1);
        System.out.println(fromFile);
        System.out.println(fib);

    }
}
