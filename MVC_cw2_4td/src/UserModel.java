public class UserModel {

    public boolean Register(int wiek, boolean regulamin) {
        return wiek >= 18 && regulamin;
    }
}
