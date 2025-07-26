package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.robozin1;
import frc.robot.commands.commandin1;
import frc.robot.Calc;

public class Robot extends TimedRobot {
  private robozin1 robo;
  private commandin1 command;
  private Calc cal;

  public Robot() {
  }
@Override
  public void robotInit(){
    robo = new robozin1();
    cal = new Calc(robo);
    command = new commandin1(robo,cal);
  }

  @Override
  public void teleopInit() {

  }
   
  @Override
  public void teleopPeriodic() {
   CommandScheduler.getInstance().run();
   cal.Smart();
  } 
}
