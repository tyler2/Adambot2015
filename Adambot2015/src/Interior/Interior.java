package Interior;

import org.usfirst.frc.team245.robot.SensorsAndActuators;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Interior {
	private static double INTERIOR_ENCODER_MAX = 1000; // needs to be tested
	private static double INTERIOR_ENCODER_MIN = 0;
	private static double TOTE_ENCODER_HEIGHT = 100;
	private static double MAX_AMPS = 2;
	private static Timer currentTimer = new Timer(); // NOT SURE WHERE TO PUT
														// THIS
	private static Timer intakeTimer = new Timer();
	private static Timer outputTimer = new Timer();
	// private static boolean CURRENT_FAIL = false;
	private static double MAX_CURRENT_FAIL_TIME = 0.5; // in seconds
	private static double MOTOR_COOLDOWN_TIME = 2.5; // in seconds
	private static double LIVE_CURRENT_FAIL_TIME = 0; // in seconds
	private static boolean RESET_MOTOR_BEGIN = false;
	// private static double EXPECTED_ITERATION = 0;
	// private static double CURRENT_ITERATION = 0;
	private static double ARM_MOVE_SPEED = .8;
	private static int PDP_PORT = 3;
	private static int intakeStage = 0;
	private static int outputStage = 0;
	public static void toggleRollers(double leftSpeed, double rightSpeed) { // 1 = in,
																		// -1 =
																		// out,
																		// 0 =
																		// stop
		// apparently part of drive train?
		SensorsAndActuators.leftToteFeederMotor.set(leftSpeed);
		SensorsAndActuators.rightToteFeederMotor.set(rightSpeed);
	}

	public static double getCurrentEncoder() {
		return SensorsAndActuators.interiorManipulator.get();
	}

	// sets the motor speeds of both arms
	public static void moveArm(double speed) { // +=up -=down
		// issues with encoder skipping, unsure for max and min values
		// SensorsAndActuators.interiorLiftMotor.set(speed);
		if (speed > 0) {
			if (getCurrentEncoder() <= INTERIOR_ENCODER_MAX
					&& !SensorsAndActuators.interiorTopLimit.get()) {// &&not
																		// the
																		// top
																		// limit
																		// switch
				SensorsAndActuators.interiorLiftMotor.set(speed);
			} else {
				SensorsAndActuators.interiorLiftMotor.set(0);
			}
		} else {
			if (getCurrentEncoder() >= INTERIOR_ENCODER_MIN
					&& !SensorsAndActuators.interiorBottomLimit.get()) {
				SensorsAndActuators.interiorLiftMotor.set(speed);
			} else {
				SensorsAndActuators.interiorLiftMotor.set(0);
			}
		}

	}

	public static void toggleRatchet(boolean isCompressed) {
		if (isCompressed) { // currently closed
			// open Arms
			SensorsAndActuators.ratchetPiston.set(true);

		} else { // currently opened
			// close Arms
			SensorsAndActuators.ratchetPiston.set(false);
		}
	}

	// clamps using the piston
	public static void toggleClamps(boolean isCompressed) {
		if (isCompressed) { // currently closed
			// open Arms
			SensorsAndActuators.clampPiston.set(false);
		} else { // currently open
			// close Arms
			SensorsAndActuators.clampPiston.set(true);
		}
	}

	
	public static void currentCheck() { // each iteration = 20 milliseconds
		// take special action if motor stalls
		double current = SensorsAndActuators.currentPDP.getCurrent(PDP_PORT);
		SmartDashboard.putNumber("Current value", current);

		if (current >= MAX_AMPS) {
			currentTimer.start();
			LIVE_CURRENT_FAIL_TIME += 0.02;
		}

		if (LIVE_CURRENT_FAIL_TIME - 0.05 < currentTimer.get() * 0.02
				&& currentTimer.get() * 0.02 < LIVE_CURRENT_FAIL_TIME + 0.05) {
			if (currentTimer.get() >= MAX_CURRENT_FAIL_TIME) {
				SmartDashboard.putString("rollerError",
						"ERROR: ROLLER MOTOR STALLED");

				RESET_MOTOR_BEGIN = true;
			}
		} else {
			currentTimer.reset();
			currentTimer.stop();
			LIVE_CURRENT_FAIL_TIME = 0;
		}

		if (RESET_MOTOR_BEGIN && currentTimer.get() >= MOTOR_COOLDOWN_TIME) {
			currentTimer.stop();
			currentTimer.reset();
			RESET_MOTOR_BEGIN = false;
			SmartDashboard.putString("motorStatus", "RESTARTING MOTOR");

		}
	}

	
	public static void standardPosition() {
		toggleRollers(0, 0);
		moveArm(-ARM_MOVE_SPEED);
	}

	public static void initIntakeAndClamp() {
		intakeTimer.reset();
		intakeTimer.start();
	}

	public static boolean intakeAndClamp() {
		if (intakeStage == 0) {
			if (SensorsAndActuators.photoEyeInternal.get()) {
				toggleRollers(.5, .5);

			} else {
				toggleRollers(0,0);
				intakeStage++;
			}
			moveArm(0);
		}
		else if(intakeStage == 1){
			initIntakeAndClamp();
			toggleClamps(true);
			moveArm(0);
			intakeStage++;
		}
		else if(intakeStage==2&&(intakeTimer.get()>1)){
			if(getCurrentEncoder()<TOTE_ENCODER_HEIGHT){
				moveArm(ARM_MOVE_SPEED);
			}
			else{
				intakeStage++;
			}
		}
		else if(intakeStage==3){
			toggleRatchet(false);
			moveArm(0);
			intakeStage++;
		}
		else if(intakeStage==4){
			if(getCurrentEncoder()<2*TOTE_ENCODER_HEIGHT){
				moveArm(ARM_MOVE_SPEED);
			}
			else{
				intakeStage++;
			}
		}
		else if(intakeStage==5){
			toggleRatchet(true);
			moveArm(0);
			intakeStage++;
		}
		else if(intakeStage==6){
			toggleClamps(false);
			moveArm(0);
			intakeTimer.reset();
			intakeStage++;
		}
		else if(intakeStage==7&&intakeTimer.get()>.5){
			if(getCurrentEncoder()>0){
				moveArm(-ARM_MOVE_SPEED);
			}
			else{
				intakeStage = 0;
				return true;
			}
		}
		return false;
	}
	public static void initPlaceTotes(){
		outputTimer.start();
		outputTimer.reset();
	}
	public static boolean placeTotes() { 
		if(outputStage == 0){
			if(getCurrentEncoder()<TOTE_ENCODER_HEIGHT){
				moveArm(ARM_MOVE_SPEED);
			}
			else{
				outputStage++;
			}
		}
		else if(outputStage == 1){
			toggleClamps(true);
			initPlaceTotes();
			moveArm(0);
			outputStage++;
		}
		else if(outputStage==2&&outputTimer.get()>.5){
			toggleRatchet(false);
			outputStage++;
			moveArm(0);
		}
		else if(outputStage==3){
			if(getCurrentEncoder()>20){
				moveArm(-ARM_MOVE_SPEED);
			}
			else{
				outputStage++;
			}
		}
		else if(outputStage==4){
			toggleClamps(false);
			moveArm(0);
			return true;
		}
		return false;
	}

}
