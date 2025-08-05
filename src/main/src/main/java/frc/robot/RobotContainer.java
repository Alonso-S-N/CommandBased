package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.SubSystem.Drive;
import frc.robot.SubSystem.PidController;
import frc.robot.command.Loc;
import frc.robot.command.PidCommand;

public class RobotContainer {

  // Subsystems
  private final Drive driveSubsystem = new Drive();

  // Input
  public final Joystick joyDeliciu = new Joystick(Constants.joy);

  // Commands
  private final Loc locCommand;

  private final PidCommand Pdiddy;
  
  private final PidController baby = new PidController();


  public RobotContainer() {

    CommandScheduler.getInstance().registerSubsystem(baby);

    Pdiddy = new PidCommand(baby, null, 0);

    baby.setDefaultCommand(Pdiddy);
    
    // Register subsystem with CommandScheduler
    CommandScheduler.getInstance().registerSubsystem(driveSubsystem);

    // Initialize Loc command with drive subsystem and joystick
    locCommand = new Loc(driveSubsystem,joyDeliciu);

    // Set default command
    driveSubsystem.setDefaultCommand(locCommand);

  }
}
