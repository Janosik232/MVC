import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public JTextField textWiek;
    public JCheckBox checkRegulamin;
    public JButton btnZatwierdz;
    public JButton btnStatus;

    public MainView() {
        super("Ustawianie właściwości");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 4, 10, 10));
        setSize(350, 200);

        textWiek = new JTextField("wprowadź swój wiek");
        checkRegulamin = new JCheckBox("Akceptuję regulamin");
        btnZatwierdz = new JButton("Zatwierdź");
        btnStatus = new JButton("Nie zatwierdzony");
        btnStatus.setEnabled(false);

        add(textWiek);
        add(checkRegulamin);
        add(btnZatwierdz);
        add(btnStatus);

        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
}
