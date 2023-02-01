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

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.SwerveDriveBase;

import static frc.robot.Constants.*;

public class AutoAimVision extends PIDCommand {

    private static double       kP = .02, kI = .02, kD = 0;
    private double              kToleranceDeg = .5;
    private PhotonCamera        phCamera;
    private boolean             hasTarget, targetLocked;
    private double              instThrottle;
    private double              instStrafe;

    public AutoAimVision(PhotonCamera phCamera, SwerveDriveBase sDriveBase, PhotonPoseEstimator photonPoseEstimator){
        // the below is all sudo-code
        var result = phCamera.getLatestResult();
        
        // Unsure if this line is even useful as this is already done, commented out
        // photonPoseEstimator.leastAbiguityStrategy(result);

        rotateRobot(-result.getBestTarget().getYaw());
        result = phCamera.getLatestResult();
        
        instThrottle = hypotFromTransform3d(result.getBestTarget().getBestCameraToTarget()) * Math.sin(result.getBestTarget().getYaw());
        instStrafe = hypotFromTransform3d(result.getBestTarget().getBestCameraToTarget()) * Math.cos(result.getBestTarget().getYaw());
        sDriveBase.drive(instThrottle, instStrafe, 0.0);


    }

    public void initialize(){
        
    }

    public boolean isFinished(){
        //change later v
        return false;
    }

    public void end(){

    }
    
    private double hypotFromTransform3d(Transform3d tr) {
        return Math.sqrt(Math.pow(tr.getX(), 2) + Math.pow(tr.getY(), 2));
    }

    // Placeholder methods so errors dont annoy me
    void rotateRobot(double statement) { }
}
