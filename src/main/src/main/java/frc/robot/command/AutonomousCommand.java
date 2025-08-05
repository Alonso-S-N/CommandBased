// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.command;

import com.ctre.phoenix.Util;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Calcs.DriveSpeeds;
import frc.robot.SubSystem.Drive;

public class AutonomousCommand extends Command {
  private double vel;
  private boolean finished;
  
  Timer timer = new Timer();
  Encoder encoder = new Encoder(0, 1);
  private Drive driveSubsystem;
  public AutonomousCommand(Drive driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    encoder.setDistancePerPulse(0.05);

    addRequirements(driveSubsystem);
  }

  public void mexe(){
    vel = Constants.autonomousLoc;

    driveSubsystem.m_leftDrive.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_leftDrive2.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_rightDrive.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_rightDrive2.set(ControlMode.PercentOutput, vel);
  }
  
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }


  @Override
  public void execute() {
   mexe();
   SmartDashboard.putNumber("Speed", vel);
  }

  
  @Override
  public void end(boolean interrupted) {
    if (finished = true){
    vel = 0;
    driveSubsystem.m_leftDrive.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_leftDrive2.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_rightDrive.set(ControlMode.PercentOutput, vel);
    driveSubsystem.m_rightDrive2.set(ControlMode.PercentOutput, vel);
    }
  }

  @Override
  public boolean isFinished() {
   finished = timer.get() >= 2;
  SmartDashboard.putBoolean("Auto Finished", finished);
  return finished;
  }
}
