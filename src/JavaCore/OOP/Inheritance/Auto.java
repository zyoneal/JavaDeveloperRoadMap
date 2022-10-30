package JavaCore.OOP.Inheritance;

// Main Abstract class of Autos
public abstract class Auto {

    private String producer;

    private String model;

    private Engine engine;

    private int currentSpeed;

    protected boolean isRunning;

    public Auto(String producer, String model, Engine engine) {
        this.producer = producer;
        this.model = model;
        this.engine = engine;
        System.out.println("Auto was initialized");
    }

    public abstract void energize();

    public void start() {
        isRunning = true;
        currentSpeed = 10;
        System.out.println("Auto is starting");
    }

    public void stop() {
        isRunning = false;
        currentSpeed = 0;
        System.out.println("Auto is stopped");
    }

    public void accelerate(int kmPerHours) {
        currentSpeed += kmPerHours;
        System.out.println("Accelerating. Current speed is " + currentSpeed + " kmPerHours");
    }

    public Engine getEngine() {
        return engine;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

/*
    public EngineType getType() {
        return engine;
    }

    public void setType(EngineType type) {
        this.engine = type;
    }*/

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", type=" + engine +
                ", currentSpeed=" + currentSpeed +
                ", isRunning=" + isRunning +
                '}';
    }

}
