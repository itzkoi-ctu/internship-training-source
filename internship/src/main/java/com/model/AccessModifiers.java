package com.model;

public class AccessModifiers {
    public void printAccessModifierClass(){
        System.out.println("ACM");
        var inner = new InnerClass();
        inner.printInnerClass();
    }


    public class InnerClass{

        public void printInnerClass(){
            System.out.println("INC");
        }
    }

}

