package assignment10;

class VeggiePizza extends Pizza {
    protected String veggies;
    protected boolean isGlutenFree;

    public VeggiePizza() {
        super();
        veggies = "mushrooms";
        isGlutenFree = false;
    }

    public VeggiePizza(String t, String s, String d, String v, boolean gf) {
        super(t, s, d);
        veggies = v;
        isGlutenFree = gf;
    }

    @Override
    public String getSize() {
        return "This veggie pizza is " + size;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean gf) {
        isGlutenFree = gf;
    }

    public void addVeggies(String v) {
        veggies += ", " + v;
    }

    public String getVeggies() {
        return veggies;
    }
}