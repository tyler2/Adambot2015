package Auton;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceFromAcceleration {
	public static double offsetX;
	public static double offsetY;
	private static double accelerationX;
	private static double accelerationY;
	public static double velocityX=0;
	public static double velocityY=0;
	public static double positionX=0;
	public static double positionY=0;
	public static Timer distanceTimer = new Timer();
	private static BuiltInAccelerometer a = new BuiltInAccelerometer();
	private static double time;
	public static void init(){
		
		
		distanceTimer.start();
		offsetX+= a.getX();
		offsetY+= a.getY();
		
	}
	public static void DFromA(){
		time = distanceTimer.get();
		accelerationX = (a.getX()-offsetX)*9.8;
		
		accelerationY = (a.getY()-offsetY)*9.8;
		
		velocityX+=accelerationX *time;
		velocityY+=accelerationY *time;
		
		positionX+=(velocityX)*time; //+ (.5*accelerationX *Math.pow(time, 2));
		positionY+=(velocityY)*time; //+ (.5*accelerationY *Math.pow(time, 2));
		
		distanceTimer.reset();
		SmartDashboard.putDouble("Y-acceleration", accelerationY);
		SmartDashboard.putDouble("Y-Velocity", velocityY);
		SmartDashboard.putDouble("X-acceleration", accelerationX);
		SmartDashboard.putDouble("X-Velocity", velocityX);
		SmartDashboard.putDouble("z-acceleration", a.getZ());
		SmartDashboard.putNumber("X displacement",positionX);
		SmartDashboard.putNumber("Y displacement",positionY);
		
}
	public static double getX(){
		return positionX;
	}
	public static double getY(){
		return positionY;
	}
}
