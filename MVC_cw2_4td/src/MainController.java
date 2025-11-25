import javax.swing.*;

public class MainController {

    private final UserModel model;
    private final MainView view;

    public MainController(UserModel model, MainView view) {
        this.model = model;
        this.view = view;

        initController();
    }

    private void initController() {

        view.btnZatwierdz.addActionListener(e -> {

            String text = view.textWiek.getText().trim();
            int wiek;

            try {
                wiek = Integer.parseInt(text);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        view,
                        "Wprowadź poprawny wiek (liczbę)!",
                        "Błąd danych",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            boolean regulamin = view.checkRegulamin.isSelected();


            if (model.Register(wiek, regulamin)) {
                view.btnStatus.setEnabled(true);
                view.btnStatus.setText("Zatwierdzony");
                view.btnZatwierdz.setEnabled(false);

                JOptionPane.showMessageDialog(view, "Rejestracja pomyślna!");
            } else {
                JOptionPane.showMessageDialog(
                        view,
                        "Wymagany wiek 18+ oraz akceptacja regulaminu!",
                        "Błędne dane",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
    }
}
