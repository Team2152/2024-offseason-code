// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  private CANSparkMax leftFront;
  // private CANSparkMax leftBack;
  private CANSparkMax rightFront;
  // private CANSparkMax rightBack;
  // private DifferentialDrive m_drivetrain;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // Sets new motors.
    leftFront = new CANSparkMax(DriveConstants.leftFront, MotorType.kBrushless);
    // leftBack = new CANSparkMax(DriveConstants.leftBack, MotorType.kBrushless);
    rightFront = new CANSparkMax(DriveConstants.rightFront, MotorType.kBrushless);
    // rightBack = new CANSparkMax(DriveConstants.rightBack, MotorType.kBrushless);

    // SendableRegistry.addChild(m_drivetrain, leftFront);
    // SendableRegistry.addChild(m_drivetrain, rightFront);

    //leftBack.follow(leftFront);
    //rightBack.follow(rightFront);

    //m_drivetrain = new DifferentialDrive(leftFront, rightFront);  
  }

  @Override
  public void periodic() {
    // m_drivetrain.feed();

    leftFront.set(1);
    rightFront.set(1);
    System.out.println(leftFront.get() + " | " + rightFront.get());
  }


  // public void drive(double leftThrottle, double rightThrottle, boolean limiter)  {
  //   if (limiter) {
  //     leftThrottle /= DriveConstants.kLimiterModifier;
  //     rightThrottle /= DriveConstants.kLimiterModifier;
  //   }
  //   m_drivetrain.arcadeDrive(leftThrottle, rightThrottle);
  // }

  // public Command teleopDrive(DoubleSupplier leftThrottle, DoubleSupplier rightThrottle, BooleanSupplier limiter) {
  //     return run(() -> {
  //         double leftOutput = -MathUtil.applyDeadband(leftThrottle.getAsDouble(), OIConstants.kDriveDeadband);
  //         double rightOutput = -MathUtil.applyDeadband(rightThrottle.getAsDouble(), OIConstants.kDriveDeadband);
  //         boolean limited = limiter.getAsBoolean();

  //         //drive(leftOutput, rightOutput, limited);
  //     });
  // }
}
