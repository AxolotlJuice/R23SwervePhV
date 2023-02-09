package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;

public class Arm {

    private Pose2d          armPose;
    private double          radius;
    private  double         radians;

    public Arm(){

    }

    public void initialize(){

    }

    public void periodic(){

    }

    public void setArmPose(double power, Pose2d targetPose){
        
        radius = targetPose.getX()/Math.acos(targetPose.getX());
        radians = Math.asin(targetPose.getY()/radius);
        actionTime = 0.5/radius
        2ndPower = radius/()


        armMotor1.setPower(0.5);
        armMotor2.setPower(2ndPower);
        sleep(actionTime);

        //xDist = radius * Math.cos(radians);
        //yDist = radius * Math.sin(radians);
        
    }

    public void setArmPower(double power, double degrees, double distExtension){

    }

}
