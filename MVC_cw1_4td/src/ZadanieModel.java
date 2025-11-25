import java.io.*;
import java.util.*;

public class ZadanieModel {

    private final File file = new File("zadania.txt");

    public ZadanieModel() {
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Zadanie> pobierzWszystkieZadania() {
        List<Zadanie> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String tresc = parts[1];
                    boolean status = Boolean.parseBoolean(parts[2]);
                    lista.add(new Zadanie(id, tresc, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void dodajZadanie(String tresc) {
        List<Zadanie> istniejące = pobierzWszystkieZadania();
        int nextId = istniejące.stream().mapToInt(Zadanie::getId).max().orElse(0) + 1;

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(nextId + "|" + tresc + "|" + false + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void usunZadanie(int id) {
        List<Zadanie> lista = pobierzWszystkieZadania();

        try (FileWriter fw = new FileWriter(file)) {
            for (Zadanie z : lista) {
                if (z.getId() != id) {
                    fw.write(z.getId() + "|" + z.getTresc() + "|" + z.isWykonane() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
