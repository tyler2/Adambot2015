package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.*;
public class SensorsAndActuators {
	//declare and initialize all sensors and actuators
/*SENSORS-----------------------------------------------------------------------------------------------*/
	
	public static Gyro gyro;
	public static Encoder exteriorArmEncoder;
	public static Encoder interiorArmEncoder;
	public static Encoder exteriorRotationEncoder;
	public static DigitalInput autonSwitch1;
	public static DigitalInput autonSwitch2;
	public static DigitalInput autonSwitch3;
	public static DigitalInput exteriorTopLimit;
	public static DigitalInput exteriorBottomLimit;
	public static DigitalInput interiorTopLimit;
	public static DigitalInput interiorBottomLimit;
	
/*ACTUATORS---------------------------------------------------------------------------------------------*/
	public static Talon leftFrontDrive;
	public static Talon rightFrontDrive;
	public static Talon leftBackDrive;
	public static Talon rightBackDrive;
	public static Victor leftToteFeederMotor;
	public static Victor rightToteFeederMotor;
	public static Victor interiorLiftMotor;
	public static Victor exteriorLiftMotor;
	public static Victor exteriorRotationMotor;
	public static DoubleSolenoid exteriorPiston;
	public static DoubleSolenoid rollerPiston;
	public static Solenoid interiorClamp;
	public static Solenoid interiorRatchet;
	public static Solenoid exteriorVerticalBrake;
	public static Solenoid exteriorRotationalBrake;
	
	
/*INITIALIZATION----------------------------------------------------------------------------------------*/
	public static void initialize(){
		//Sensors
		gyro = new Gyro(1);
		exteriorArmEncoder = new Encoder(1,1);
		exteriorRotationEncoder = new Encoder(1,1);
		interiorArmEncoder = new Encoder(1,1);
		autonSwitch1 = new DigitalInput(1); 
		autonSwitch2 = new DigitalInput(1);
		autonSwitch3 = new DigitalInput(1);
		exteriorTopLimit = new DigitalInput(2); //confirmed
		exteriorBottomLimit = new DigitalInput(5); //confirmed
		interiorTopLimit = new DigitalInput(2); //confirmed
		interiorBottomLimit = new DigitalInput(5); //confirmed
		//Actuators
		leftFrontDrive = new Talon(1);
		rightFrontDrive = new Talon(1);
		leftBackDrive = new Talon(1);
		rightBackDrive = new Talon(1);
		leftToteFeederMotor = new Victor(1);
		rightToteFeederMotor = new Victor(1);
		interiorLiftMotor = new Victor(1);
		exteriorRotationMotor = new Victor(1);
		exteriorPiston = new DoubleSolenoid(1,1);
		rollerPiston = new DoubleSolenoid(1,1);
		exteriorVerticalBrake = new Solenoid(1);
		exteriorRotationalBrake = new Solenoid(1);
		interiorClamp = new Solenoid(1);
		interiorRatchet = new Solenoid(1);
		exteriorLiftMotor = new Victor(1);
	}
	
}
