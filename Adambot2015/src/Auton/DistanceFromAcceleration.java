package Auton;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceFromAcceleration {
	private static double accelerationX;
	private static double accelerationY;
	private static double velocityX=0;
	private static double velocityY=0;
	public static double positionX=0;
	public static double positionY=0;
	private static Timer distanceTimer = new Timer();
	private static BuiltInAccelerometer a = new BuiltInAccelerometer();
	private static double time;
	public static void init(){
		distanceTimer.start();
	}
	public static void DFromA(){
		time = distanceTimer.get();
		accelerationX = a.getX()*9.8;
		if(Math.abs(accelerationX)<.36){
			accelerationX = 0;
		}
		accelerationY = a.getY()*9.8;
		if(Math.abs(accelerationY)<.36){
			accelerationY = 0;
		}
		velocityX+=accelerationX *time;
		velocityY+=accelerationY *time;
		if(Math.abs(accelerationX)<.02){
			velocityX = 0;
		}
		if(Math.abs(accelerationY)<.02){
			velocityY = 0;
		}
		positionX-=Math.abs(velocityX)*time; //+ (.5*accelerationX *Math.pow(time, 2));
		positionY+=Math.abs(velocityY)*time; //+ (.5*accelerationY *Math.pow(time, 2));
		
		distanceTimer.reset();
		SmartDashboard.putDouble("Y-acceleration", accelerationY);
		SmartDashboard.putDouble("Y-Velocity", velocityY);
		SmartDashboard.putDouble("X-acceleration", accelerationX);
		SmartDashboard.putDouble("X-Velocity", velocityX);
}
	public static double getX(){
		return positionX;
	}
	public static double getY(){
		return positionY;
	}
}
