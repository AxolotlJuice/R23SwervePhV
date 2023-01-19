package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import static frc.robot.Constants.*;

public class AutoAimVision extends PIDCommand {

    private static double       kP = .02, kI = .02, kD = 0;
    private double              kToleranceDeg = .5;
    private PhotonCamera        phCamera;
    private boolean             hasTarget, targetLocked;
    private var result

    public AutoAimVision(PhotonCamera phCamera, ){
        
        while(){
            result = phCamera.getLatestResult();
            
            translation = PhotonUtils.estimateCameraToTargetTranslation(
                distanceMeters, Rotation2d.fromDegrees(-target.getYaw()));
            
                if(result.hasTarget){
                double range =
                                PhotonUtils.calculateDistanceToTargetMeters(
                                        CAMERA_HEIGHT_METERS,
                                        TARGET_HEIGHT_METERS,
                                        CAMERA_PITCH_RADIANS,
                                        Units.degreesToRadians(result.getBestTarget().getPitch()));

                //figure out the y traslation
                //calc distance based on x and y
                estimateCameraToTargetTranslation()
                //find need yaw, based on closest apirl tag
                //use swerve drive method to translate
                //find what data PipelineResult provides
                
                /*use:
                    estimateCameraToTargetTranslation(estimateFieldToRobotAprilTag(), )
                    Translation2d translation = PhotonUtils.estimateCameraToTargetTranslation(
                    distanceMeters, Rotation2d.fromDegrees(-target.getYaw()));
                 */
            
                /* methods to remember:
                    getTargets
                */
            }
        }
        
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
