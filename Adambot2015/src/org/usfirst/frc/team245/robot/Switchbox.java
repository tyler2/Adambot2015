package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Switchbox {
	static DigitalInput a0 = new DigitalInput(0);
	static DigitalInput a1 = new DigitalInput(1);
	static DigitalInput a2 = new DigitalInput(2);
	static DigitalInput a3 = new DigitalInput(3);
	static DigitalInput a4 = new DigitalInput(4);
	static DigitalInput a5 = new DigitalInput(5);
	public static void update(){
		SmartDashboard.putBoolean("Digital 0", a0.get());
		SmartDashboard.putBoolean("Digital 1", a1.get());
		SmartDashboard.putBoolean("Digital 2", a2.get());
		SmartDashboard.putBoolean("Digital 3", a3.get());
		SmartDashboard.putBoolean("Digital 4", a4.get());
		SmartDashboard.putBoolean("Digital 5", a5.get());
	}
}
