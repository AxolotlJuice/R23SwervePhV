package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import Team4450.Lib.SynchronousPID;
import Team4450.Lib.Wpilib.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Arm {

    private Pose2d          armPose;

    private double          radius;
    private double          radians;
    private double          actionTime;
    private double          power2;
    private double          radianPerSecond;

    //channel tbd
    private CANSparkMax     armMotor1 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

    //channel tbd
    private CANSparkMax     armMotor2 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

    private PIDController   pidController = new PIDController()

    public Arm(){
        SynchronousPID
    }

    public void initialize(){
        armMotor1.getEncoder().getPosition()
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
        armMotor2.set(0.5);
        
        PIDController

        //xDist = radius * Math.cos(radians);
        //yDist = radius * Math.sin(radians);
        

        //trying PID
        //use get methods and convert to Pose 3d

        //MOTORS: CANSparkMax talon:TalonFX
        //relativeEncoder
        //Talon TalonFXMotorController
        armMotor1.getPIDController
    }

    public void setArmPower(double extensionPower, double degrees, double distExtension){

    }

}
