package JavaCore.DesignPatterns.prototype;

public class HumanFactory {

    Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }

}
