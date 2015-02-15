package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.*;
public final class SensorsAndActuators {
	//declare and initialize all sensors and actuators
/*SENSORS-----------------------------------------------------------------------------------------------*/
	
	public static Gyro gyro;
	public static Encoder exteriorManipulator;
	public static Encoder interiorManipulator;
	public static DigitalInput exteriorTopLimit;
	public static DigitalInput exteriorBottomLimit;
	public static DigitalInput interiorTopLimit;
	public static DigitalInput interiorBottomLimit;
	public static DigitalInput photoEyeInternal;
	public static DigitalInput photoEyeExternal;
	public static Compressor compressor;
	public static AnalogPotentiometer exteriorRotationEncoder;
/*ACTUATORS---------------------------------------------------------------------------------------------*/
	public static Talon leftFrontDrive; 
	public static Talon rightFrontDrive; 
	public static Talon leftRearDrive; 
	public static Talon rightRearDrive; 
	public static Victor leftToteFeederMotor; 
	public static Victor rightToteFeederMotor; 
	public static Victor interiorLiftMotor; 
	public static Victor exteriorLiftMotor; 
	public static Victor exteriorRotationMotor; 
	public static DoubleSolenoid internalToteClamp; 
	public static DoubleSolenoid exteriorArmPiston;  
	public static Solenoid rollerPiston; 
	public static Solenoid ratchetPiston;  
	public static Solenoid liftBrake;  
	public static Solenoid angleBrake;
	
	//OTHER
	public static PowerDistributionPanel currentPDP;
	
	
/*INITIALIZATION----------------------------------------------------------------------------------------*/
	public static void initialize(){
		//Sensors
		gyro = new Gyro(0);
		
		exteriorManipulator = new Encoder(8,9);	
		exteriorManipulator.setDistancePerPulse(.01);
		//exteriorManipulator.reset();
		//Untested		
		//interiorManipulator = new Encoder(2,3);		
		exteriorTopLimit = new DigitalInput(4); //confirmed
		exteriorBottomLimit = new DigitalInput(5); //confirmed
		//interiorTopLimit = new DigitalInput(6); //confirmed
		//interiorBottomLimit = new DigitalInput(7); //confirmed
		//photoEyeInternal = new DigitalInput(8);
		//photoEyeExternal = new DigitalInput(9);
		//Actuators
		//leftFrontDrive = new Talon(0);
		//rightFrontDrive = new Talon(2);
		//leftRearDrive = new Talon(1);
		//rightRearDrive = new Talon(3);	
		exteriorRotationEncoder = new AnalogPotentiometer(1);
		//leftToteFeederMotor = new Victor(5);
		//rightToteFeederMotor = new Victor(4);
		//interiorLiftMotor = new Victor(6);
		exteriorRotationMotor = new Victor(8);
		exteriorLiftMotor = new Victor(7);
		
		//Solenoids
		//internalToteClamp = new DoubleSolenoid(0,1);//internal tote
		exteriorArmPiston = new DoubleSolenoid(4,5);//untested
		liftBrake = new Solenoid(6);
		angleBrake = new Solenoid(7);
		//rollerPiston = new Solenoid(3);
	//	ratchetPiston = new Solenoid(2);
		
		compressor = new Compressor();
		currentPDP = new PowerDistributionPanel();
	}
	
}
