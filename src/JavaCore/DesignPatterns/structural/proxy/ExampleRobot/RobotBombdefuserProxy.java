package JavaCore.DesignPatterns.structural.proxy.ExampleRobot;

public class RobotBombdefuserProxy extends RobotBombDefuser {

    private RobotBombDefuser robotBombDefuser;

    private int communicationWaveLength;

    private int connectionAttempts = 3;

    public RobotBombdefuserProxy(int communicationWaveLength) {
        robotBombDefuser = new RobotBombDefuser();
        this.communicationWaveLength = communicationWaveLength;
    }

    @Override
    public void walkStraightForward(int steps) {
        ensureConnectedWithRobot();
        robotBombDefuser.walkStraightForward(steps);
    }

    @Override
    public void turnRight() {
        ensureConnectedWithRobot();
        robotBombDefuser.turnRight();
    }

    @Override
    public void turnLeft() {
        ensureConnectedWithRobot();
        robotBombDefuser.turnLeft();
    }

    @Override
    public void defuseBomb() {
        ensureConnectedWithRobot();
        robotBombDefuser.defuseBomb();
    }

    private void ensureConnectedWithRobot() {
        if (robotBombDefuser == null) {
            robotBombDefuser = new RobotBombDefuser();
            robotBombDefuser.connectWireless(communicationWaveLength);
        }
        for (int i = 0; i < connectionAttempts; i++) {
            if (robotBombDefuser.isConnected() != true) {
                robotBombDefuser.connectWireless(communicationWaveLength);
            }else {
                break;
            }
        }
        if(robotBombDefuser.isConnected() != true) {
            throw new RuntimeException("no connection with remote bomb");
        }
    }

}
