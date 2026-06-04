package com.service;

import com.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {
    private List<Student> students= new ArrayList<>();
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final int PASSED_SCORE= 60;


    public void addStudent(Student student){
        if(validateStudent(student)){
            students.add(student);

        }else{
            System.out.println("Invalid student. Cannot add.");
        }
    }
    public void printAllStudents() {
        if(students == null){
            System.out.println("Student list is empty.");
        }else{
            for(Student student :students){
                    System.out.println(student.toString());


            }
        }


    }
    public void printAllStudents(List<Student> students) {
        if(students == null){
            System.out.println("Student list is empty.");
        }else{
            for(Student student :students){
                System.out.println(student.toString());


            }
        }


    }
    public double calculateAverageScore(){
        if(students == null || students.isEmpty()){
            System.out.println("Student list is empty");
            return 0.0;

        }

        int totalScore =0;
        for(Student student : students){
            totalScore += student.getScore();

        }
        return totalScore/ (double)students.size();
    }

    public List<Student> findHighestScoreStudent(){
        if(students.isEmpty()){
            System.out.println("Student list is empty");
            return null;



        }
        List<Student> highestScoreStudentList= new ArrayList<>();
        int highestScore = students.get(0).getScore();
        for(Student student : students){
                if(student.getScore() > highestScore){
                    highestScore = student.getScore();

                    highestScoreStudentList.clear();
                    highestScoreStudentList.add(student);
                }else if(student.getScore() == highestScore){
                    highestScoreStudentList.add(student);
                }
        }

        return highestScoreStudentList;
    }


    public List<Student> findLowestScoreStudent(){
        if(students.isEmpty()){
            System.out.println("Student list is empty");
            return null;



        }
        List<Student> lowestScoreStudentList = new ArrayList<>();
        int lowestScore = students.get(0).getScore();
        for(Student student : students){
            if(student.getScore() < lowestScore){
                lowestScore = student.getScore();

                lowestScoreStudentList.clear();
                lowestScoreStudentList.add(student);
            }else if(student.getScore() == lowestScore){
                lowestScoreStudentList.add(student);
            }
        }

        return lowestScoreStudentList;
    }

    public int countPassedStudent() {
        if(students.isEmpty()){
            return 0;
        }

        int passedCount = 0;
        for(Student student : students){
            if(student.getScore() >= PASSED_SCORE){
                passedCount++;
            }
        }

        return passedCount;

    }

    public double calculatePassRate(){
        return (double) countPassedStudent()/students.size();
    }

    public String classifyScore(int score){
        if(score < MIN_SCORE || score > MAX_SCORE){
            return "Invalid score.";
        }else{
            String result;

            switch(score/10){
                case 9:
                case 10:
                    result = "Excellent";
                    break;
                case 8:
                    result = "Good";
                    break;
                case 7:
                    result = "Average";
                    break;
                case 6:
                    result = "Pass";
                    break;
                default:
                    result = "Fail";
            }
            return result;
        }
    }

    private boolean validateStudent(Student student) {
            if (student == null) {
                return false;
            }

            if (student.getName() == null || student.getName().trim().isEmpty()) {
                return false;
            }

            if (student.getScore() < MIN_SCORE || student.getScore() > MAX_SCORE) {
                return false;
            }
            for(Student existingStudent : students){
                if(existingStudent.getId() == student.getId()){
                    return false;
                }
            }

            return true;

    }

    public void printSummary(){
        System.out.println("Average score: "+calculateAverageScore());
        System.out.println("Highest score student: "+ findHighestScoreStudent());


        List<Student> highestStudentList= findLowestScoreStudent();
        System.out.print("Lowest score students: ");
        printAllStudents(highestStudentList);
        System.out.println("Number of passed student: "+countPassedStudent());
        System.out.println("Pass rate: "+String.format("%.2f", calculatePassRate()*100) + "%");
        for (Student student : students){
            System.out.println("Classify score of student ID "+ student.getId()+ " is "+ classifyScore(student.getScore()));
        }

        System.out.println(groupStudentByClassification());
    }

    public Map<String, List<Student>> groupStudentByClassification(){
        Map<String, List<Student>> listMapStudent= new HashMap<>();
        listMapStudent.put("Excellent", new ArrayList<>());
        listMapStudent.put("Good", new ArrayList<>());

        listMapStudent.put("Average", new ArrayList<>());

        listMapStudent.put("Pass", new ArrayList<>());

        listMapStudent.put("Fail", new ArrayList<>());

        for(Student student : students){
            String classification= classifyScore(student.getScore());
            listMapStudent.get(classification).add(student);
        }
        return listMapStudent;

    }






    public static void main(String[] args){
        StudentManager manager= new StudentManager();

        manager.addStudent(new Student(1,"Tran Gia Dai", 10));
        manager.addStudent(new Student(2,"Tran Gia Dai", 100));
        manager.addStudent(new Student(3,"Tran Gia Dai", 90));
        manager.addStudent(new Student(4,"Tran Gia Dai", 20));
        manager.addStudent(new Student(5,"Le Hoang Gia Bao", 100));
        manager.addStudent(new Student(6,"Tran Gia Dai", 85));

        manager.printSummary();











    }

}
