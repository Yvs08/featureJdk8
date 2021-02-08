import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    // instance method of the outer class
    void my_Method() {
        final int num = 23;

        // method-local inner class
        class MethodInner_Demo {
            public void print() {
                System.out.println("This is method inner class "+ num);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();


    }

     Integer doSomething(Integer value) {
        int test = 1;
        int teste = 1 ;
        try {
             teste = value / test;

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        return teste;
    }

    public static void main(String args[]) {
        Test outer = new Test();

        Stream<Integer> myList = Stream.of(1, 2, 3, 1, 2, 3);

        List<Integer> result = myList.
                map(value -> { return outer.doSomething(value);}).
                collect(Collectors.toList());

        result.stream().forEach(System.out::println);
        Map<Double, Long> entry =  result.stream().collect(Collectors.groupingBy(Integer::doubleValue , Collectors.counting()));
        entry.entrySet().forEach(System.out::println);



    }


}