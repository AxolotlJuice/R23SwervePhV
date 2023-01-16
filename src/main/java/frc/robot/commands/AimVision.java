package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import static frc.robot.Constants.*;

public class AimVision extends PIDCommand {

    private static double       kP = .02, kI = .02, kD = 0;
    private double              kToleranceDeg = .5;
    private PhotonCamera        phCamera;
    private boolean             hasTarget, targetLocked;

    public AimVision(PhotonCamera phCamera, ){
        var result = phCamera.getLatestResult();
        
        if(result.hasTarget){
            double range =
                            PhotonUtils.calculateDistanceToTargetMeters(
                                    CAMERA_HEIGHT_METERS,
                                    TARGET_HEIGHT_METERS,
                                    CAMERA_PITCH_RADIANS,
                                    Units.degreesToRadians(result.getBestTarget().getPitch()));
    }

    public void initialize(){
        
    }

    public boolean isFinished(){
        //change later v
        return false;
    }

    public void end(){

    }
    
}
