package store.component.product;

import org.springframework.stereotype.Component;

@Component
public class ProductController {
    public void run(){

    }

    private void init(){
        System.out.println("*******************************");
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM !");
        System.out.println("1.Xem tất cả sản phẩm.");
        System.out.println("2.Xem sản phẩm theo Id.");
        System.out.println("3.Tạo mới 1 sản phẩm.");
        System.out.println("4.Chỉnh sửa 1 sản phẩm.");
        System.out.println("5.Xóa 1 sản phẩm.");
        System.out.println("*******************************");
    }
}
