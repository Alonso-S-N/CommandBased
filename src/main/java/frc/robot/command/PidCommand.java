// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubSystem.PidController;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PidCommand extends Command {
  private final PidController braceta;
  private final PIDController pid;
  public final double angulin;
 
  public PidCommand(PidController braceta, PIDController pid, double angulin) {
   this.braceta = braceta;
   this.pid = pid;
   this.angulin = angulin;

   pid = new PIDController(0.1, 0.001, 0.01);
   pid.setTolerance(1.0);
    
   addRequirements(braceta);
  }


  @Override
  public void initialize() {
    pid.setSetpoint(angulin);
  }
  
  @Override
  public void execute() {
    double agora = braceta.getAngle();
    double output = pid.calculate(agora);
    braceta.setMotor(output);
  }


  @Override
  public void end(boolean interrupted) {
    braceta.setMotor(0);
  }


  @Override
  public boolean isFinished() {
    return pid.atSetpoint();
  }
}
