package com.sharp.tools;

import com.sharp.model.Person;

import java.util.*;

public class ArrayReferenceTest {
    public static void main(String[] args) {
        //数组名 arr2 = ar r1 是引用
        //数组成员 arr2[2] = arr1[2] 是赋值
//        String[] arr1 = new String[] {"aaa","bbb","ccc"};
//        String[] arr2 = new String[3];
//        String temp = "";
//        arr2[2] = arr1[2];
//        arr1[2] = null;
//        for(String str :arr2) {
//            if(str!=null) {
//                System.out.println("arr2: "+str);
//            }
//
//        }
//        for(String str : arr1) {
//            if(str!=null) {
//                System.out.println("arr1: "+str);
//            }
//        }
        Map<String, Person> map1 = new HashMap();
        Map<String, Person> map2 = new HashMap();
        Map<String, Person> map3 = new HashMap();
        Map<String, Person> map4 = new HashMap();
        Map<String, Person> map5 = new HashMap();
        Person p1 = new Person("a",1);
        Person p2 = new Person("b",2);
        Person p3 = new Person("c",3);
        Person p4 = new Person("d",4);
        Person p5 = new Person("e",5);
        map1.put("1",p1);
        map1.put("2",p2);
        map1.put("3",p3);
        map2.put("3",p3);
        map2.put("4",p4);
        map2.put("4",p5);
        map3.put("1",p1);
        map3.put("2",p2);
        map3.put("3",p3);
        map3.put("4",p4);
        map3.put("5",p5);
        List<Map<String,Person>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        System.out.println(list);
//        Person[] arr1 = new Person[] {p1,p2,p3,p4,p5};
//        Person[] arr2 = new Person[5];
//        Person temp = null;
//        arr2[0] = arr1[4];
//        System.out.println(arr2[0].getName()+" and "+arr2[0].getAge());
//        System.out.println(arr1[4].getName()+" and "+arr1[4].getAge());
//        temp = arr2[0];
//        arr1[4] = null;
//        for(Person p : arr1) {
//            if(p!=null) {
//                System.out.println("ARR1: "+p.getName()+" and "+p.getAge());
//            }
//        }
//        for(Person p : arr2) {
//            if(p!=null) {
//                System.out.println("ARR2: "+p.getName()+" and "+p.getAge());
//            }
//        }
    }

//    public class Person {
//        private String name;
//        private int age;
//
//        public Person(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }
}
