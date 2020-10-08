package com.zeal.sheldon.java8;

import com.zeal.sheldon.entity.Student;
import com.zeal.sheldon.entity.StudentComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author Tongle
 * @Description 方法引用
 * 需求：对集合中的对象进行排序
 * jdk1.8之后 List中有个默认的sort方法，对集合中的元素进行就地排序
 * Created on 2020-09-21
 */
public class MethodReferenceDetect {
    public static void main(String[] args) {
        Student stu1 = new Student("张三",90);
        Student stu2 = new Student("李四",100);
        Student stu3 = new Student("王五",89);
        Student stu4 = new Student("赵六",70);
        List<Student> students = Arrays.asList(stu1, stu2, stu3, stu4);

//        method1(students);
//        method2(students);
//        method3(students);
        method4();

    }

    /**
     * 方法引用方式1：类名::静态方法
     * @param students
     */
    private static void method1(List<Student> students) {
        //先用Lambda表达式实现,sort方法传入Comparator接口(函数式接口)
        //需要实现的抽闲方法为：
        // int compare(T o1, T o2) 传入两个参数，返回一个int值
        students.sort((stu1,stu2)->stu1.getScore()-stu2.getScore());
        //这里可以使用现成的方法
        students.sort((stu1,stu2)->Student.compareByStudentScore(stu1,stu2));
        //进一步简化，使用方法引用,这里的compareByStudentScore方法完全符合compare方法的定义，所以可以替代
        students.sort(Student::compareByStudentScore);
        students.sort(Comparator.comparing(Student::getName));
    }

    /**
     * 方法引用方式2：对象名::实例方法
     * @param students
     */
    private static void method2(List<Student> students) {
        //创建实例
        StudentComparator studentComparator = new StudentComparator();
        students.sort(studentComparator::compareByStudentScore);
        students.forEach(ele-> System.out.println(ele));
//        students.forEach(System.out::println);

    }


    /**
     * 方法引用方式3：类名::实例方法
     * 比较难理解的一种方式
     * @param students
     */
    private static void method3(List<Student> students) {
       students.sort(Student::compareByScore);
    }

    /**
     * 方法引用方式4：类名::new
     * 构造方法引用
     */
    private static void method4() {
        //Supplier的抽象方法 T get(); 不接受参数返回一个值 ，符合String类的new构造方法
        System.out.println(MethodReferenceDetect.getStr(String::new));
        //自动就定位到 String(String original)方法
        System.out.println(MethodReferenceDetect.getStr("hello", String::new));
    }

    private static String getStr(Supplier<String> supplier){
        return supplier.get() + " detect";
    }
    private static String getStr(String str, Function<String,String> function){
        return function.apply(str);
    }


}
