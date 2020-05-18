package com.qhm.example.test.lambda.streamAPI;

import com.qhm.example.test.lambda.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * StreamAPI 测试
 * <p>
 * 1.创建stream:数据源（集合、数组...）获取流
 * <p>
 * 2.中间操作：对数据源进行处理（过滤、筛选、切片...）,只有在程序运行到终止操作时，中间操作才会执行
 * <p>
 * 3.终止操作：执行中间操作链，产生结果
 */
public class StreamAPITest {

    //实例化一个EmployeeList
    private static List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.BUSY),
            new Employee("李四", 38, 5555.99, Employee.Status.FREE),
            new Employee("王五", 50, 6666.66, Employee.Status.FREE),
            new Employee("赵六", 16, 3333.33, Employee.Status.BUSY),
            new Employee("赵六", 16, 3333.33, Employee.Status.VOCATION),
            new Employee("田七", 8, 7777.77, Employee.Status.VOCATION)
    );

    public static void main(String[] args) {
        //creatStream();

        //intermediateOperation();

        //terminateOperation();

        optionalOperation();
    }

    /**
     * 创建流
     */
    public static void creatStream() {

        //1.Collection 系列集合提供的stream()创建串行流或paralleStream()创建并行流
        //并行流的效率在大多数情况下效率高于串行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();

        //2.Arrays 中静态方法stream()获取数组流
        String[] strArray = new String[10];
        Stream<String> stream1 = Arrays.stream(strArray);

        //3.Stream类静态方法of()
        Stream<String> streamof = Stream.of("aa", "bb", "cc");

        /**
         * 4.创建无限流
         */
        //迭代
        // 参数一：seed->种子，起始值；参数二：UnaryOperator->操作，继承Function<T,T>
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(10).forEach(System.out::println);
    }

    /**
     * 流的中间操作
     */
    public static void intermediateOperation() {
        /**
         * 筛选与切片
         * filter——接收Lambda,从流中排除某些元素
         * limit ——截断流、使其元素不超过给定数量
         * skip —— 跳过元素、返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n) 互补
         * distinct——筛选、通过流元素所产生的hashcode()和equals()去除重复元素
         */
        //filter
        System.out.println("----------------------------------------filter操作----------------------------------------");
        Stream<Employee> employeeStream = employeeList.stream().filter((e) -> {
                    System.out.println("中间操作!");
                    return e.getAge() > 35;
                }

        );
        //终止操作 ：一次性执行全部操作，"惰性求值"
        employeeStream.forEach(System.out::println);

        //limit----只要找到满足条件的数据流段，就不再进行迭代操作
        System.out.println("----------------------------------------limit操作----------------------------------------");
        Stream<Employee> limit = employeeList.stream().limit(5);
        limit.forEach(System.out::println);

        //skip
        System.out.println("----------------------------------------skip操作----------------------------------------");
        Stream<Employee> skip = employeeList.stream().skip(3);
        skip.forEach(System.out::println);

        //distinct
        System.out.println("----------------------------------------distinct操作----------------------------------------");
        Stream<Employee> distinct = employeeList.stream().distinct();
        distinct.forEach(System.out::println);

        /**
         * 映射：
         * map ————接收Lambda,将元素转换成其他形式或提取信息；接收一个函数作为参数，
         *         该函数会被应用到每个元素上，并将其映射成一个新的元素Stream<Object> 可能包含流中流
         *          传入{a，a，a}和{b,b,b,}时：{{a,a,a},{b,b,b}}  等同于 add()
         *
         * flatMap ————接收Lambda作为参数，将其中的每一个值都转换成流，然后把所有流拼接成一个流Stream<Object> 一个新流
         *          传入{a，a，a}和{b,b,b,}时 {a,a,a,b,b,b}    等同于addAll()
         */
        System.out.println("----------------------------------------map操作----------------------------------------");
        //map:
        List<String> strings = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");
        Stream<String> stringStream = strings.stream().map((x) -> {
            String s = "";
            char[] chars = x.toCharArray();
            for (char c : chars) {
                //System.out.println(c + "kk");
                s += c + "kk" + "\r\n";
            }
            return s;
        });
        stringStream.forEach(System.out::println);
        //重点
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamAPITest::filterCharacters);
        streamStream.forEach((x) -> x.forEach(System.out::println));


        System.out.println("----------------------------------------flatMap操作----------------------------------------");
        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        Stream<String> stringStream1 = strings.stream().flatMap((x) -> Stream.of(x + "kk"));
        stringStream1.forEach(System.out::println);
        //重点
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPITest::filterCharacters);
        characterStream.forEach(System.out::println);


        /**
         * 排序：
         * sorted()————自然排序(Comparable)
         * sorted(Comparator com)————定制排序
         */
        //sorted()————自然排序
        strings.stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        //sorted(Comparator com)————定制排序(Comparator)
        strings.stream().sorted((o1,o2)->{
           if(o1.equals(o2)){
               return 0;
           }else if(o1.compareTo(o2) > 0){
               return -1;
           }else{
               return 1;
           }
        }).forEach(System.out::println);

    }

    /**
     * 流的终止操作
     */
    public static void terminateOperation(){
        /**
         * 查找与匹配
         * allMatch———检查是否匹配所有元素
         * anyMatch———检查是否至少匹配一个元素
         * noneMatch——检查是否没有匹配所有元素
         * findFirst——返回第一个元素
         * findAny——返回当前流中的任意一个元素
         * count——返回流中元素的总个数
         * max——返回流中最大值
         * min——返回流中最小值
         */

        //allMatch
        boolean b1 = employeeList.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        //anyMatch
        boolean b2 = employeeList.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        //noneMatch
        boolean b3 = employeeList.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        //findFirst
        Optional<Employee> first = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
        ).findFirst();
        System.out.println(first.get());

        //findAny
        Optional<Employee> any = employeeList.parallelStream().filter((e) -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(any.get());

        //count
        long count = employeeList.stream().count();
        System.out.println(count);

        //max
        Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

        Optional<Employee> min = employeeList.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println(min.get());


        /**
         * 归约：
         *  reduce(BinaryOperator<T> accumulator) /reduce(T identity, BinaryOperator<T> accumulator)/reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
         *  将流中元素反复结合起来得到一个新值
         */
        //员工共工资之和
        Optional<Double> reduce = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());

        /**
         * 收集
         * Collect————将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
         */
        //将员工姓名收集到List中,Collectors是,Collector的工具类
        Set<String> collect = employeeList.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("-------------------------------------------------------------");
        LinkedHashSet<String> collect1 = employeeList.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect1);
        collect1.forEach(System.out::println);

        //分组
        Map<Employee.Status, List<Employee>> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect2);

        //多级分组
        Map<Employee.Status, Map<String, List<Employee>>> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));

        System.out.println(collect3);

        //分区：满足条件(true)和不满足条件(false)
        Map<Boolean, List<Employee>> collect4 = employeeList.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect4);

        DoubleSummaryStatistics collect5 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect5.getMax());

        //连接
        String collect6 = employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collect6);
    }

    /**
     * 容器类操作
     */
    public static void optionalOperation(){
        /**
         * Optional容器的常用方法
         * of(T t):创建一个Optional实例
         * empty():创建一个空的Optional实例b
         * ofNullable(T value)：若value 不为空，创建一个Optional实例，否则创建一个空实例
         * isPresent():是否包含值
         * orElse(T t):如果调用对象包含值，则返回该值，否则返回t;
         * orElseGet(Supplier s): 如果调用对象包含值，则返回该值，否则返回s获取的值
         * map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
         * flatMap(Function mapper):与Map相似，要求返回值必须是Optional包装
         */

        //of
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());

        //empty
        Optional<Employee> empty = Optional.empty();
        //System.out.println(empty.get());

        //ofNullable === of() + empty()
        Optional<Employee> ofNullable = Optional.ofNullable(null);
        //System.out.println(ofNullable.get());

        //isPresent()
        Optional<Employee> employee1 = Optional.of(new Employee());
        //boolean present = employee1.isPresent();
        if(employee1.isPresent()){
            System.out.println(employee1.get());
        }

        //orElse()
        Optional<Employee> o = Optional.ofNullable(null);
        Employee employee2 = o.orElse(new Employee("aa", 15, 88989.00));
        System.out.println(employee2);

        //orElseGet
        Employee employee3 = o.orElseGet(() -> new Employee());
        System.out.println(employee3);

        //map
        Optional<Employee> aa = Optional.ofNullable(new Employee("aa", 15, 88989.00));
        Optional<String> s = aa.map((e) -> e.getName());
        System.out.println(s.get());
        
        //flatMap
        Optional<Employee> aa1 = Optional.ofNullable(new Employee("aa1", 15, 88989.00));
        Optional<String> s1 = aa1.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(s1.get());
    }

    public static Stream<Character> filterCharacters(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }


}
