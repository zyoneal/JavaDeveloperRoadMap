package JavaCore.StreamApi.StreamsOverview;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsOverviewMain {

    // Stream не является коллекцией, он является врапером над существующими источниками данных
    // Преимущество стримов:
    // ===============================lazy evaluation =============================
    // У стримов есть 2 типа методов:
    // 1) Modification (там где мы модифицируем наши элементы, преобразовываем из одного состояния в другое, фильтруем и тд.)
    // 2) Actions - действия (превращение стрима в коллекцию, вывод элементов на экран, чтение первого элемента из стрима и тд.)
    // ==============================автоматическая паралеллизация=================
    // Возможность обрабатывать элементы коллекций в нескольких потоках
    // =============================возможность создавать неограниченные по размеру стримы====================
    //============================== типы методов в стриме=====================================================
    // 1) Промежуточные - map(),filter(), peek() и тд. Те, которые выдают Stream после операации.
    // 2) Терминальные - findFirst(),findAny(),forEach(). Те, которые не выдают Stream после операации.
    // 3) ShortCircuitOperation (Сокращают количество элементов) - limit(), skip(), findFirst(),findAny(), allMatch()

    private static List<Employee> employeeList = new ArrayList<>();

    private static List<Employee> secondList = new ArrayList<>();

    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) {
        employeeList.add(new Employee(1, "Alex", "Black", 50000, "IT"));
        employeeList.add(new Employee(2, "John", "Green", 75000, "IT"));
        employeeList.add(new Employee(6, "Sum", "Brown", 80000, "IT"));
        employeeList.add(new Employee(9, "Tony", "Grey", 90000, "IT"));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Victoria", "Pink", 75000, "IT"));
        employeeList.add(new Employee(16, "Sean", "Magenta", 80000, "Finance"));
        employeeList.add(new Employee(19, "Kate", "Black", 88000, "Finance"));
        employeeList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Victoria", "Pink", 75000, "Finance"));

//         secondList.add(new Employee(1, "Alex", "Black", 50000));
//         secondList.add(new Employee(2, "John", "Green", 75000));
//         secondList.add(new Employee(6, "Sum", "Brown", 80000));
//         secondList.add(new Employee(9, "Tony", "Grey", 90000));
//         secondList.add(new Employee(10, "Mike", "Yellow", 60000));
//         secondList.add(new Employee(11, "Victoria", "Pink", 75000));
//         secondList.add(new Employee(16, "Sean", "Magenta", 80000));
//         secondList.add(new Employee(19, "Kate", "Black", 88000));
//         secondList.add(new Employee(9, "Tony", "Grey", 90000));
//         secondList.add(new Employee(10, "Mike", "Yellow", 60000));
//         secondList.add(new Employee(11, "Victoria", "Pink", 75000));

        testStreamFromList();
        testSortAndReduce();
        partitionByIncome();
        groupByCriterion(Employee::getDepartment);

        // генерация неограниченого стрима 2 способа:
        // testStreamIterator(10);
        // testStreamGenerator(10);

        // Паралельный стрим (использовать с большими коллекция). С даблами лучше не использовать, будет отличаться результат от запуска к запуску.
        // Если используем метод reduce(). Если складываем значения по порядку (порядок сложения элементов важен), то тогда нужно использовать SerialStream
        // Если порядок сложения элементов не важен, то тогда используем ParallelStream
        // try {
        //     testParallelStream();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        Supplier<Integer> supplierFibonacci = new Supplier<Integer>() {
            private int previous = 0;
            private int current = 1;

            @Override
            public Integer get() {
                int next = previous + current;
                previous = current;
                current = next;
                return current;
            }
        };
        testStreamGenerator(10, supplierFibonacci);

    }

    private static void testParallelStream() throws IOException {
        employeeList.parallelStream().map(Employee::getId).sorted().collect(Collectors.toList()).forEach(System.out::println);

        Files.lines(Paths.get("words.txt")).parallel().sorted();
    }

    private static void testStreamIterator(int limit) {
        // seed (начальное значение, следующие итерации будут умножать предыдущее число на 3)
        Stream.iterate(1, e -> e * 2).limit(limit).forEach(System.out::println);
    }

    private static <T> void testStreamGenerator(int limit, Supplier<T> supplier) {
        Stream.generate(supplier).limit(limit).forEach(System.out::println);
    }

    private static <R> void groupByCriterion(Function<Employee, R> function) {
        // берем лист и группируем по переданной функции.
        Map<R, List<Employee>> collectedEmployee = employeeList.stream().collect(Collectors.groupingBy(function));
        // берем мапу, достаем от туда сет ключей (ключи будут чем что мы сгруппировали), проходимся по нему и печатаем ключ + все его значения
        collectedEmployee.keySet().stream().forEach(e -> System.out.println(e + "\n" + collectedEmployee.get(e)));
    }

    private static void partitionByIncome() {
        // Добавить в мапу по значению partitioningBy. Таким образом можно создать 2 группы из одного листа по какому-то параметру.
        Map<Boolean, List<Employee>> collectedEmployees = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));
        // если условие false - создаем одну группу.
        System.out.println("PoorEmployees");
        List<Employee> poorEmployees = collectedEmployees.get(false);
        System.out.println(poorEmployees);
        // если условие true - создаем другую группу
        System.out.println("Rich Employees");
        List<Employee> richEmployees = collectedEmployees.get(true);
        System.out.println(richEmployees);
    }

    private static void testSortAndReduce() {
        // поиск работника с максимальным id
        Employee employee = employeeList.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).get();
        System.out.println(employee);
        // поиск работника с минимальной зарплатой
        Employee employee1 = employeeList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
        System.out.println(employee1);
        // сортировка по имени
        employeeList.stream()
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // reduce() - использовать если делаем что-то нестандартное
        // создаем пустой идентификатор, в него записываем сумму id и сумму зарплат и возвращаем его
        Employee identity = new Employee(0, "", "", 0, "");
        Employee reducedEmployee = employeeList.stream()
                .reduce(identity, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;
                });
        System.out.println(reducedEmployee);
    }

    private static void testStreamFromList() {
        // employeeList.stream()
        //         .filter(e -> e.getSalary() > 60000)
        //         .filter(e -> e.getId() <= 10)
        //         .collect(Collectors.toList())
        //         .forEach(System.out::println);

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //Stream.of(el1,el2,el3, ...)
        // Optional<Employee> first = Stream.of(ids)
        //         .map(StreamsOverviewMain::findById)
        //         .filter(Objects::nonNull)
        //         .findFirst();

        // mapToInt() - выполняет действия над гетерами. Такие как : sum(), average(), max(), min(), findFirst().
        // вывод всех зарплат по соритровке
        Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                // mapToInt - делает действия над интовыми значениями
                .mapToInt(Employee::getSalary)
                .forEach(System.out::println);

        //========================================Сумма всех зарплат по сортировке================================
        int sum = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                // mapToInt - делает действия над интовыми значениями
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(sum);

        //=========================================Вывод средней зарплаты всех====================================
        OptionalDouble average = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                // mapToInt - делает действия над интовыми значениями
                .mapToInt(Employee::getSalary)
                .average();
        System.out.println(average);

        //================================Вывод максимального значения зарплаты===================================
        OptionalInt max = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                // mapToInt - делает действия над интовыми значениями
                .mapToInt(Employee::getSalary)
                .max();
        System.out.println(max);

        // ========================================flatMap()=============================================
        List<List<Employee>> departments = new ArrayList<>();
        departments.add(employeeList);
        departments.add(secondList);

        // У нас лист из листов. Превращаем каждую коллекцию в стрим.Мы берем каждый лист из листа,  и из каждого листа который мы достали достаем имя и печатаем
        departments.stream().flatMap(list -> list.stream().map(e -> e.getFirstName())).forEach(System.out::println);

        //====================================недостатки forEach()==============================
        // 1) forEach() - терминальная операция. После вызова forEach() стрим исчезает.
        // 2) Есть альтернатива которая возвращает элементы после действие. Метод peek().
        // 3) Нельзя использовать локальные переменные.
        // 4) Не можем выйти из метода в том месте где нам нужно.
        // Можем передавать в параметр заготовленное заранее лямбда выражение.
        // Метод peek() нужно использовать когда все же после выполнения метода нужно вернуть стрим со значениями , которые можно дальше обрабатывать.
        // Метод peek() не терминальная (Конечная), а промежуточная операция. Метод forEach() - терминальная операция (После нее мы не можем больше работать со стримом)

        //===================================filter()=============================================
        // Java умна и если много фильтров, то она использует их сразу к каждому элементу, а не проходится по коллекции столько раз, сколько написано фильтров.
        Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .filter(i -> i % 5 == 0).findFirst().get();
        //==================================findFirst()===========================================
        // Возвращает первый элемент из коллекции который прошел все фильтры, все мэпы и тд.
        // Альтернативой ему есть метод findAny(). (Есть смысл его использовать когда работаем с ParallelStream (Получить первый элемент который был найден во всех потоках))

        //==================================Optional==============================================
        // Класс обертка, который может содержать non-null-value или null-value.
        // Если value is present (Если метод isPresent возвращает true, то метод get() может вернуть нам то значение которое находится в Optional).
        // Если элементов нет, то возвращает Exception.
        // Есть альтернатива методу get(). Метод orElse(). Вместо того что бы получать Exception, мы можем получать то, что передадим в параметр метода orElse().
        // Можем использовать метод orElseGet(). В параметр надо передавать Supplier.
        // Метод get() нужно использовать тогда, когда мы знаем что в коллекции точно будет один элемент. В остальны случаях orElse или orElseGet()

        //=================================limit()============================================
        // Передаем в параметр количество выполнений операций фильтров и тд.
        //================================skip()==============================================
        // Передаем в параметр количество фильтраций. количество первых найденых верных элементов в коллекции.
        // ===============================allMatch()==========================================
        // Проверяет соответсвует ли вся коллекция заданым фильтрам. Если доходим до элемента, который не соответсвует фильтрам, то возвращает false и дальше не проверяет.
        // =============================== distinct() ========================================
        // чтобы получить только уникальные значения, то обьект этих значений должен имплеминтировать метод equals()
    }

    private static void testStreamFromFile() throws IOException {
        Files.lines(Paths.get("words.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                //collect(Collectors.toCollection(ArrayList::new)) - возвращает ArrayList. Можно LinkedList, Stack,TreeSet и тд.
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println);
    }

    // трансформация значений из массива id в обьект Employee
    private static Employee findById(int id) {
        if (employeeMap == null) {
            //distinct() - убирает все дубликаты
            // в качестве ключа id, в качестве значения обьект
            employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return employeeMap.get(id);
    }

}
