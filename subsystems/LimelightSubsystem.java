package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {
    private static final NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    private final NetworkTableEntry txEntry = limelightTable.getEntry("tx");
    private final NetworkTableEntry tyEntry = limelightTable.getEntry("ty");
    private final NetworkTableEntry taEntry = limelightTable.getEntry("ta");

    private double[] distanceHistory = new double[5];
    private int historyIndex = 0;

    public LimelightSubsystem() {
        // Initialize subsystem
    }

    @Override
    public void periodic() {
        // Update distance history
        double distance = calculateDistance();
        distanceHistory[historyIndex] = distance;
        historyIndex = (historyIndex + 1) % distanceHistory.length;

        // Calculate average distance
        double averageDistance = 0;
        for (double d : distanceHistory) {
            averageDistance += d;
        }
        averageDistance /= distanceHistory.length;

        // Set average distance to SmartDashboard
        SmartDashboard.putNumber("Average Distance", averageDistance);
    }

    private double calculateDistance() {
        double angleX = txEntry.getDouble(0.0);
        double angleY = tyEntry.getDouble(0.0);
        double area = taEntry.getDouble(0.0);

        // Assuming focal length of 3.66 inches and target height of 10 feet
        double focalLength = 3.66;
        double targetHeight = 10 * 12; // Convert feet to inches

        double distance = (focalLength * targetHeight) / (area * Math.tan(Math.toRadians(angleY)));
        return distance;
    }

    public double getAverageDistance() {
        double averageDistance = 0;
        for (double d : distanceHistory) {
            averageDistance += d;
        }
        averageDistance /= distanceHistory.length;
        return averageDistance;
    }
}
