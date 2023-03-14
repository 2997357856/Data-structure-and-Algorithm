package com.yzx.sort;

/**
 * @Author YZX
 * @Create 2023-03-14 11:13
 * @Java-version jdk1.8
 */
//定义一个学生类Student，具有年龄age和姓名username两个属性，并通过Comparable接口提供比较规则
public class Student implements Comparable<Student>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
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

    @Override
    public int compareTo(Student o) {
        //返回值如果<0,则表示前者小于后者
        //返回值如果>0,则表示前者大于后者
        //返回值如果=0,则表示前者等于后者
        return this.getAge()-o.getAge();
    }
}
