package dt.RestaurantBillGenerator;

public class Dish
{
    private int kod;
    private String isim;
    private double fiyat;

    public Dish(int kod, String isim, double fiyat)
    {
        this.kod = kod;
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public int getKod()
    {
        return kod;
    }

    public String getIsim()
    {
        return isim;
    }

    public double getFiyat()
    {
        return fiyat;
    }

    @Override
    public String toString() {
        return  "kod=" + kod +
                ", isim='" + isim + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
