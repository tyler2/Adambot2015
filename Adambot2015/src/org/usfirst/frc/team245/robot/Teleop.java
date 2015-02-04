package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Teleop {
	// get joystick values and call appropriate methods
	static Joystick joy = new Joystick(1);
	public static void doWerk() {
		/*Drive.Drive.DriveSpeed(Gamepad.primary.getLeftX(),
				Gamepad.primary.getLeftY(), Gamepad.primary.getRightX());*/
		//Drive.Drive.test();
		//TESTING THE ACCELEROMETER
		Auton.DistanceFromAcceleration.DFromA();
		SmartDashboard.putNumber("X displacement",Auton.DistanceFromAcceleration.getX());
		SmartDashboard.putNumber("Y displacement",Auton.DistanceFromAcceleration.getY());
		if(joy.getRawButton(1)){
			Auton.LandmarkPlacement.update();
			SmartDashboard.putString("testing auton", "test");
		}
		else if(joy.getRawButton(2)){
			Auton.DistanceFromAcceleration.positionX=0;
			Auton.DistanceFromAcceleration.positionY=0;
			Auton.LandmarkPlacement.stage=0;		
		}
		else{
			Drive.Drive.DriveSpeed(Gamepad.primary.getLeftX(),Gamepad.primary.getLeftY(), Gamepad.primary.getRightX());
		}
	}
}
