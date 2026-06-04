package com.model;


public class Dog extends Animal {

    
    public Dog(){}
    public Dog(String name, int age){
        this.age=age;
        this.name=name;
    }
    public void bark(){
        System.out.println("WAN WAN..");
    }
    @Override 
    public boolean equals(Object ojb){
        if(this==ojb)return true;
        if(!(ojb instanceof Dog)){
            return false;
        }
        Dog other = (Dog) ojb;
        return this.name.equals(other.name);

    }
    @Override
    public String toString(){
        return "Dog{name =' "+name+"', age= "+age;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

}
