package Auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LandmarkPlacement {
	//starting off sideways
	private static double sidewaysDistance = -.5;
	private static double forwardDistance = .5;
	public static int stage = 0;
	private static Timer rollerTimer = new Timer();
	public static void init(){
		rollerTimer.start();
		stage = 0;
	}
	public static void update(){
		SmartDashboard.putNumber("timer", rollerTimer.get());
		SmartDashboard.putNumber("stage:", stage);
		if(stage == 0){
			//Interior.Interior.toggleRollers(1);
			if(rollerTimer.get()>.5){
				stage = 2;
			}
		}
		else{
			driveTo(stage);
		}
	}
	public static void driveTo(int stage){
		
		if(stage == 2){
			stage2();
		}
		
		if(stage == 3){
			stage3();
		}
		
		if(stage ==4){
			stage4();
		}
	}
	public static void stage2(){
		if(DistanceFromAcceleration.getX()-.2>sidewaysDistance){
			Drive.Drive.DriveSpeed(.8, 0, 0);
		}
		else{
			if(DistanceFromAcceleration.getX()-.05>sidewaysDistance){
				Drive.Drive.DriveSpeed(.4, 0, 0);
			}
			else if(DistanceFromAcceleration.getX()<sidewaysDistance){
				Drive.Drive.DriveSpeed(-.4, 0, 0);
			}
			else{
				stage = 3;
				Auton.DistanceFromAcceleration.positionX=0;
				Auton.DistanceFromAcceleration.positionY=0;
			}
		}
	}
	public static void stage3(){
		if(DistanceFromAcceleration.getY()+.1<forwardDistance){
			Drive.Drive.DriveSpeed(0, -.6, 0);
			
		}
		else{
			if(DistanceFromAcceleration.getY()+.01<forwardDistance){
				Drive.Drive.DriveSpeed(0,-.3, 0);
			}
			else if(DistanceFromAcceleration.getY()-.01>forwardDistance){
				Drive.Drive.DriveSpeed(0,+.2, 0);
			}
			else{
				stage = 4;
				
			}
		}
	}
	public static void stage4(){
		Drive.Drive.DriveSpeed(0, +.6, 0);
	}
}
