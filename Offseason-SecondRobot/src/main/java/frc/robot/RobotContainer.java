// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.commands.Tankdrive;;

public class RobotContainer {

  public Drivetrain m_Drivetrain;

  public final CommandXboxController m_driverController;
  

  public RobotContainer() {
    m_Drivetrain = new Drivetrain();
    
    m_driverController = new CommandXboxController(Constants.OIConstants.kDriverControllerPort);

    configureBindings();

    m_Drivetrain.setDefaultCommand(new Tankdrive(m_Drivetrain, m_driverController.getLeftY(), m_driverController.getRightY()));
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
