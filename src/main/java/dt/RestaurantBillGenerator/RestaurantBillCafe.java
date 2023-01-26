package dt.RestaurantBillGenerator;

import java.util.Scanner;

public class RestaurantBillCafe {

    public static void main(String[] args)
    {

        start();
    }
    public static void start()
    {
        OrderService servis=new OrderService();
        Scanner sec=new Scanner(System.in);
        System.out.println("1-resto");
        System.out.println("2-cafe");
        int secim=sec.nextByte();
        if (secim==1)
        {  DishService dishService=new DishService();
        dishService.fillDishList();
            getSelectionMenu(dishService,servis);
        }
       else {
           DishService dishService=new CafeDishServis();
           dishService.fillDishList();
           getSelectionMenu(dishService,servis);
        }
        System.out.println("iyi günler");


    }

    public static void getSelectionMenu(DishService dishService2,OrderService service)
    {
        int select=-1;
        while (select!=0)
        {
            Scanner inp=new Scanner(System.in);
            System.out.println("----------------------------");
            System.out.println("** Lezzet Restaruant/Cafe hoş gleidn *****");
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
