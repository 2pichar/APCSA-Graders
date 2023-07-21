package assignment10;

public class Part
{
    private String name;
    private String manufacturer;
    private double price;
public Part()
{
name = "";
manufacturer = "";
price = 0;
}
public Part(String name, String manufacturer, double price)
{
    this.name = name;
    this.manufacturer = manufacturer;
    this.price = price;
}

public String getName()
{
    return name;
}
public String getManufacturer()
{
    return manufacturer;
}
public double getPrice()
{
    return price;
}

public void setName(String name)
{
 this.name = name;
}
public void setManufacturer(String manufacturer)
{
    this.manufacturer = manufacturer;
}
public void setPrice(double price)
{
    this.price = price;
}

public String toString()
{
return "\nName: " + getName() + "\nManufacturer: " + getManufacturer() + "\nPrice: " + getPrice() + "$";
}
//compare the parts with the getname getmanufactuere and getprice with another object
// compare the prices/manufacturer
public boolean equals(Part p)
{
if(p.getName().equals(name) && p.getManufacturer().equals(manufacturer) && p.getPrice() == price)
{
    return true;
}
return false;
}
//Interesting methods

public static boolean isExpensive(double price)
{
    boolean testing = false;
    if(price>400)
    {
        testing = true;
    }
    return testing;
}

}