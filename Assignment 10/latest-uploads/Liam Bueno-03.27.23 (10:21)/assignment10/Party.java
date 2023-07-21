package assignment10;

public class Party {
    private int numGuests;
    private String location;
    private String[] guestList;

    public Party() {
        numGuests = 10;
        location = "Lake Forest, California";
    }

    public Party(int guest) {
        numGuests = guest;
        location = "Lake Forest, California";
    }

    public Party(int guest, String loc) {
        numGuests = guest;
        location = loc;
    }

    public Party(int guest, String loc, String[] list) {
        numGuests = guest;
        location = loc;
        guestList = list;
    }
    public long guestsFactorial() {
        if (this.getGuests() > 1) {
            this.kickGuest();
            return this.getGuests() * this.guestsFactorial();
        } else {
            return 1;
        }
    }

    public void kickGuest() {
        this.numGuests -= 1;
    }

    public int getGuests() {
        return this.numGuests;
    }

    public String printGuests() {
       String out = "";
        for(String e : guestList) {
            out+= e + " ";
        }
    return out;
    }
    public void throwParty() {
        System.out.println("A party is being thrown at " + this.location + "!" + "\n Guests: " + this.printGuests());
    }
}