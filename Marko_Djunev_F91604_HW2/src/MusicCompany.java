public class MusicCompany {
    private String name;
    private Director director;
    private double minPrice;
    private Studio studio;

    public MusicCompany(String name,double minPrice, Director director, Studio studio){
        this.name = name;
        this.minPrice = minPrice;
        this.director = director;
        this.studio = studio;
    }

    public void set_Studio_Price(Studio studio, double price){
        if (price < this.minPrice){
            System.out.println("The price of the studio must be at least " + this.minPrice);
            return;
        }
        studio.set_Price(price);
    }

    public void change_Studio_price(Studio studio, double newPrice){
        if (newPrice < this.minPrice){
            System.out.println("The price of the studio must be at least " + this.minPrice);
            return;
        }

        studio.set_Price(newPrice);
    }

    public double get_MinPrice(double price){
        return this.minPrice;
    }

    public void decrease_Studio_Price(Studio studio, double percentage){
        double newPrice = studio.get_Price() * ((100 - percentage) / 100);
        if (newPrice < this.minPrice){
            System.out.println("The price of the Studio cannot be less than the minimum price of the Music Company");
            return;
        }

        studio.set_Price(newPrice);
    }

    public int get_Director_Age(){
        return this.director.get_Age();
    }

    public String get_Name(){
        return this.name;
    }
}
