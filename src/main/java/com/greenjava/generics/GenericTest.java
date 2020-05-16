package com.greenjava.generics;

import java.util.*;
import java.util.function.BiFunction;

public class GenericTest {

    public static void main(String[] args) {

        List<A> as = new ArrayList<>(Arrays.asList(new A("john"), new A("Sara")));
        List<B> bs = new ArrayList<>(Arrays.asList(new B("909090"), new B("1212121")));
        Set<B> sb = new HashSet<>();
        sb.add(new B("000"));
        as.addAll(bs);
        as.addAll(sb);
        call(sb);

    }

    public static void  call(Collection<? extends A> collection) {
        collection.forEach(System.out::println);
    }
}

class A {

    private String aName;

    public A() {
    }

    public A(String aName) {
        this.aName = aName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "A{" +
                "aName='" + aName + '\'' +
                '}';
    }
}

class B extends A {

    private String mobile;

    public B(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "B{" +
                "mobile='" + mobile + '\'' +
                '}';
    }


}
class C {
    private String email;

    public C() {
    }

    public C(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "C{" +
                "email='" + email + '\'' +
                '}';
    }
}