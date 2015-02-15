package Exterior;

import org.usfirst.frc.team245.robot.SensorsAndActuators;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Exterior {	
	private static Timer timer = new Timer();
	private static final int ARM_ENCODER_MAX = 1000;
	private static final int ROTATION_ENCODER_MAX=180;
	private static DoubleSolenoid.Value solenoidForward =
			DoubleSolenoid.Value.kForward;
	private static DoubleSolenoid.Value solenoidReverse =
			DoubleSolenoid.Value.kReverse;
	public static void setClamps(boolean setClamps){
		if(setClamps){
			SensorsAndActuators.exteriorArmPiston.set(solenoidForward);
		}
		else{
			SensorsAndActuators.exteriorArmPiston.set(solenoidReverse);
		}
	}
	public static void moveArm(double speed){
		SmartDashboard.putNumber("arm speed", speed);
		if(speed>0){
			SensorsAndActuators.liftBrake.set(false);
			if(SensorsAndActuators.exteriorManipulator.get()<ARM_ENCODER_MAX
					&& !SensorsAndActuators.exteriorTopLimit.get()){
				SmartDashboard.putNumber("DEBUG MOVEARM CASE 1", SensorsAndActuators.exteriorManipulator.get()); 
				SensorsAndActuators.exteriorLiftMotor.set(speed);
			}
			else{
				SensorsAndActuators.exteriorLiftMotor.set(0);
			}
		}
		else if (speed<0){
			SensorsAndActuators.liftBrake.set(false);
			if(SensorsAndActuators.exteriorManipulator.get()>=-5
					 && !SensorsAndActuators.exteriorBottomLimit.get()){
				SensorsAndActuators.exteriorLiftMotor.set(speed);
			}
			else{
				SensorsAndActuators.exteriorLiftMotor.set(0);
			}
		}
		else{
			// TODO SensorsAndActuators.liftBrake.set(true);
			SensorsAndActuators.exteriorLiftMotor.set(0);
		}
		SmartDashboard.putNumber("Encoder Value", SensorsAndActuators.exteriorManipulator.getDistance());
		SmartDashboard.putBoolean("Top Limit", SensorsAndActuators.exteriorTopLimit.get());
		SmartDashboard.putBoolean("Bottom Limit", SensorsAndActuators.exteriorBottomLimit.get());
	}
	public static void rotateArm(double speed){
		if(speed ==0){
			SensorsAndActuators.angleBrake.set(true);
			SensorsAndActuators.exteriorRotationMotor.set(0);
		}
		else{			
			if(SensorsAndActuators.exteriorRotationEncoder.get()<0){
				SensorsAndActuators.angleBrake.set(false);
				SensorsAndActuators.exteriorRotationMotor.set(speed);
			}
			else{
				SensorsAndActuators.angleBrake.set(true);
				SensorsAndActuators.exteriorRotationMotor.set(0);
			}
		}
		SmartDashboard.putNumber("hall effects encoder value", SensorsAndActuators.exteriorRotationEncoder.get());
	}
	public static void clampAndRiseInit(){
		timer.reset();
		timer.start();
	}
	public static boolean clampAndRise(){
		if(timer.get()<1){
			Exterior.setClamps(true);
		}
		else{
			Exterior.moveArm(.4);
			if(timer.get()>2.5){
				return true;
			}
		}
		return false;
	}
}
