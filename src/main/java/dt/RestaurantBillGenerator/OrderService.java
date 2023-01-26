package dt.RestaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService
{
    Scanner inp=new Scanner(System.in);

    List<Order> orderList2=new ArrayList<>();

    public void createOrder(DishService dishService)
    {
        int dishcode=-1;
        while (dishcode!=0)
        {
            dishService.showDishMenu();
            System.out.println("Lütfen ürün kodu giriniz. siparişi bitirmek için 0 girin=");
            dishcode = inp.nextInt();
            Dish dishsecim=dishService.urunbul(dishcode);
            if (dishsecim.getKod()>0)
            {
                System.out.println("Aded giriniz...");
                int miktar=inp.nextByte();
                System.out.println("Masa no giriniz...");
                byte masa=inp.nextByte();
                Order order=new Order(dishsecim,miktar,masa);
                order.fiyathesapla();
                order.orderCode=1000+orderList2.size();
                orderList2.add(order);
            }

            for (Order w:orderList2)
            {
                System.out.printf("Masa no:%-2s   Sipariş kodu:%-5s   Lezzet kodu:%-3s   Adı:%-20s   Adedi:%-2s\n",
                        w.masanumarasi,w.orderCode,w.dish.getKod(),w.dish.getIsim(),w.numOfDish);
            }




        }
    }
    public void siparissil()
    {
        boolean bayrak=true;
        if (orderList2.isEmpty()) System.out.println("Siparişiniz bulunamamakta");
        else
        {
            System.out.println("iptal etmek istediğiniz siparişin kodunu girin");
            int sipkod=inp.nextInt();
            for (Order siparis: orderList2)
            {
                if(siparis.orderCode==sipkod)
                {
                    orderList2.remove(siparis);
                    System.out.println("Siparişiniz iptal edildi...\n iptal edilen sipariş"+siparis.orderCode+" "+siparis.dish.toString());
                    break;
                }
                else bayrak=false;
            }
            if (!bayrak) System.out.println("hatalı sipariş kodu girildi");
        }
    }
    public void hesabikes()
    {
        Scanner veri=new Scanner(System.in);
        double toplamfiyat=0;
        System.out.println("Lezzet fişiniz");
        System.out.println("Hesabı alınacak masa numarasını giriniz");
        byte masa=veri.nextByte();

        int idx=0;
        for (Order liste: orderList2)
        {
            if (masa==liste.masanumarasi)
            {
                System.out.printf("Masa no:%-2s Lezzet kodu:%-5s   Adı:%-20s   Adet:%-5s   Sipariş Tutarı:%-5s Lira \n",
                    liste.masanumarasi,liste.dish.getKod(),liste.dish.getIsim(),liste.numOfDish,liste.orderPrice);
                toplamfiyat+=liste.orderPrice;

            }idx++;
        }
        //System.out.println("x = " + x);
        System.out.println("toplam tutar:"+toplamfiyat+" Lira");
        System.out.println("ödeme yapıldı sil (E) ödeme yapılmadı (H)");
        char cvp=veri.next().toLowerCase().charAt(0);
        int say=0;
        if (cvp=='e')
        {
            //Order liste=new Order();

            for (Order liste: orderList2)
            //for (int i=0;i<orderList2.size();i++)
            {
                if (masa==liste.masanumarasi)
                {
                    /*liste.dish=orderList2.get(i).dish;
                    System.out.println("liste.dish = " + liste.dish.toString());
                    liste.orderPrice=orderList2.get(i).orderPrice;
                    liste.numOfDish=orderList2.get(i).numOfDish;
                    liste.orderCode=orderList2.get(i).orderCode;
                    liste.masanumarasi=orderList2.get(i).masanumarasi;
                    System.out.println("liste = " + liste.toString());

                    System.out.println("orderList2 = " + orderList2.toString());*/
                    orderList2.remove(liste);
                    say++;
                }
            }
            }


        System.out.println("Afiyet olsun");
        //orderList2=new ArrayList<>();
    }
    public void siparislistesi()
    {
        for (Order w:orderList2)
        {
            System.out.printf("Masa no:%-2s   Sipariş kodu:%-5s   Lezzet kodu:%-3s   Adı:%-20s   Adedi:%-2s\n",
                    w.masanumarasi,w.orderCode,w.dish.getKod(),w.dish.getIsim(),w.numOfDish);
        }
    }
}
