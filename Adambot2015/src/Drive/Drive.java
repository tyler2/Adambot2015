package Drive;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team245.robot.SensorsAndActuators;
public class Drive {
	//static Gyro gyro = new Gyro(0);
	public static RobotDrive nathan; 
	public static ArrayList<Double> xValues = new ArrayList();
	public static ArrayList<Double> yValues = new ArrayList();
	public static ArrayList<Double> rotationValues = new ArrayList();
	private static double leftRearScalar, rightRearScalar;
	private static boolean oldHitler, newHitler;
	private static double rightFrontSpeed;
	private static double rightRearSpeed;
	private static double leftFrontSpeed;
	private static double leftRearSpeed;
	private static double previousAngle;
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
		xValues.add(X);
		yValues.add(Y);
		rotationValues.add(rotation);
	}
	public static void init(){
		nathan =new RobotDrive(SensorsAndActuators.leftFrontDrive,
				SensorsAndActuators.leftRearDrive,
				SensorsAndActuators.rightFrontDrive,
				SensorsAndActuators.rightRearDrive);
		nathan.setInvertedMotor(MotorType.kFrontLeft, true);
		nathan.setInvertedMotor(MotorType.kRearLeft, true);
	}
	
	
	public static double restrict(double x){
    	return Math.max(Math.min(1, x), -1);
    }
	public static void roiDrive(double X, double Y, double rotation){
		if(X!=0&&Y==0){
		double xIn = X;
		double yIn = Y;
		// Negate y for the joystick.
	yIn = -yIn;
	      // Compenstate for gyro angle.
	//switch if x is negative      
	double rotated[];
	if(X>0){
		rotated = rotateVector(xIn, yIn, .1*(-previousAngle+SensorsAndActuators.gyro.getAngle()));
		SmartDashboard.putNumber("correction", -previousAngle+SensorsAndActuators.gyro.getAngle());
	}
	else{
		rotated = rotateVector(xIn, yIn, .1*(previousAngle-SensorsAndActuators.gyro.getAngle()));
	}
	
	
	        xIn = rotated[0];
		        yIn = rotated[1];
		        DriveSpeed(xIn, yIn, rotation);  
		}
		else{
			previousAngle = SensorsAndActuators.gyro.getAngle();
			DriveSpeed(X, Y, rotation);
		}
		SmartDashboard.putNumber("Gyro Value", SensorsAndActuators.gyro.getAngle());
		SmartDashboard.putNumber("the last angle", previousAngle);
	}
	 private static double[] rotateVector(double x, double y, double angle) {
		        double cosA = Math.cos(angle * (3.14159 / 180.0));
		        double sinA = Math.sin(angle * (3.14159 / 180.0));
		        double out[] = new double[2];
		        out[0] = x * cosA - y * sinA;
		        out[1] = x * sinA + y * cosA;
		        return out;
		    }
	 public static void roiInit(){
		 previousAngle = SensorsAndActuators.gyro.getAngle();
	 }
	
}