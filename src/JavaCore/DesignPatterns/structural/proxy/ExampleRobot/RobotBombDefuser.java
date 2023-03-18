package structural.proxy.ExampleRobot;

import java.util.Random;

public class RobotBombDefuser {

    private Random random = new Random();

    private int robotConfigureWaveLength = 41;

    private boolean isConnected;

    public void connectWireless(int communicationWaveLength) {
        if (communicationWaveLength == robotConfigureWaveLength) {
            isConnected = isConnectedImmitatingConnectivitiyIssues();
        }
    }

    private boolean isConnectedImmitatingConnectivitiyIssues() {
        return random.nextInt(0,10) < 4;
    }

    public boolean isConnected() {
        return isConnected = isConnectedImmitatingConnectivitiyIssues();
    }

    public void walkStraightForward(int steps) {
        System.out.println("Did steps forward ..." + steps);
    }

    public void turnRight() {
        System.out.println("Turned right");
    }

    public void turnLeft() {
        System.out.println("Turned left");
    }

    public void defuseBomb() {
        System.out.println("Cut red or green or blue wire...");
    }

}
