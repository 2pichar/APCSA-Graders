package assignment10;

class Apartment extends Home {
    int monthlyRent;
    boolean hasBalcony;

    public Apartment(
        String address,
        int numberOfRooms,
        int monthlyRent,
        boolean hasBalcony
    ) {
        super(address, numberOfRooms);
        this.monthlyRent = monthlyRent;
        this.hasBalcony = hasBalcony;
    }

    public Apartment() {
        super();
        this.monthlyRent = 0;
        this.hasBalcony = false;
    }

    public int getRent() {
        return monthlyRent;
    }

    public int calcRent(int months) {
        if (months == 0) {
            return 0;
        }
        return calcRent(months - 1) + monthlyRent;
    }
    @Override public void printDetails() {
        super.printDetails();
        System.out.println("Monthly rent: $" + monthlyRent);
        System.out.println("Has balcony: " + hasBalcony);
    }
}
