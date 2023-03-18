package innerClasses;

public class RadioModule {

    public RadioModule() {
        System.out.println("radio module initialize");
    }

    public void call(String number) {
        int lenght = 10;

        // ЛОКАЛЬНЫЙ КЛАСС (редко используется)
        class GSMModule {
            private String phoneNumber;
            private int validNumber;

            public GSMModule(String number) {
                this.phoneNumber = number;
            }

            public boolean isValid() {
                if (phoneNumber.length() != lenght) {
                    return false;
                }
                else {
                    try {
                    validNumber = Integer.parseInt(phoneNumber);
                    return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
            }
            public void dialIn(){
                if (isValid()){
                    System.out.println("Calling for number " + phoneNumber);
                }
                else {
                    System.out.println("Phone number is invalid. Please correct phone number");
                }
            }
        }
        GSMModule module = new GSMModule(number);
        module.dialIn();
    }

}
