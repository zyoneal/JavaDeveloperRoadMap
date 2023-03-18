package structural.proxy.ExampleRobot;

public class Demo {

    public static void main(String[] args) {
        int opNum = 0;
        try {
            RobotBombdefuserProxy proxy = new RobotBombdefuserProxy(41);
            proxy.walkStraightForward(100);
            opNum++;
            proxy.turnRight();
            opNum++;
            proxy.walkStraightForward(5);
            opNum++;
            proxy.defuseBomb();
            opNum++;
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println("Exception has been caught with message: " + e.getMessage() + "Decided to have human operate robot there.");
            planB(opNum);
        }
    }

    private static void planB(int nextOperationNum)
    {
        RobotBombDefuser humanOperatingRobotDirectly = new RobotBombDefuser();
        if(nextOperationNum == 0)
        {
            humanOperatingRobotDirectly.walkStraightForward(100);
            nextOperationNum++;
        }
        if (nextOperationNum == 1)
        {
            humanOperatingRobotDirectly.turnRight();
            nextOperationNum++;
        }
        if (nextOperationNum == 2)
        {
            humanOperatingRobotDirectly.walkStraightForward(5);
            nextOperationNum++;
        }
        if (nextOperationNum == 3)
        {
            humanOperatingRobotDirectly.defuseBomb();
        }
    }

}
