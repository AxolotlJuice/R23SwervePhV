/* 
figure out the y traslation
calc distance based on x and y
estimateCameraToTargetTranslation()
find need yaw, based on closest apirl tag
use swerve drive method to translate
find what data PipelineResult provides
                
use:
    estimateCameraToTargetTranslation(estimateFieldToRobotAprilTag(), )
    Translation2d translation = PhotonUtils.estimateCameraToTargetTranslation(
    distanceMeters, Rotation2d.fromDegrees(-target.getYaw()));
                    
    PhotonPoseEstimatorTest

    continue...

            
methods to remember:
    getTargets

Plan:   1. create PhotonCamera
        2. get latest photon result
        3. distiguish between apirlTag and reflective tape
            4. get distance to target
            5. get cameraToTargetYaw
            6.enter into swerve drive
        3. if(aprilTag)
            4. 


*/
package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.PhotonPoseEstimator;
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
    

    public AutoAimVision(PhotonCamera phCamera, ){
        
        var result = phCamera.getLatestResult();
        PhotonPoseEstimator.leastAbiguityStrategy();

        //if(reflectiveTape){
            
        //}
        
        /* 
        while(){
            var result = phCamera.getLatestResult();
            
            translation = PhotonUtils.estimateCameraToTargetTranslation(
                distanceMeters, Rotation2d.fromDegrees(-target.getYaw()));
            
                if(result.hasTarget){
                double range =
                hehe haha
                                PhotonUtils.calculateDistanceToTargetMeters(
                                        CAMERA_HEIGHT_METERS,
                                        TARGET_HEIGHT_METERS,
                                        CAMERA_PITCH_RADIANS,
                                        Units.degreesToRadians(result.getBestTarget().getPitch()));

                
                
            }
        }
        */
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
