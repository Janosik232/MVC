import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public DefaultListModel<Zadanie> listModel;
    public JList<Zadanie> listaZadan;

    public JTextField poleTresc;
    public JButton btnDodaj;
    public JButton btnUsun;

    public View() {
        setTitle("To-Do Lista – MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        listaZadan = new JList<>(listModel);

        poleTresc = new JTextField();
        btnDodaj = new JButton("Dodaj zadanie");
        btnUsun = new JButton("Usuń zaznaczone");

        JPanel panelDodaj = new JPanel(new GridLayout(1, 2));
        panelDodaj.add(poleTresc);
        panelDodaj.add(btnDodaj);

        add(new JScrollPane(listaZadan), BorderLayout.CENTER);
        add(panelDodaj, BorderLayout.NORTH);
        add(btnUsun, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
