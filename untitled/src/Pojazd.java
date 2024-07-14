abstract class Pojazd {
    private String imieWlasciciela;
    private String marka;
    private String model;
    private String nrTablicRejestracyjnych;
    private double kosztNaprawy;
    private String rodzajNaprawy;

    public Pojazd(String imieWlasciciela, String marka, String model,
                  String nrTablicRejestracyjnych, double kosztNaprawy, String rodzajNaprawy) {
        this.imieWlasciciela = imieWlasciciela;
        this.marka = marka;
        this.model = model;
        this.nrTablicRejestracyjnych = nrTablicRejestracyjnych;
        this.kosztNaprawy = kosztNaprawy;
        this.rodzajNaprawy = rodzajNaprawy;
    }

    // Getters and Setters
    public String getImieWlasciciela() {
        return imieWlasciciela;
    }

    public void setImieWlasciciela(String imieWlasciciela) {
        this.imieWlasciciela = imieWlasciciela;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrTablicRejestracyjnych() {
        return nrTablicRejestracyjnych;
    }

    public void setNrTablicRejestracyjnych(String nrTablicRejestracyjnych) {
        this.nrTablicRejestracyjnych = nrTablicRejestracyjnych;
    }

    public double getKosztNaprawy() {
        return kosztNaprawy;
    }

    public void setKosztNaprawy(double kosztNaprawy) {
        this.kosztNaprawy = kosztNaprawy;
    }

    public String getRodzajNaprawy() {
        return rodzajNaprawy;
    }

    public void setRodzajNaprawy(String rodzajNaprawy) {
        this.rodzajNaprawy = rodzajNaprawy;
    }

    // Abstract method
    public abstract void displayInfo();
}
