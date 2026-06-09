package com.internship;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.enums.ProductCategory;
import com.model.Cake;
import com.model.Drink;
import com.model.Product;

public class App {
	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            showMenu();
            System.out.println("Choose option");
            
            // Xử lý ngoại lệ nếu người dùng nhập chữ thay vì số
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số!");
                choice = -1;
            }
            scanner.nextLine(); // Xóa bộ đệm (chống trôi lệnh sau khi nhập số)

            switch (choice) {
                // ================= QUẢN LÝ SẢN PHẨM =================
                case 1:
                    System.out.println("--> Đang thực hiện: Add drink");
                    try {
                        System.out.print("Nhập ID đồ uống: ");
                        // Dùng Integer.parseInt(scanner.nextLine()) để tránh bị trôi lệnh
                        int drinkId = Integer.parseInt(scanner.nextLine()); 
                        
                        System.out.print("Nhập tên đồ uống: ");
                        String drinkName = scanner.nextLine();
                        
                        System.out.print("Nhập giá: ");
                        double drinkPrice = Double.parseDouble(scanner.nextLine());
                        
                        System.out.print("Nhập số lượng trong kho: ");
                        int drinkStock = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Có đá không? (true/false): ");
                        boolean hasIce = Boolean.parseBoolean(scanner.nextLine());

                        // Khởi tạo đối tượng Drink. Ngày tạo (createdAt) lấy ngày hiện tại.
                        Drink newDrink = new Drink(drinkId, drinkName, drinkPrice, java.time.LocalDate.now(), drinkStock, hasIce);
                        
                        // Gọi hàm add (giả sử đối tượng quản lý tên là manager)
                        productManager.add(newDrink); 

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Vui lòng nhập đúng định dạng số!");
                    } catch (IllegalArgumentException e) {
                        // Bắt lỗi trùng ID từ hàm add() ném ra
                        System.out.println("Lỗi: " + e.getMessage()); 
                    }
                    break;
                case 2:
                    System.out.println("--> Đang thực hiện: Add cake");
                    try {
                    	System.out.println("Enter cake ID: ");
                    	int cakeId = Integer.parseInt(scanner.nextLine());
                    	System.out.print("Enter cake name: ");
                        String cakeName = scanner.nextLine();
                        
                        System.out.print("Enter price: ");
                        double cakePrice = Double.parseDouble(scanner.nextLine());
                        
                        System.out.print("Enter quatity in stock: ");
                        int cakeStock = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Enter expired date with format YYYY-MM-DD, ex: 2024-12-31");
                        String dateInput= scanner.nextLine();
                        LocalDate expiredDate = LocalDate.parse(dateInput);

                        Cake cake = new Cake(cakeId, cakeName, cakePrice, LocalDate.now(), cakeStock, expiredDate);
                        
                        
                        productManager.add(cake); 
                    	
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi: Vui lòng nhập đúng định dạng số!");
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Lỗi: Vui lòng nhập đúng định dạng ngày YYYY-MM-DD!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    
                    break;
                case 3:
                    System.out.println("--> Đang thực hiện: Update product");
                    break;
                case 4:
                    System.out.println("--> Đang thực hiện: Delete product");
                    break;
                case 5:
                    System.out.println("--> Đang thực hiện: Show all products");
                    break;
                case 6:
                    System.out.println("--> Đang thực hiện: Find product by ID");
                    break;
                case 7:
                    System.out.println("--> Đang thực hiện: Search product by name");
                    break;
                case 8:
                	System.out.println("Enter the category that you want to filter");
                	ProductCategory category = ProductCategory.valueOf(scanner.nextLine().toUpperCase());
                	
                    List<Product> filteredList = productManager.filterByCategory(category);
                	productManager.displayAllProduct(filteredList);
                    break;
                case 9:
                    System.out.println("--> Đang thực hiện: Show available products");
                    break;
                case 10:
                    System.out.println("--> Đang thực hiện: Sort products by price ascending");
                    
                    List<Product> sortedList = productManager.sortByPriceAscending();
                    
                    
                    productManager.displayAllProduct(sortedList);
                    
                    break;
                case 11:
                    System.out.println("--> Đang thực hiện: Sort products by price descending");
                    break;
                case 12:
                    System.out.println("--> Đang thực hiện: Show highest price product");
                    break;
                case 13:
                    System.out.println("--> Đang thực hiện: Show average product price");
                    break;

                // ================= QUẢN LÝ ĐƠN HÀNG =================
                case 14:
                    System.out.println("--> Đang thực hiện: Create order");
                    break;
                case 15:
                    System.out.println("--> Đang thực hiện: Add product to order");
                    break;
                case 16:
                    System.out.println("--> Đang thực hiện: Pay order");
                    break;
                case 17:
                    System.out.println("--> Đang thực hiện: Cancel order");
                    break;
                case 18:
                    System.out.println("--> Đang thực hiện: Show all orders");
                    break;
                case 19:
                    System.out.println("--> Đang thực hiện: Find order by ID");
                    break;
                case 20:
                    System.out.println("--> Đang thực hiện: Filter orders by status");
                    break;
                case 21:
                    System.out.println("--> Đang thực hiện: Filter orders by date range");
                    break;

                // ================= THỐNG KÊ =================
                case 22:
                    System.out.println("--> Đang thực hiện: Show total revenue");
                    break;
                case 23:
                    System.out.println("--> Đang thực hiện: Count orders by status");
                    break;

                // ================= THOÁT CHƯƠNG TRÌNH =================
                case 0:
                    System.out.println("Đang thoát chương trình. Tạm biệt!");
                    break;

                default:
                    if (choice != -1) {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 23.");
                    }
                    break;
            }
            
            System.out.println("\n-----------------------------------\n");
            
        } while (choice != 0);

        scanner.close(); // Đóng scanner để tránh rò rỉ tài nguyên
    }

    private static void showMenu() {
        System.out.println("========== QUẢN LÝ CỬA HÀNG ==========");
        System.out.println("1. Add drink");
        System.out.println("2. Add cake");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        System.out.println("5. Show all products");
        System.out.println("6. Find product by ID");
        System.out.println("7. Search product by name");
        System.out.println("8. Filter products by category");
        System.out.println("9. Show available products");
        System.out.println("10. Sort products by price ascending");
        System.out.println("11. Sort products by price descending");
        System.out.println("12. Show highest price product");
        System.out.println("13. Show average product price");
        System.out.println("14. Create order");
        System.out.println("15. Add product to order");
        System.out.println("16. Pay order");
        System.out.println("17. Cancel order");
        System.out.println("18. Show all orders");
        System.out.println("19. Find order by ID");
        System.out.println("20. Filter orders by status");
        System.out.println("21. Filter orders by date range");
        System.out.println("22. Show total revenue");
        System.out.println("23. Count orders by status");
        System.out.println("0. Exit");
        System.out.println("======================================");
    }
}
