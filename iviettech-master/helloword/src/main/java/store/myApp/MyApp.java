package store.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.DTO.CustomerDTO;
import store.entity.Customer;
import store.entity.Product;
import store.service.customer.ICustomerService;
import store.service.product.IProductService;

import java.util.Scanner;

@Component
public class MyApp {
    private static Scanner scanner = new Scanner(System.in);
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    public void run(){
        while (true){
            initApp();
            int choose;
            do {
                System.out.println("Mời chọn chương trình : ");
                choose = Integer.parseInt(scanner.nextLine());
            }while (choose < 1 || choose > 4);
            menuApp(choose);
        }
    }

    private void initApp(){
        System.out.println("<=======================================>");
        System.out.println("CHÀO MỪNG ĐẾN CỬA HÀNG CỦA TIẾN BỊP");
        System.out.println("1.Sản phẩm.");
        System.out.println("2.Người dùng.");
        System.out.println("3.Order.");
        System.out.println("4.Thoát.");
        System.out.println("<=======================================>");
    }

    private void menuApp(int choose){
        switch (choose){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
