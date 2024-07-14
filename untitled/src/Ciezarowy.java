public class Ciezarowy extends Pojazd {
    private double ladownosc;
    private String typ;

    public Ciezarowy(String imieWlasciciela, String marka, String model,
                     String nrTablicRejestracyjnych, double kosztNaprawy, String rodzajNaprawy,
                     double ladownosc, String typ) {
        super(imieWlasciciela, marka, model, nrTablicRejestracyjnych, kosztNaprawy, rodzajNaprawy);
        this.ladownosc = ladownosc;
        this.typ = typ;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ciezarowy: " + this.getMarka() + " " + this.getModel());
    }

    // Getters and Setters for the new fields
    public double getLadownosc() {
        return ladownosc;
    }

    public void setLadownosc(double ladownosc) {
        this.ladownosc = ladownosc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
