package dt.RestaurantBillGenerator;

import java.util.Scanner;

public class RestaurantBillGenerator
{
    public static void main(String[] args)
    {

        start();
    }
    public static void start()
    {
        DishService dishService=new DishService();
        dishService.fillDishList();
        OrderService servis=new OrderService();
        getSelectionMenu(dishService,servis);

    }

    public static void getSelectionMenu(DishService dishService2,OrderService service)
    {
        int select=-1;
        while (select!=0)
        {
            Scanner inp=new Scanner(System.in);
            System.out.println("----------------------------");
            System.out.println("** Lezzet Restaruant hoş gleidn *****");
            System.out.println("1-Menu");
            System.out.println("2-Sipariş Girme");
            System.out.println("3-Sipariş iptal etme");
            System.out.println("4-Hesap oluştur");
            System.out.println("5-Mevcut siparişi göster");
            System.out.println("0-Çıkış");
            System.out.print("Seçiminiz...");
            select=inp.nextInt();
            System.out.println("-------------------------------");
            switch (select)
            {
                case 1: dishService2.showDishMenu(); break;
                case 2: service.createOrder(dishService2);break;
                case 3: service.siparissil();break;
                case 4: service.hesabikes();break;
                case 5: service.siparislistesi();break;
                case 0: break;
                default:
                    System.out.println("hatalı giriiş");break;
            }
        }
        System.out.println("iyi günler");
    }

}

