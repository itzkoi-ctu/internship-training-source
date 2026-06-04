package com.enums;

public enum Season {
    SPRING(42),
    SUMMER(50),
    FALL(38),
    WINTER(25);

    private int temp;
    Season(int temp){
        this.temp= temp;
    }
    public int getTemp(){
        return this.temp;
    }
    @Override
    public String toString(){
        return this.name().charAt(0) +this.name().substring(1).toLowerCase()+ " ("+this.getTemp()+")";
    }
}
