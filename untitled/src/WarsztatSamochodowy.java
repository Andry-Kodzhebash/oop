import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class WarsztatSamochodowy extends JFrame {
    private ArrayList<Pojazd> pojazdy = new ArrayList<>();

    // Components
    private JTextField imieField, markaField, modelField, tabliceField, kosztField, naprawaField;
    private JTextField pojemnoscSilnikaField, rodzajPaliwaField, ladownoscField, typField;
    private JButton addOsobowyButton, addCiezarowyButton, showClientsButton;
    private JTable pojazdyTable;
    private DefaultTableModel tableModel;

    public WarsztatSamochodowy() {
        setTitle("Warsztat Samochodowy");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        imieField = new JTextField(10);
        markaField = new JTextField(10);
        modelField = new JTextField(10);
        tabliceField = new JTextField(10);
        kosztField = new JTextField(10);
        naprawaField = new JTextField(10);
        pojemnoscSilnikaField = new JTextField(10);
        rodzajPaliwaField = new JTextField(10);
        ladownoscField = new JTextField(10);
        typField = new JTextField(10);

        addOsobowyButton = new JButton("Dodaj samochód osobowy");
        addCiezarowyButton = new JButton("Dodaj ciężarówkę");
        showClientsButton = new JButton("Pokaż klientów");

        // Table setup
        String[] columnNames = {"Właściciel", "Marka", "Model", "Nr Tablic", "Rodzaj Naprawy", "Koszt Naprawy", "Pojemność Silnika", "Rodzaj Paliwa", "Ładowność", "Typ"};
        tableModel = new DefaultTableModel(columnNames, 0);
        pojazdyTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(pojazdyTable);

        // Layout setup
        JPanel inputPanel = new JPanel(new GridLayout(11, 2, 5, 5));
        inputPanel.add(new JLabel("Właściciel:"));
        inputPanel.add(imieField);
        inputPanel.add(new JLabel("Marka:"));
        inputPanel.add(markaField);
        inputPanel.add(new JLabel("Model:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Nr Tablic:"));
        inputPanel.add(tabliceField);
        inputPanel.add(new JLabel("Koszt Naprawy:"));
        inputPanel.add(kosztField);
        inputPanel.add(new JLabel("Rodzaj Naprawy:"));
        inputPanel.add(naprawaField);
        inputPanel.add(new JLabel("Pojemność Silnika (L) (Samochód Osobowy):"));
        inputPanel.add(pojemnoscSilnikaField);
        inputPanel.add(new JLabel("Rodzaj Paliwa (Samochód Osobowy):"));
        inputPanel.add(rodzajPaliwaField);
        inputPanel.add(new JLabel("Ładowność (t) (Ciężarówka):"));
        inputPanel.add(ladownoscField);
        inputPanel.add(new JLabel("Typ (Ciężarówka):"));
        inputPanel.add(typField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addOsobowyButton);
        buttonPanel.add(addCiezarowyButton);
        buttonPanel.add(showClientsButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Button actions
        addOsobowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOsobowy();
            }
        });

        addCiezarowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCiezarowy();
            }
        });

        showClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClients();
            }
        });
    }

    private void addOsobowy() {
        String imie = imieField.getText();
        String marka = markaField.getText();
        String model = modelField.getText();
        String tablice = tabliceField.getText();
        double koszt = Double.parseDouble(kosztField.getText());
        String naprawa = naprawaField.getText();
        double pojemnosc = Double.parseDouble(pojemnoscSilnikaField.getText());
        String paliwo = rodzajPaliwaField.getText();

        Osobowy osobowy = new Osobowy(imie, marka, model, tablice, koszt, naprawa, pojemnosc, paliwo);
        pojazdy.add(osobowy);
        tableModel.addRow(new Object[]{imie, marka, model, tablice, naprawa, koszt, pojemnosc, paliwo, "", ""});
    }

    private void addCiezarowy() {
        String imie = imieField.getText();
        String marka = markaField.getText();
        String model = modelField.getText();
        String tablice = tabliceField.getText();
        double koszt = Double.parseDouble(kosztField.getText());
        String naprawa = naprawaField.getText();
        double ladownosc = Double.parseDouble(ladownoscField.getText());
        String typ = typField.getText();

        Ciezarowy ciezarowy = new Ciezarowy(imie, marka, model, tablice, koszt, naprawa, ladownosc, typ);
        pojazdy.add(ciezarowy);
        tableModel.addRow(new Object[]{imie, marka, model, tablice, naprawa, koszt, "", "", ladownosc, typ});
    }

    private void showClients() {
        ArrayList<Pojazd> topClients = new ArrayList<>(pojazdy);
        topClients.sort(Comparator.comparingDouble(Pojazd::getKosztNaprawy).reversed());
        String[] columnNames = {"Właściciel", "Koszt całkowity", "Rabat", "Koszt z rabatem"};
        Object[][] data = new Object[Math.min(5, topClients.size())][4];

        for (int i = 0; i < Math.min(5, topClients.size()); i++) {
            Pojazd p = topClients.get(i);
            double kosztNaprawy = p.getKosztNaprawy();
            boolean hasDiscount = i < 5;
            double costWithDiscount = hasDiscount ? kosztNaprawy * 0.95 : kosztNaprawy;
            data[i][0] = p.getImieWlasciciela();
            data[i][1] = kosztNaprawy;
            data[i][2] = hasDiscount ? "Tak" : "Nie";
            data[i][3] = costWithDiscount;
        }

        JTable clientsTable = new JTable(data, columnNames);
        JOptionPane.showMessageDialog(this, new JScrollPane(clientsTable), "Klienci", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WarsztatSamochodowy().setVisible(true);
            }
        });
    }
}
