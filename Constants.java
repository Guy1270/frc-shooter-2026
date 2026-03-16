package frc.robot;

/**
 * Constants for the robot.
 */
public final class Constants {
    // CAN IDs
    public static final int FLYWHEEL_MOTOR_ID = 10;
    public static final int HOOD_MOTOR_ID = 11;
    public static final int PIGEON_ID = 20;
    public static final int LIMELIGHT_ID = 0; // Assuming Limelight uses CAN ID 0

    // PID Gains
    public static final double FLYWHEEL_KP = 0.1; // Units: RPM per degree
    public static final double FLYWHEEL_KI = 0.01; // Units: RPM per degree
    public static final double FLYWHEEL_KD = 0.001; // Units: RPM per degree

    public static final double HOOD_KP = 0.1; // Units: Degrees per degree
    public static final double HOOD_KI = 0.01; // Units: Degrees per degree
    public static final double HOOD_KD = 0.001; // Units: Degrees per degree

    // Interpolation Table
    public static final double[][] DISTANCE_TABLE = {
        {10, 1000}, // Distance in inches, RPM
        {20, 2000},
        {30, 3000},
        {40, 4000},
        {50, 5000}
    };

    // Tuning Comments
    // FLYWHEEL_KP: Adjust to increase/decrease RPM per degree of error
    // FLYWHEEL_KI: Adjust to increase/decrease RPM per degree of error over time
    // FLYWHEEL_KD: Adjust to increase/decrease RPM per degree of error rate
    // HOOD_KP: Adjust to increase/decrease degrees per degree of error
    // HOOD_KI: Adjust to increase/decrease degrees per degree of error over time
    // HOOD_KD: Adjust to increase/decrease degrees per degree of error rate
    // DISTANCE_TABLE: Adjust RPM values based on distance for optimal shooting
}
