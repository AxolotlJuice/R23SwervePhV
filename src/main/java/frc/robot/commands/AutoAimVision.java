package frc.robot.commands;


import Team4450.Lib.*;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.targeting.PhotonPipelineResult;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.SwerveDriveBase;


import static frc.robot.Constants.*;


public class AutoAimVision extends PIDCommand {


    private static double       kP = .02, kI = .02, kD = 0;
    private double              kToleranceDeg = .5;
    private boolean             hasTarget, targetLocked;
   
    private double              instThrottle;
    private double              instStrafe;


    private SwerveDriveBase     sDriveBase;
    private PhotonCamera        phCamera;
    private PhotonPoseEstimator phPoseEstimator;
   
    private double              latestAprilTimestamp;
    private double              targetToRobotDist;

    private Pose2d              latestAprilPose2d;
    private Pose3d              latestTargetPose;
    private Pose2d              latestRobotPose;
    private Pose2d              targetPose2d;
    
    private AprilTagFieldLayout tagLayout;
    private Translation2d       limeLightToCenter;


    public AutoAimVision(PhotonCamera phCamera,
                            SwerveDriveBase sDriveBase,
                            AprilTagFieldLayout tagLayout,
                            PhotonPoseEstimator phPoseEstimator,
                            Translation2d limeLightToCenter,
                            Translation2d PIDOrSomething)
    {
       
        this.phCamera = phCamera;
        this.sDriveBase = sDriveBase;
        this.phPoseEstimator = phPoseEstimator;
        this.tagLayout = tagLayout;
        this.limeLightToCenter = limeLightToCenter;

    }


    public void initialize(){
        //check, isFinished = true?
        
        var result = phCamera.getLatestResult();

        if(result.hasTargets()){
            //obtains the Robots pose according to the PhotonVision
            latestAprilPose2d = phPoseEstimator.update().get().estimatedPose.toPose2d();
            latestAprilTimestamp = phPoseEstimator.update().get().timestampSeconds;
        
            //Find the target's pose
            targetPose2d = tagLayout.getTags().get(result.getBestTarget().getFiducialId()).pose.toPose2d();

            //merges PhotonVision pose and Odometry pose to calculate to the lateset robot pose
            sDriveBase.getOdometry().addVisionMeasurement(latestAprilPose2d, latestAprilTimestamp);
            latestRobotPose = sDriveBase.getOdometry().getEstimatedPosition();

            //claculate distance between aprilTag and robot (turn pose2d ---> pose3d)
            targetToRobotDist = Math.sqrt(Math.pow(Math.abs(targetPose2d.getX() - latestRobotPose.getX()), 2.0)
                + Math.pow(Math.abs(targetPose2d.getY() - latestRobotPose.getY()), 2.0));

            //get the direction the robot needs to go in
            instThrottle = targetToRobotDist * Math.sin(result.getBestTarget().getYaw());
            instStrafe = targetToRobotDist * Math.cos(result.getBestTarget().getYaw());
        
            //drive in the drection
            sDriveBase.drive(instThrottle, instStrafe, -result.getBestTarget().getYaw());

        }
    }


    public boolean isFinished(){
        return true;
    }


    public void end(){
        

    }
   
}
