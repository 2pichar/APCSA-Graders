package assignment10;

public class Shoes extends Shoebox {
    private int size;
    private String material;

    public Shoes(){
        size = 10;
        material = "leather";
    }

    public Shoes(int s, String m){
        size = s;
        material = m;
    }
    public void setShoeSize(int s){
        size = s;
    }
    public void setMaterial(String m){
        material = m;
    }
    public int getSize() {
        return size;
    }
    public String getMaterial() {
        return material;
    }
    public String materials() {
        if (size > 10) {
            return "This shoe is made of 50% recycled material!";
        } else {
            return "This box is made of 100% recycled materials!";
        }
    }
    public String toString() {
            return "This shoe on your shelf is the size " + size + " and its made of " + material + ".";
    }
}
