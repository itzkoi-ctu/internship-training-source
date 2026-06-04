//
//
//
//
//
//package training.javacore.practice1;
//
//public class StudentManager {
//    int[] scoreList  = {85, 92, 78, 65, 90, 55, 88};
//
//    public double calculateAverage(int[] scoreList) {
//
//        int total = 0;
//
//        for (int score : scoreList) {
//
//            total += score;
//        }
//
//        return (double) total / scoreList.length;
//    }
//
//    public boolean isPassed(int score) {
//        return score >= 60;
//    }
//
//    public int countPassedStudents(int[] scoreList) {
//
//        int count = 0;
//
//        for (int score : scoreList) {
//            if (isPassed(score)) {
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    public String classifyScore(int score) {
//
//        String result;
//
//        //[A] Kiểm tra điểm có hợp lệ không trước khi phân loại, tránh giá trị ngoài 0 đến 100 đưa vào logic gẫy xử lý sai
//        if(score < 0 || score >100) {
//            return "Invalid score";
//        }
//        //[B] Dùng switch vì điểm đã được chia thành các nhóm cố định bằng score / 10, giúp code dễ đọc hơn if-else
//        switch (score / 10) {
//            case 10:
//            case 9:
//                result = "Excellent";
//                break;
//            case 8:
//                result = "Good";
//                break;
//            case 7:
//                result = "Average";
//                break;
//            case 6:
//                result = "Pass";
//                break;
//            default:
//                result = "Fail";
//        }
//        // [C] result là biến lưu kết quả phân loại được gán trong switch, sau đó return một lần ở cuối để dễ đọc, dễ debug hơn, nếu return trực tiếp trong từng case thì sau switch  cần xử lý tiếp result thì sẽ rối hơn
//
//        return result;
//    }
//
//
//    public void printScoreSummary(int[] scoreList) {
//
//
//        System.out.println("Total students: " + scoreList.length);
//        System.out.println("Passed: " + countPassedStudents(scoreList));
//        System.out.println("Failed: " + (scoreList.length-countPassedStudents(scoreList)));
//        System.out.println("Average score: " + String.format("%.2f", calculateAverage(scoreList)));
//    }
//
//
//    public static void main(String[] args) {
//        StudentManager manager = new StudentManager();
//        manager.printScoreSummary(manager.scoreList);
//
//    }
//
//}
