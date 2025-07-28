package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.robozin1;
    public class Calc {
        private final robozin1 robozin1;
        private final Joystick joydeliciu = new Joystick(0);
    
        private double B_Speed = 0.5, rapidao, rapidao2, seno, X, Y, magnitude,X2, Y2,seno2, magnitude2;
    
        public Calc(robozin1 robozin1) {
            this.robozin1 = robozin1;
        }
    
        public void calAnalogico() {
            Y = -joydeliciu.getRawAxis(1);
            X = joydeliciu.getRawAxis(0);
            magnitude = Math.max(-1, Math.min(1, Math.hypot(X, Y)));
            seno = Y / magnitude;
    
            if (X > 0 && Y > 0) {
                rapidao = magnitude * B_Speed;
                rapidao2 = (2 * seno - 1) * magnitude * B_Speed;
            } else if (X < 0 && Y > 0) {
                rapidao = (2 * seno - 1) * magnitude * B_Speed;
                rapidao2 = magnitude * B_Speed;
            } else if (X >= 0 && Y < 0) {
                rapidao = magnitude * B_Speed * -1;
                rapidao2 = (2 * seno + 1) * magnitude * B_Speed;
            } else if (X < 0 && Y < 0) {
                rapidao = (2 * seno + 1) * magnitude * B_Speed;
                rapidao2 = magnitude * B_Speed * -1;
            }           
                if (X >= 0.04 || X < -0.04 || Y >= 0.04 || Y < -0.04) {
                  robozin1.m_leftDrive.set(ControlMode.PercentOutput, rapidao);
                  robozin1.m_leftDrive2.set(ControlMode.PercentOutput, rapidao);
                  robozin1.m_rightDrive.set(ControlMode.PercentOutput, rapidao2);
                  robozin1.m_rightDrive2.set(ControlMode.PercentOutput, rapidao2);
                } else {
                  robozin1.m_leftDrive.set(ControlMode.PercentOutput, 0);
                  robozin1.m_leftDrive2.set(ControlMode.PercentOutput, 0);
                  robozin1.m_rightDrive.set(ControlMode.PercentOutput, 0);
                  robozin1.m_rightDrive2.set(ControlMode.PercentOutput, 0);
                }
            
    
      }
        public void calPov() {
            switch (joydeliciu.getPOV()) {
            case 0:
                rapidao = 0.5;
                rapidao2 = 0.5;
                break;
            case 45:
                rapidao = 0.5;
                rapidao2 = 0.25;
                break;
            case 90:
                rapidao = 0.5;
                rapidao2 = -0.5;
                break;
            case 135:
                rapidao = 0.25;
                rapidao2 = -0.25;
                break;
            case 180:
                rapidao = -0.5;
                rapidao2 = -0.5;
                break;
            case 225:
                rapidao = -0.25;
                rapidao2 = -0.25;
                break;
            case 270:
                rapidao = -0.5;
                rapidao2 = 0.5;
                break;
            case 315:
                rapidao = -0.25;
                rapidao2 = 0.25;
                break;
            }

            robozin1.m_leftDrive.set(ControlMode.PercentOutput, rapidao);
            robozin1.m_leftDrive2.set(ControlMode.PercentOutput, rapidao);
            robozin1.m_rightDrive.set(ControlMode.PercentOutput, rapidao2);
            robozin1.m_rightDrive2.set(ControlMode.PercentOutput, rapidao2);

        }
        public void calButton() {
            boolean a = joydeliciu.getRawButton(1);
            boolean b = joydeliciu.getRawButton(2);
            boolean x = joydeliciu.getRawButton(3);
    
            if (a) B_Speed = 0.25;
            else if (b) B_Speed = 0.5;
            else if (x) B_Speed = 1.0;
    
            rapidao *= B_Speed;
            rapidao2 *= B_Speed;
        }
       public void RTLT(){
            double RT = joydeliciu.getRawAxis(3);
            double LT = joydeliciu.getRawAxis(2);
    
            if (RT > 0.04) {
                rapidao = RT * B_Speed;
                rapidao2 = RT * B_Speed;
            } else if (LT > 0.04) {
                rapidao = -LT * B_Speed;
                rapidao2 = -LT * B_Speed;
            } 
        robozin1.m_leftDrive.set(ControlMode.PercentOutput, rapidao);
        robozin1.m_leftDrive2.set(ControlMode.PercentOutput, rapidao);
        robozin1.m_rightDrive.set(ControlMode.PercentOutput, rapidao2);
        robozin1.m_rightDrive2.set(ControlMode.PercentOutput, rapidao2);
       }

       public void Smart(){
          SmartDashboard.putNumber("Left Speed", rapidao);
            SmartDashboard.putNumber("Right Speed", rapidao2);
            SmartDashboard.putNumber("Magnitude", magnitude);
            SmartDashboard.putNumber("Seno", seno);
            SmartDashboard.putNumber("X", X);
            SmartDashboard.putNumber("Y", Y);
            SmartDashboard.putNumber("B_Speed", B_Speed);
            SmartDashboard.putBoolean("A Button", joydeliciu.getRawButton(1));
            SmartDashboard.putBoolean("B Button", joydeliciu.getRawButton(2));
            SmartDashboard.putBoolean("X Button", joydeliciu.getRawButton(3));
            SmartDashboard.putNumber("POV", joydeliciu.getPOV());
            SmartDashboard.putNumber("RT", joydeliciu.getRawAxis(3));
            SmartDashboard.putNumber("LT", joydeliciu.getRawAxis(2));
       } 

       public void calAnalogico2(){ 

        Y2 = joydeliciu.getRawAxis(5);
        X2 = joydeliciu.getRawAxis(4);

        magnitude2 = Math.max(-1, Math.min(1, Math.hypot(X2, Y2)));
        seno2 = Y2 / magnitude2;

        if (X2 > 0.04 && Y2 > 0.04) {
            rapidao = magnitude2 * B_Speed;
            rapidao2 = (2 * seno2 - 1) * magnitude2 * B_Speed;
        } else if (X2 < 0.04 && Y2 > 0.04) {
            rapidao = (2 * seno2 - 1) * magnitude2 * B_Speed;
            rapidao2 = magnitude2 * B_Speed;
        } else if (X2 >= 0.04 && Y2 < 0.04) {
            rapidao = magnitude2 * B_Speed * -1;
            rapidao2 = (2 * seno2 + 1) * magnitude2 * B_Speed;
        } else if (X2 < 0.04 && Y2 < 0.04) {
            rapidao = (2 * seno2 + 1) * magnitude2 * B_Speed;
            rapidao2 = magnitude2 * B_Speed * -1;
        }           

       }
       public void OiaAnalogico(){
       if (X2 >= 0.04 || X2 < -0.04 || Y2 >= 0.04 || Y2 < -0.04) {
         X = 0;
         Y = 0;
        } else if (X >= 0.04 || Y >= 0.04 || X < -0.04 || Y < -0.04) {
         X2 = 0;
         Y2 = 0;

       }
    }
}
    
