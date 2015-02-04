package Interior;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Interior {
	/**
	 * 
	 * @param speed set the motor to this speed also do some current checking
	 */
	
	
	/**
	 * 
	 * @param speed set the motor to this speed also do some current checking
	 */
	
	private static double interiorEncoderMax = 6.2830; //needs to be tested
	private static double interiorEncoderMin = 0;
	private static PowerDistributionPanel current = new PowerDistributionPanel();
	public static double amps;
	/*public static void toggleRollers(int leftSpeed, int rightSpeed){ //1 = in, -1 = out, 0 = stop
		//apparently part of drive train?
		org.usfirst.frc.team245.robot.SensorsAndActuators.leftToteFeederMotor.set(leftSpeed);
		org.usfirst.frc.team245.robot.SensorsAndActuators.rightToteFeederMotor.set(rightSpeed);
	}
	
	public static double currentEncoder(){
		return org.usfirst.frc.team245.robot.SensorsAndActuators.interiorArmEncoder.get(); //Debjit is Scott's slut.
	}
	
	//sets the motor speeds of both arms
	public static void moveArm(double speed){ //+=up -=down
		//issues with encoder skipping, unsure for max and min values
		//SensorsAndActuators.interiorLiftMotor.set(speed);
		if(speed > 0){
			org.usfirst.frc.team245.robot.SensorsAndActuators.interiorLiftMotor.set(speed);
		}
		if(speed < 0){
			while(currentEncoder() >= interiorEncoderMin){
				org.usfirst.frc.team245.robot.SensorsAndActuators.interiorLiftMotor.set(speed);
			}
		}
	}
	
	public static void toggleArm(boolean isCompressed) {
		if (isCompressed) { //currently closed
			//open Arms
			org.usfirst.frc.team245.robot.SensorsAndActuators.leftArmCloser.set(true);
			org.usfirst.frc.team245.robot.SensorsAndActuators.rightArmCloser.set(true);
			
		} else { //currently opened
			//close Arms
			org.usfirst.frc.team245.robot.SensorsAndActuators.leftArmCloser.set(false);
			org.usfirst.frc.team245.robot.SensorsAndActuators.rightArmCloser.set(false);
		}
	}
	
	//clamps using the piston
	public static void toggleClamps(boolean isCompressed){
		if (isCompressed) { //currently closed
			//open Arms
			org.usfirst.frc.team245.robot.SensorsAndActuators.toteClamp.set(false);
		} else { //currently open
			//close Arms
			org.usfirst.frc.team245.robot.SensorsAndActuators.toteClamp.set(true);
		}
	}
	
	public static void standardPosition() {
		toggleRollers(0, 0);
		moveArm(-6.66);//need correct number
		
	}
	
	public static void intakeAndClamp() {
		if(org.usfirst.frc.team245.robot.SensorsAndActuators.leftArmCloser.get() == false || org.usfirst.frc.team245.robot.SensorsAndActuators.rightArmCloser.get() == false){  
				toggleArm(true);
		}
		
		toggleRollers(1, 1);
		toggleArm(false);
		if(org.usfirst.frc.team245.robot.SensorsAndActuators.toteClamp.get() == true){
			toggleClamps(true);
		}
		moveArm(3.1415);//temporary number, need to determine speed
		toggleClamps(false);
	}
	
	public static void placeTotes() {
		toggleRollers(0, 0);
		toggleArm(true);
		moveArm(1.337); //not actually 1337
		toggleArm(false);
		toggleClamps(false);
		moveArm(-1.337); //same as above comment
		toggleArm(true);
	}
	
	*/
	public static void currentCheck() {
		//take special action if motor stalls
		//PowerDistributionPanel. //WHY DOESN'T THIS WORK 
		//http://first.wpi.edu/FRC/roborio/release/docs/java/classedu_1_1wpi_1_1first_1_1wpilibj_1_1PowerDistributionPanel.html
		amps = current.getCurrent(3);
		SmartDashboard.putNumber("current",amps);
	}
}
