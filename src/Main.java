import java.util.*;

public class Main {
    public static void main(String[] args) {

     //   exemple1();
     //   exemple3();
        exemple7();
    }

    private static void exemple5() {
        //пользователь введет много РАЗНЫХ A, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<A> aSet = new HashSet<>();
        System.out.println("введите "+n+" A");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            A a = new A(x);
            aSet.add(a);  //объекты с одинаковыми числами внутри должны быть равны
        }
        System.out.println("количество разных A: "+aSet.size());  //столько, сколько объектов с разным содержимым,
                                                    //потому что мы переопределили equals()

        System.out.println(aSet); //порядок элементов непредсказуемый
    }

    private static void exemple6() { //оставим неработающий пример
        //пользователь введет много РАЗНЫХ A, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<A> aSet = new TreeSet<>();
        System.out.println("введите "+n+" A");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            A a = new A(x);
            aSet.add(a);  //Необходимо уметь СРАВНИВАТЬ объекты, а если нет - то не будет и дерева
        }
        System.out.println("количество разных A: "+aSet.size());  //столько, сколько объектов с разным содержимым,
        //потому что мы переопределили equals()

        System.out.println(aSet); //порядок элементов непредсказуемый
    }

    private static void exemple7() {
        //пользователь введет много РАЗНЫХ AComp, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<AComp> aSet = new TreeSet<>();
        System.out.println("введите "+n+" AComp");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            AComp a = new AComp(x);
            aSet.add(a);  //Необходимо уметь СРАВНИВАТЬ объекты, а если нет - то не будет и дерева
        }
        System.out.println("количество разных AComp: "+aSet.size());  //столько, сколько объектов с разным содержимым,
        //потому что мы переопределили equals()

        System.out.println(aSet); //порядок элементов непредсказуемый
    }

    private static void exemple4() {
        //пользователь введет много РАЗНЫХ B, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<B> differentB = new HashSet<>();
        System.out.println("введите "+n+" строк");
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            B b = new B(s);
            differentB.add(b);  //объекты с одинаковыми строками внутри НЕ считаются равными
        }
        System.out.println("количество разных B: "+differentB.size());  //столько объектов, сколько вводили
                                                    //потому что нет уточнения, какие объекты B равны
        System.out.println(differentB); //порядок элементов непредсказуемый

    }

    private static void exemple2() {
        //пользователь введет много РАЗНЫХ строк, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<String> differentStrings = new HashSet<>();
        System.out.println("введите "+n+" строк");
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            differentStrings.add(s);
        }

        System.out.println("количество разных строк: "+differentStrings.size());
        System.out.println(differentStrings); //порядок элементов непредсказуемый
    }

    private static void exemple3() {
        //пользователь введет много РАЗНЫХ строк, а мы их посмотрим
        Scanner scanner = new Scanner(System.in);
        int n=10;
        Set<String> differentStrings = new TreeSet<>();// это штука упорядоченная
        System.out.println("введите "+n+" строк");
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            differentStrings.add(s);
        }

        System.out.println("количество разных строк: "+differentStrings.size());
        System.out.println(differentStrings); //порядок элементов - по возрастанию!
    }

    private static void exemple1() {
        B b = new B("Борис");
        print(b, 3);
        A a = new A(159);
        print(a, 4);
        print2(a, b, 5);
        A a2 = new A(624);
        B b2 = new B("Арина");
        printGeneric(b, b2, 6);
        printGeneric(a, a2, 7);
        printGeneric(a, b2, 8);
        System.out.println("----------------");
        Printer<A> aPrinter = new Printer<>();
        aPrinter.printGeneric2(a2, a, 9);
        //aPrinter.printGeneric2(b, a, 10);  ошибка: принтер проверил, что ему подсунули не тот объект
        Printer<B> bPrinter = new Printer<>();
        bPrinter.printGeneric2(b2, b, 10);
        // bPrinter.printGeneric2("Вася", b, 10);
        Printer<Integer> integerPrinter = new Printer<>();
        integerPrinter.printGeneric2(44, 56, 11);

        ArrayList<B> bArrayList = new ArrayList<>();
        List<A> aList = new Stack<>();
        aList.add(a);
        Set<A> aSet = new TreeSet<>();
        Map<A, B> abMap = new TreeMap<>();
    }

    /*static void print(A a, int num)
    {
        System.out.println("пример "+num +" объект: "+a);
    }*/

    static void print(Object o, int num)
    {
        System.out.println("пример "+num +" объект: "+o+" рассматривается как Object");
    }

    static void print2(Object o1, Object o2, int num)
    {
        System.out.println("пример "+num +" объект1: "+o1+",  объект2: "+o2);
    }

    static <T>void printGeneric (T o1, T o2, int num){
        System.out.println("пример "+num +" объект1: "+o1+",  объект2: "+o2);
    }
}

class A{
    int value;
    public A(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "A{"+ value +   '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return value == a.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}

class B{
    String name;

    public B(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "B{" + name +  '}';
    }
}

class Printer<T>{
    public void printGeneric2 (T o1, T o2, int num){
        System.out.println("пример "+num +" объект1: "+o1+",  объект2: "+o2);
    }
}


