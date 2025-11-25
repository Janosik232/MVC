import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserModel model = new UserModel();
            MainView view = new MainView();
            new MainController(model, view);
        });
    }
}
