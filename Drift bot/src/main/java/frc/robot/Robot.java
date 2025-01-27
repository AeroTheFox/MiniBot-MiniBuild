// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
  // Motor Controllers
  private final PWMVictorSPX m_frontLeft = new PWMVictorSPX(0);
  private final PWMVictorSPX m_backLeft = new PWMVictorSPX(1);
  private final PWMVictorSPX m_frontRight = new PWMVictorSPX(2);
  private final PWMVictorSPX m_backRight = new PWMVictorSPX(3);
  private final XboxController m_controller = new XboxController(0);
  private DifferentialDrive m_myRobot;
  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_backLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_backRight);
 
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
  
    // Tank drive (left motor, right motor)
    m_myRobot  = new DifferentialDrive(m_left, m_right);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
   
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() 
  {
    //m_robotDrive.arcadeDrive(m_controller.getY(GenericHID.Hand.kLeft), m_controller.getX(GenericHID.Hand.kLeft));
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_controller.getY(GenericHID.Hand.kLeft), m_controller.getY(GenericHID.Hand.kRight));
    //m_robotDrive.arcadeDrive(m_controller.getY(GenericHID.Hand.kLeft), m_controller.getX(GenericHID.Hand.kLeft));
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() 
  {
    //setSafetyEnabled( False);
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() 
  {
    m_myRobot.tankDrive(m_controller.getY(GenericHID.Hand.kLeft), m_controller.getY(GenericHID.Hand.kRight));
    //m_robotDrive.arcadeDrive(m_controller.getY(GenericHID.Hand.kLeft), m_controller.getX(GenericHID.Hand.kLeft));
  }

}