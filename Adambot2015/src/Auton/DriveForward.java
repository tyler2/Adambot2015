package Auton;

public class DriveForward {
	public void update(){
		while(DistanceFromAcceleration.getY()<5){
			Drive.Drive.DriveSpeed(0, .4, 0);
		}
	}
}
