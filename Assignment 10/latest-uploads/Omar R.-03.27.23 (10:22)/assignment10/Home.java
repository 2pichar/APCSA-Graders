package assignment10;

class Home {
    String address;
    int numberOfRooms;

    public Home() {
        this.address = "Unknown";
        this.numberOfRooms = 0;
    }

    public Home(String address, int numberOfRooms) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }
    public void printDetails() {
        System.out.println("Address: " + address);
        System.out.println("Number of rooms: " + numberOfRooms);
    }
}
