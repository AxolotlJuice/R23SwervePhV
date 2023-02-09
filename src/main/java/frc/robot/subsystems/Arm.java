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

        

        //xDist = radius * Math.cos(radians);
        //yDist = radius * Math.sin(radians);
        
    }

    public void setArmPower(double power){

    }

}
