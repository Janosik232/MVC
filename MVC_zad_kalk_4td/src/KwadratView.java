import javax.swing.*;
import java.awt.event.ActionListener;

public class KwadratView extends JFrame {
    private JLabel kwadratLabel = new JLabel("kwadrat liczby: 0");
    private JTextField liczba1 = new JTextField(3);
    private JButton oblicz = new JButton("Oblicz");

    public KwadratView() {
        super("Licznik MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.add(kwadratLabel);
        panel.add(liczba1);
        panel.add(oblicz);
        this.add(panel);
    }
    public String inputText(){
        return liczba1.getText();
    }
    public void setWynik(int liczba){
        kwadratLabel.setText("kwadrat liczby: " + liczba);
    }

    public void addObliczListener(ActionListener listenForObliczButton) {
       oblicz.addActionListener(listenForObliczButton);
    }

}