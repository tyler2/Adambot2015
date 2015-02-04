package Drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
	static Gyro gyro = new Gyro(0);
	public static CANTalon LeftRear = new CANTalon(3);
	public static CANTalon RightRear = new CANTalon(1);
	public static CANTalon LeftFront = new CANTalon(2);
	public static CANTalon RightFront = new CANTalon(0);
	public static RobotDrive nathan = new RobotDrive(LeftFront,LeftRear,RightFront,RightRear);
	/**
	 * PRIMARILY FOR AUTON
	 * @param speeds gives the speeds to each motor in order, LF, RF, LR, RR
	 */
	public static void DriveSpeed(double X, double Y, double rotation){
		//does any needed adjustments then sets motor values
		//first change
		SmartDashboard.putNumber("x", X);
		SmartDashboard.putNumber("y", Y);
		SmartDashboard.putNumber("rotation", rotation);
		nathan.mecanumDrive_Cartesian(X, Y, rotation, 0);
	}
	public static void init(){
		nathan.setInvertedMotor(MotorType.kFrontLeft, true);
		nathan.setInvertedMotor(MotorType.kRearLeft, true);
	}
	public static void test(){
		RightFront.set(0.75);
		LeftFront.set(0.75);
		LeftRear.set(-0.75);
		RightRear.set(-0.75);
	}
	
	
}
