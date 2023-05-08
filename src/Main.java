import controller.EncryptionController;
import model.EncryptionModel;
import view.UserView;

public class Main {
    public static void main(String[] args) {

        EncryptionModel model = new EncryptionModel("");
        UserView view = new UserView();
        EncryptionController controller = new EncryptionController(model, view);

        view.setEncryptButtonListener(controller);
        view.init();
    }
}