package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;

    public DcMotor wheelMotor = null;
    public DcMotor iam = null;
    public DcMotor im = null;

    HardwareMap hwMap = null;

    public void init (HardwareMap ahwMap){
        hwMap = ahwMap;

        wheelMotor = hwMap.get(DcMotor.class, "wm");
        wheelMotor.setDirection(DcMotor.Direction.FORWARD);
        wheelMotor.setPower(0);

        leftFrontDrive = hwMap.get(DcMotor.class, "lfd");
        leftBackDrive = hwMap.get(DcMotor.class, "lbd");
        rightFrontDrive = hwMap.get(DcMotor.class, "rfd");
        rightBackDrive = hwMap.get(DcMotor.class, "rbd");

        iam = hwMap.get(DcMotor.class,"iam");
        im = hwMap.get(DcMotor.class, "im");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        iam.setDirection(DcMotor.Direction.FORWARD);
        im.setDirection(DcMotor.Direction.FORWARD);

        leftFrontDrive.setPower(0);
        rightFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);

        iam.setPower(0);
        im.setPower(0);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        iam.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}




