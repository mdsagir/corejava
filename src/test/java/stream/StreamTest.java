package stream;


import com.greenjava.model.Employee;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Log4j
public class StreamTest {


    List<Employee> employeeList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();


    @Before
    public void init() {

        employeeList.add(new Employee(3L, "John", 90909090));
        employeeList.add(new Employee(2L, "Sara", 90909900));
        employeeList.add(new Employee(1L, "Mathew", 90909011));
        employeeList.add(new Employee(4L, "White", 909090944));

        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Mango");
        stringList.add("Cucumber");

        log.info("");

    }

    /**
     * IntStream.range(1,5) 1 2 3 4
     * IntStream.rangeClose(1,5) 1 2 3 4 5 // Its increment by 1 value
     * IntStream.iterate(0, i -> i + 1).limit(10)
     * Stream.iterate(1,i -> i <=10,i -> i+1).forEach(System.out::print);
     * Using boxed() can get stream of wrapper of object.
     * <p>
     * longStream.mapToObject(l-> new Employee(1,"John",12345555));
     * min,max,count,sum,average
     * <p>
     * Finds the min max value in collection
     * .stream().mapToLong(Employee::getId).min() // Optional
     * .stream().min(Comparator.comparing(Employee::getId)) // Optional
     * .stream().sorted(Comparator.comparing(Employee::getName)) // Sorted
     * .sorted(Collections.reverseOrder()).forEach(log::info);
     * .sorted(Comparator.comparing(Employee::getName).reversed()) // for Reversed
     * longStream. map(operand -> -operand).sorted().map(operand -> -operand); // Reversed value in LogStream.
     * Stream.generate(() -> new String("Hello"))
     * .limit(2) // return top two stream
     * .count() // size of collection
     * Reduce
     * .stream().reduce(0L, (partial, employee) -> partial + employee.getId(), (aLong, aLong2) -> aLong+aLong2);
     * .stream().reduce(0L, (partial, employee) -> partial + employee.getId(), Long::sum);
     * -- Sort By Collection --
     * employeeList.sort(Comparator.comparing(Employee::getName).reversed())
     */

    // reduce, dropWhile, takeWhile
    @Test
    public void int_stream() {
        Stream.iterate(1, i -> i <= 10, i -> i +1)
                .forEach(System.out::print);

    }
}
