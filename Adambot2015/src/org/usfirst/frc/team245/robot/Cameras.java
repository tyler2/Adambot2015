package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.CameraServer;


public class Cameras{
	private static CameraServer server1;
	private static CameraServer server0;
	public void camerasInit(){
		server1 = CameraServer.getInstance();
        server1.startAutomaticCapture("cam2");
        server1.setQuality(5);
        server0 = CameraServer.getInstance();
        server0.startAutomaticCapture("cam1");
        server0.setQuality(5);        
	}
	
}
