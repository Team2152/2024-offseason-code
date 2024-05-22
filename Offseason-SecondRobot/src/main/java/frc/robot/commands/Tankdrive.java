// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drivetrain;

import java.util.HashMap;
import java.util.Map;

public class Tankdrive extends Command {
  private final Drivetrain drivetrain;
  private final double leftThrottle;
  private final double rightThrottle;
  Map<CANSparkMax, CANSparkMax> motorFollowerMap;

  /** Creates a new Tankdrive. */
  public Tankdrive(Drivetrain driveTrain, double leftThrottle, double rightThrottle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = driveTrain;
    this.leftThrottle = leftThrottle;
    this.rightThrottle = rightThrottle;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    setupFollowers();
    drivetrain.setDriveTrain(new DifferentialDrive(null, null));
  }

  public Map<CANSparkMax, CANSparkMax> setupFollowers() {
    Map<String, CANSparkMax> motorMap = drivetrain.getMotors();
    CANSparkMax leftMaster = motorMap.get("leftFront");
    CANSparkMax leftSlave = motorMap.get("leftBack");
    CANSparkMax rightMaster = motorMap.get("rightFront");
    CANSparkMax rightSlave = motorMap.get("rightBack");

    Map<CANSparkMax, CANSparkMax> motorFollowerMap = new HashMap<>();
    motorFollowerMap.put(leftMaster, leftSlave);
    motorFollowerMap.put(rightMaster, rightSlave);
    return motorFollowerMap;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive();
  }

  public void drive() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
