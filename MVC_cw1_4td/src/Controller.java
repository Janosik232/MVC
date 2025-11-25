import javax.swing.*;
import java.util.List;

public class Controller {

    private final ZadanieModel model;
    private final View view;

    public Controller(ZadanieModel model, View view) {
        this.model = model;
        this.view = view;

        odswiezListe();
        initListeners();
    }

    private void initListeners() {

        view.btnDodaj.addActionListener(e -> {
            String tresc = view.poleTresc.getText().trim();
            if (tresc.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Wpisz treść zadania!");
                return;
            }

            model.dodajZadanie(tresc);
            view.poleTresc.setText("");

            odswiezListe();
        });

        view.btnUsun.addActionListener(e -> {
            Zadanie wybrane = view.listaZadan.getSelectedValue();

            if (wybrane == null) {
                JOptionPane.showMessageDialog(view, "Wybierz zadanie do usunięcia!");
                return;
            }

            model.usunZadanie(wybrane.getId());
            odswiezListe();
        });
    }

    private void odswiezListe() {
        List<Zadanie> lista = model.pobierzWszystkieZadania();

        view.listModel.clear();
        for (Zadanie z : lista) {
            view.listModel.addElement(z);
        }
    }
}
