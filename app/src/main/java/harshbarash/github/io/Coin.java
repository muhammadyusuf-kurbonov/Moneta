package harshbarash.github.io;

public class Coin {
    public String nominal;
    public String condition;
    public String magnetic;
    public String yard;
    public String kant;
    public String gurt;
    public String year;
    public String description;
    public String price;
    public String myprice;

    public Coin(String nominal, String condition, String magnetic, String yard,
                String kant, String gurt, String year, String description, String price, String myprice) {
        this.nominal = nominal;
        this.condition = condition;
        this.magnetic = magnetic;
        this.yard = yard;
        this.kant = kant;
        this.gurt = gurt;
        this.year = year;
        this.description = description;
        this.price = price;
        this.myprice = myprice;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMagnetic() {
        return magnetic;
    }

    public void setMagnetic(String magnetic) {
        this.magnetic = magnetic;
    }

    public String getYard() {
        return yard;
    }

    public void setYard(String yard) {
        this.yard = yard;
    }

    public String getKant() {
        return kant;
    }

    public void setKant(String kant) {
        this.kant = kant;
    }

    public String getGurt() {
        return gurt;
    }

    public void setGurt(String gurt) {
        this.gurt = gurt;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMyprice() {
        return myprice;
    }

    public void setMyprice(String myprice) {
        this.myprice = myprice;
    }
}
