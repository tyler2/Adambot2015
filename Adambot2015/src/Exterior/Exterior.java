package Exterior;
import org.usfirst.frc.team245.robot.SensorsAndActuators;
public class Exterior {
	//rotates the manipulator at a given speed
	
		/*
		//private static int ARM_VICTOR_PORT = 3;
		//private static int ARM_ANGLE_VICTOR_PORT;
		//private static int CLAMP_SOLENOID_PORT_ONE;
		//private static int CLAMP_SOLENOID_PORT_TWO;
		private static int ARM_ENCODER_MIN = 0;//to be determined
		private static int ARM_ENCODER_MAX = 720;//to be determined
		private static int ROTATE_ENCODER_MIN = 0;//to be determined
		private static int ROTATE_ENCODER_MAX = 180;//to be determined
		private static int A_CHANNEL_ENCODER = SensorsAndActuators.exteriorArmEncoder.get();
		private static int B_CHANNEL_ENCODER; //NEVER ACTUALLY USED
		private static int RADIUS = 20;// radius to be determined
		private static int ARM_RAISE_HEIGHT = A_CHANNEL_ENCODER * RADIUS;
		//private static int ARM_BRAKE_SOLENOID;
		//private static int LIMIT_SWITCH_PORT_TOP = 2;
		//private static int LIMIT_SWITCH_PORT_BOTTOM = 5;
		//private static int ROTATE_BREAK_SOLENOID_PORT = 123;//to be determined
		private static double ARM_RESET_SPEED = -0.2;
		
		
		public static void reset(){
			while (!SensorsAndActuators.exteriorBottomLimit.get()) {
					SensorsAndActuators.CIMMotor.set(ARM_RESET_SPEED);
			}
			SensorsAndActuators.exteriorArmEncoder.reset();
		}
		
		
		//rotates the manipulator at a given speed
		public static void rotate(double speed){
			if((SensorsAndActuators.BAGMotor.get() <= ROTATE_ENCODER_MIN && speed < 0) || (SensorsAndActuators.BAGMotor.get() >= ROTATE_ENCODER_MAX && speed > 0 )){
				SensorsAndActuators.BAGMotor.set(0);
				SensorsAndActuators.exteriorRotationalBrake.set(true);
			} else {
				SensorsAndActuators.exteriorRotationalBrake.set(false);
				SensorsAndActuators.BAGMotor.set(speed);
			}
			
		}
		
		//moves the arm at a given speed
		public static void moveArm(double speed){
			if((SensorsAndActuators.exteriorArmEncoder.get() <= ARM_ENCODER_MIN && speed < 0) || (SensorsAndActuators.exteriorArmEncoder.get() >= ARM_ENCODER_MAX && speed > 0 ) || (speed == 0)){
				SensorsAndActuators.CIMMotor.set(0);
				SensorsAndActuators.exteriorVerticalBrake.set(true);
			} else {
				if((SensorsAndActuators.exteriorBottomLimit.get() && speed < 0) || (SensorsAndActuators.exteriorTopLimit.get() && speed >0)){
					SensorsAndActuators.CIMMotor.set(0);
					SensorsAndActuators.exteriorVerticalBrake.set(true);
					if(SensorsAndActuators.exteriorBottomLimit.get()){
						ARM_ENCODER_MIN =+ 2;
					} else {
						ARM_ENCODER_MAX =- 2;
					}
				} else {
					SensorsAndActuators.exteriorVerticalBrake.set(false);
					SensorsAndActuators.CIMMotor.set(speed);
				}
			}
		}
		
		//clamps the pneumatic
		public static void clamp(boolean shouldClamp){
			if (shouldClamp){
				SensorsAndActuators.exteriorPiston.set(DoubleSolenoid.Value.kForward);
			} else {
				SensorsAndActuators.exteriorPiston.set(DoubleSolenoid.Value.kReverse);
			}
		}
		
		public static void autonPickup(){
			clamp(true);
			while(ARM_RAISE_HEIGHT < 5){ //height is to be determined
				moveArm(0.5);
				A_CHANNEL_ENCODER = SensorsAndActuators.exteriorArmEncoder.get();
				ARM_RAISE_HEIGHT = A_CHANNEL_ENCODER * RADIUS;
			}
		}
		*/
}
