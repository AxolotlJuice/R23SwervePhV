package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import Team4450.Lib.SynchronousPID;
import Team4450.Lib.Util;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class SimultaneousArmPID  {
    
    private SynchronousPID          pid1 = new SynchronousPID(0, 0, 0);
    private SynchronousPID          pid2 = new SynchronousPID(0, 0, 0);

    private CANSparkMax             armMotor1;
    private CANSparkMax             armMotor2;

    private double                  speedExtend;
    private double                  speedRotate;
    private double                  startTime;
    private double                  tempTime;
    private double                  elapsedTime;
    private double                  targetVal1;
    private double                  targetVal2;

    public SimultaneousArmPID(CANSparkMax armMotor1, CANSparkMax armMotor2, double targetVal1, double targetVal2){
        this.armMotor1 = armMotor1;
        this.armMotor2 = armMotor2;
        this.targetVal1 = targetVal1;
        this.targetVal2 = targetVal2;
    }

    public void initialize(){
        startTime = Util.timeStamp();
        tempTime = Util.timeStamp();

    }
    
    public void execute(){
        elapsedTime = Util.getElaspedTime(tempTime);

        speedExtend = pid1.calculate(armMotor1.getEncoder().getPosition(), tempTime);
        speedRotate = pid2.calculate(armMotor2.getEncoder().getPosition(), tempTime);
    }

    public void isFinished(){

    }

    public void end(){
        
    }
}
