package controller;

import model.EncryptionModel;
import view.UserView;

public class EncryptionController {
    private EncryptionModel model;
    private UserView view;

    public EncryptionController(EncryptionModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void encryptText() {
        String inputText = view.getInputText();
        model = new EncryptionModel(inputText);
        String encryptedText = model.encryptText();
        String key = model.getKey();
        view.setOutputText(encryptedText);
        view.setKeyText(key);
    }


}

