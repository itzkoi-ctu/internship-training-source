package com.model;

public class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof User)){
            return false;

        }
        User user = (User) object;
        return email.equals(user.email);
    }


    @Override
    public int hashCode(){
        return email.hashCode();
    }
}
