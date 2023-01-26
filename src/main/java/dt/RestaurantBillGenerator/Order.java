package dt.RestaurantBillGenerator;

public class Order
{
        public int orderCode;
        public Dish dish;
        public int numOfDish;
        public double orderPrice;
        public byte masanumarasi;

    public Order(Dish dish, int numOfDish,byte masano)
    {
        this.dish = dish;
        this.numOfDish = numOfDish;
        masanumarasi=masano;
    }
    public void fiyathesapla()
    {
        this.orderPrice=this.dish.getFiyat()*this.numOfDish;

    }
    public Order()
    {}
   /* public void setOrderCode(int orderCode)
    {
    this.orderCode=orderCode;
    }*/

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", dish=" + dish +
                ", numOfDish=" + numOfDish +
                ", orderPrice=" + orderPrice +
                ", masanumarasi=" + masanumarasi +
                '}';
    }
}
