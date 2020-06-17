
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*new Thread(new CodeToRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable2");
            }
        }).start();
        new Thread(() -> System.out.println("Printing from the Runnable3")).start();
        new Thread(() -> {
            System.out.println("Printing from the Runnable4");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();*/

        /*Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(jack);
        employeeList.add(snow);*/
        /*Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });*/

        /*Collections.sort(employeeList, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for(Employee employee : employeeList) {
            System.out.println(employee.getName());
        }*/

        /*String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        }, employeeList.get(0).getName(), employeeList.get(1).getName());
        System.out.println(sillyString);*/

        /*UpperConcat uc = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employeeList.get(0).getName(), employeeList.get(1).getName());
        System.out.println(sillyString);*/

        /*String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase(), employeeList.get(0).getName(), employeeList.get(1).getName());
        System.out.println(sillyString);*/

        /*AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        anotherClass.printValue();*/

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(jack);
        employeeList.add(snow);
        /*for(Employee employee : employeeList) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }*/
        employeeList.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the Runnable1");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        /*System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        }, "String 1", "String 2");*/

        /*UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class name is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");*/

        /*final int i = 0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                    System.out.println("i (within anonymous class) = " + i);
                    return s1.toUpperCase() + " " + s2.toUpperCase();
                }
            };
            System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
            //i++;
            System.out.println("i= " + i);
            return Main.doStringStuff(uc, "String 1", "String 2");
        }*/

        int i = 0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class name is: " + getClass().getSimpleName());
            System.out.println("i (within lambda expression) = " + i);
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");
    }

    /*
    When the code runs the Thread will sleep for 5 seconds and then print the value of the number variable.
    When the thread is sleeping the printValue method will continue to execute and will exit.
    That means that by the time gets around printing the number the local variable will no longer exist.
    What will the Thread print?
    While since any variable in the lambda is set when the lambda is processed by the runtime and those values
    of those variables wouldn't change because they are effectively final the runtime knows it can use the value
    of 25 ant that's because that was the value of number when it processed the lambda.
    */
    public void printValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }
}