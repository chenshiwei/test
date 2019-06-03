package csw.java.lambda;

import java.util.Arrays;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/5
 */
public class LambdaDemo {
    public static void main(String[] args) {
//        IEat iEat = new EatImpl();
//        iEat.eat();
//        IEat iEat1 = new IEat() {
//            @Override
//            public void eat() {
//                System.out.println("eat banana");
//            }
//        };
//        iEat1.eat();

        // lambda表达式:
        // 好处: 1 代码更简洁;2 不会单独生成class文件
//        IEat iEat2 = () -> System.out.println("eat orange");
//        iEat2.eat();

        // 带参
        IEat iEat3 = thing -> System.out.println("eat " + thing);
        iEat3.eat("banana");
        IEat.method();

        iEat3.print();

        Student[] students = {
            new Student("张三", 18),
            new Student("张四", 20),
            new Student("张一", 15),
            new Student("张二", 17)
        };
        Arrays.sort(students, (o1, o2) -> o2.getAge() - o1.getAge());
        System.out.println(Arrays.toString(students));
    }
}

interface IEat {
    void eat(String thing);

    default void print() {
        System.out.println("asjo");
    }

    static void method() {
        System.out.println("aks");
    }
}

class EatImpl implements IEat {

    @Override
    public void eat(String thing) {
        System.out.println("eat " + thing);
    }
}