package innerClasses;

public class CellPhone {

    private String make;

    private String model;

    private Display display;

    private RadioModule gsm;

    private AbstractPhoneButton button;

    //АНОНИМНЫЙ КЛАСС (часто используются)
    public interface AbstractPhoneButton {
        void click();
    }

    public CellPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void turnOn() {
        initDisplay();
        this.gsm = new RadioModule();
        initButton();
    }

    public void initButton() {
        // АНОНИМНЫЙ КЛАСС
        this.button = new AbstractPhoneButton() {
            @Override
            public void click() {
                System.out.println("button clicked");
            }
        };
    }

    public void call(String number) {
        this.button.click();
        this.gsm.call(number);
    }

    private void initDisplay() {
        this.display = new Display();
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public Display getDisplay() {
        return this.display;
    }

}
