import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KwadratController {
    private KwadratModel model;
    private KwadratView view;

    public KwadratController(KwadratModel model, KwadratView view) {
        this.model = model;
        this.view = view;


        this.view.addObliczListener(new KwadratListener());

    }

    class KwadratListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = view.inputText();
            int liczba = Integer.parseInt(text);

            int wynik = model.obliczKwadrat(liczba);

            view.setWynik(wynik);
        }
    }
}