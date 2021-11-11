package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "LRAutonomous2", group = "11846")
public class LRAutonomous2 extends LinearOpMode {
    private ElapsedTime myruntime = new ElapsedTime();
    private Robot myrobot = new Robot();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "I am booting up. Almost there");
        telemetry.update();

        myrobot.initHW(hardwareMap); // You forgot to init hardware

        waitForStart();
        myruntime.reset();

        myrobot.DriveByInches(24);
        myrobot.TurnByDegrees(-90);
        myrobot.DriveByInches(24);

    }
}