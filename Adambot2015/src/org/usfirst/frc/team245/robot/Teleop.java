package org.usfirst.frc.team245.robot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Teleop {
	// get joystick values and call appropriate methods
	//static Joystick joy = new Joystick(1);
	public static boolean exteriorLockAndLift = false;
	public static boolean interiorLift = false;
	public static boolean placeTotes = false;
	/*public static File file = new File("GhostMode.txt");
	public static FileWriter f;*/
	public static void doWerk() {		
		//DRIVE
		drive();
		
		//EXTERIOR
		exterior();
		
		//interior
		interior();
	}

	public static void drive(){
		Drive.Drive.DriveSpeed(Gamepad.primary.getLeftX(),
				Gamepad.primary.getLeftY(), Gamepad.primary.getRightX());
		
	}
	
	public static void exterior(){
		if(Gamepad.secondary.getB()){
			exteriorLockAndLift = true;
			Exterior.Exterior.clampAndRiseInit();
		}
		if(exteriorLockAndLift){
			exteriorLockAndLift=!Exterior.Exterior.clampAndRise();
		}
		if(Gamepad.secondary.getA()){
			Exterior.Exterior.rotateArm(-.6);
		}
		if(Gamepad.secondary.getY()){
			Exterior.Exterior.rotateArm(.6);
		}
		Exterior.Exterior.moveArm(Gamepad.secondary.getRightY());
	}
	public static void interior(){
		if(Gamepad.secondary.getX()){
			interiorLift = true;
		}
		if(interiorLift){
			interiorLift = !Interior.Interior.intakeAndClamp();
		}
		if(Gamepad.secondary.getLB()||Gamepad.secondary.getRB()){
			placeTotes = true;
		}
		if(exteriorLockAndLift){
			placeTotes = !Interior.Interior.placeTotes();
		}
		Interior.Interior.moveArm(Gamepad.secondary.getLeftY());
		
	}
	/*
	 * turns everything off on the robot and removes all functionality
	 */
	public static void Gabby(){
		SensorsAndActuators.leftFrontDrive.set(0);
		SensorsAndActuators.leftRearDrive.set(0);
		SensorsAndActuators.rightFrontDrive.set(0);
		SensorsAndActuators.rightRearDrive.set(0);
	}
}
