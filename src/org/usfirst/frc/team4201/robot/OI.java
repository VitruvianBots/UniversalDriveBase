package org.usfirst.frc.team4201.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4201.robot.commands.OI.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick leftJoystick;
	public Joystick rightJoystick;
	public Joystick xBoxController;
	
	public Button[] leftJoystickButtons = new Button[7];
	public Button[] rightJoystickButtons = new Button[7];
	public Button[] xBoxControllerButtons = new Button[9];
	
	public OI(){
		// Initialize Joysticks
		leftJoystick = new Joystick(RobotMap.leftJoystick);    
		rightJoystick = new Joystick(RobotMap.rightJoystick);  
		xBoxController = new Joystick(RobotMap.xBoxController);
		
		// Initialize Controller Buttons
		for(int i = 0; i < leftJoystickButtons.length; i++)
			leftJoystickButtons[i] = new JoystickButton(leftJoystick, (i + 1));
		for(int i = 0; i < rightJoystickButtons.length; i++)
			rightJoystickButtons[i] = new JoystickButton(rightJoystick, (i + 1));
		for(int i = 0; i < xBoxControllerButtons.length; i++)
			xBoxControllerButtons[i] = new JoystickButton(xBoxController, (i + 1));
		
		// Set Button Controls
		rightJoystickButtons[1].whenPressed(new ToggleDriveShift());
	}
	
	// Utility functions
	public double getLeftJoystickY(){
		// Y-Axis is inverted due to using flight Joysticks
		return -leftJoystick.getY();
	}
	
	public double getLeftJoystickX(){
		return leftJoystick.getX();
	}
	
	public double getRightJoystickY(){
		// Y-Axis is inverted due to using flight Joysticks
		return -rightJoystick.getY();
	}
	
	public double getRightJoystickX(){
		return rightJoystick.getX();
	}
}
