public class Osobowy extends Pojazd {
    private double pojemnoscSilnika;
    private String rodzajPaliwa;

    public Osobowy(String imieWlasciciela, String marka, String model,
                   String nrTablicRejestracyjnych, double kosztNaprawy, String rodzajNaprawy,
                   double pojemnoscSilnika, String rodzajPaliwa) {
        super(imieWlasciciela, marka, model, nrTablicRejestracyjnych, kosztNaprawy, rodzajNaprawy);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    @Override
    public void displayInfo() {
        System.out.println("Osobowy: " + this.getMarka() + " " + this.getModel());
    }

    // Getters and Setters for the new fields
    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(double pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }
}
