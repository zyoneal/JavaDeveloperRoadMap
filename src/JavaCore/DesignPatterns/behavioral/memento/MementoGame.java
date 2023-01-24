package JavaCore.DesignPatterns.memento;

// Хранитель используется тогда, когда вы хотите отменять операции
//без отображения внутренней структуры Хозяина (Originator, или игры в
//нашем примере). Координация операций осуществляется Опекуном
//(Caretaker, или контроллером игры), который дает возможность простого
//сохранение мгновенных состояний системы без представления о том, чем эти
//состояния есть.

public class MementoGame {

    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL1", 30000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());


        game.set("LVL2", 55000);
        System.out.println(game);

        System.out.println("Загружаемся...");
        game.load(file.getSave());
        System.out.println(game);
    }

}
