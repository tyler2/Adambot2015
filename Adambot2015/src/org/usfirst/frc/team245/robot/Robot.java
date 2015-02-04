
package org.usfirst.frc.team245.robot;


import Auton.LandmarkPlacement;
import Auton.Test;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Cameras cam = new Cameras();
	public double autonMode=0; 
	Victor a = new Victor(3);    
    public void robotInit() {
    	Auton.DistanceFromAcceleration.init();
    	Drive.Drive.init();
    	SmartDashboard.putString("Init Completed", " ");
    	cam.start();
    	Auton.LandmarkPlacement.init();
    }

    
    public void autonomousPeriodic() {
    	
    	SmartDashboard.putNumber("Auton Mode selected", autonMode);
    	//LandmarkPlacement.update();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        try{
        	//Teleop.doWerk();
        	//cam.start();
        	//Switchbox.update();
        	a.set(1);
        	Interior.Interior.currentCheck();
        }
        catch(Exception e){
        	SmartDashboard.putString("the exception was:", e.toString());
        }
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    @Override
    public void disabledPeriodic() {
    	// TODO Auto-generated method stub
    	super.disabledPeriodic();
    	autonMode = SmartDashboard.getNumber("Auton Mode selector");
    	
    }
    
}
