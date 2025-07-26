package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Calc;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class robozin1 extends SubsystemBase {
  public final VictorSPX m_leftDrive = new VictorSPX(4);
  public final VictorSPX m_rightDrive = new VictorSPX(2);
  public final VictorSPX m_rightDrive2 = new VictorSPX(1);
  public final VictorSPX m_leftDrive2 = new VictorSPX(3); 

  public robozin1() {
        m_rightDrive.setInverted(true);
        m_rightDrive2.setInverted(true);
        m_leftDrive.setInverted(false);
        m_leftDrive2.setInverted(false);

        m_leftDrive.configNeutralDeadband(0.04);
        m_leftDrive2.configNeutralDeadband(0.04);
        m_rightDrive.configNeutralDeadband(0.04);
        m_rightDrive2.configNeutralDeadband(0.04);

        m_rightDrive.setNeutralMode(NeutralMode.Brake);
        m_rightDrive2.setNeutralMode(NeutralMode.Brake);
        m_leftDrive.setNeutralMode(NeutralMode.Brake);
        m_leftDrive2.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {

  }
}
