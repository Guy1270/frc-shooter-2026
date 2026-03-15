# Project: FRC Shooter System 2026
## Tech Stack
- Java 17, WPILib 2026
- Command-based robot framework
- Gradle build system
- Phoenix 6 2026 (CTRE) for all motor control
- Limelight 4 via NT4 NetworkTables

## Hardware
- 1x Kraken X60 (TalonFX) single flywheel, CAN ID 10
- 1x Falcon 500 (TalonFX) hood motor, 25:1 planetary gearbox, CAN ID 11
- 1x Limelight 4, front-facing, NetworkTables name "limelight"
- 1x Pigeon 2.0, CAN ID 20, Phoenix 6 2026 API

## 2026 API Notes
- This is the 2026 FRC season
- Phoenix 6 2026: use TalonFX with 2026 control requests
- Use MotionMagicVelocityVoltage and MotionMagicPositionVoltage
- Pigeon2 uses StatusSignals via Phoenix 6 2026 API
- WPILib 2026: use latest CommandScheduler and SubsystemBase
- Limelight: use latest LimelightHelpers.java from docs.limelightvision.io
- Do NOT use any deprecated Phoenix 5 or pre-2026 WPILib classes

## Rules
- Use Command-based architecture only
- Subsystems go in: src/main/java/frc/robot/subsystems/
- Commands go in: src/main/java/frc/robot/commands/
- Constants go in: src/main/java/frc/robot/Constants.java
- Build command: ./gradlew build
- After EVERY individual file is completed:
    git add . && git commit -m "complete: [filename]" && git push
- Never move to the next file until current one compiles cleanly

## When You Finish
- ./gradlew build must pass with zero errors
- Write a short summary in CHANGES.md
