package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Arm {

    private Pose2d          armPose;

    private double          radius;
    private double          radians;
    private double          actionTime;
    private double          power2;
    private double          radianPerSecond;

    //channel tbd
    private PWMSparkMax     armMotor1 = new PWMSparkMax(0);

    //channel tbd
    private PWMSparkMax     armMotor2 = new PWMSparkMax(0);

    public Arm(){

    }

    public void initialize(){

    }

    public void periodic(){

    }

    public void setArmPose(double power, Pose2d targetPose){
        double radianPerSecond = 0.0;
        radius = targetPose.getX()/Math.acos(targetPose.getX());
        radians = Math.asin(targetPose.getY()/radius);
        actionTime = 0.5/radius;
        power2 = radius/(radianPerSecond);


        armMotor1.set(0.5);
        armMotor2.set(power2);
        sleep(actionTime);

        //xDist = radius * Math.cos(radians);
        //yDist = radius * Math.sin(radians);
        
    }

    public void setArmPower(double power, double degrees, double distExtension){

    }

}
