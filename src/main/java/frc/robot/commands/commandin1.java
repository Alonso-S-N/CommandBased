
package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Calc;
import frc.robot.subsystems.robozin1;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class commandin1 extends  Command {

  private final robozin1 robozin1;
  protected final Calc calc;

  public commandin1(robozin1 robo, Calc cal) {
   this.robozin1 = robo;
   this.calc = cal;
    addRequirements(robo);
    CommandScheduler.getInstance().setDefaultCommand(robozin1,
    new RunCommand(() -> {
      calc.calAnalogico();
      calc.calAnalogico2();
      calc.OiaAnalogico();
      calc.calPov();
      calc.calButton();
      calc.RTLT();
    
    }, robozin1)
  );
  }


  @Override
  public void initialize() {
    robozin1.m_leftDrive.setNeutralMode(NeutralMode.Brake);
    robozin1.m_leftDrive2.setNeutralMode(NeutralMode.Brake);
    robozin1.m_rightDrive.setNeutralMode(NeutralMode.Brake);
    robozin1.m_rightDrive2.setNeutralMode(NeutralMode.Brake);

    robozin1.m_leftDrive.setInverted(false);
    robozin1.m_leftDrive2.setInverted(false);
    robozin1.m_rightDrive.setInverted(true);
    robozin1.m_rightDrive2.setInverted(true);

    robozin1.m_leftDrive.configNeutralDeadband(0.04);
    robozin1.m_leftDrive2.configNeutralDeadband(0.04);
    robozin1.m_rightDrive.configNeutralDeadband(0.04);
    robozin1.m_rightDrive2.configNeutralDeadband(0.04);
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {}

  @Override

  public boolean isFinished() {
      return false;
  }
}
