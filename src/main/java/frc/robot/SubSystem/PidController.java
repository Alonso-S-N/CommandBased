// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.SubSystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import static edu.wpi.first.wpilibj2.command.Commands.parallel;
import static edu.wpi.first.wpilibj2.command.Commands.waitUntil;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class PidController extends SubsystemBase {
 VictorSPX m_bracin = new VictorSPX(Constants.m_Bracin);
 private final double TICKS_PER_REVOLUTION = 4096 / 360.0;
  public PidController() {
  m_bracin.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
  m_bracin.setSelectedSensorPosition(Constants.sensorPos);
  m_bracin.setInverted(false);
}

public void setMotor(double output){
  m_bracin.set(ControlMode.PercentOutput, output);
}

public double getAngle(){
  return m_bracin.getSelectedSensorPosition() / TICKS_PER_REVOLUTION;
}

public void resetEncoder() {
  m_bracin.setSelectedSensorPosition(Constants.sensorPos);
}


    
    
      @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
