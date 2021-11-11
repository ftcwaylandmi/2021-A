package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class
Robot {
    private final double InchesPerSecond = .11;
    private final double DegreesPerSecond = .24;
    private int Armstart = 0;
    public final int ArmLimitFW = -7;
    public final int ArmLimitRV = -174;
    private int encodercountsperinch = 42;
    double encperdegree = 6.6;
    private boolean moving;

    RobotHardware myself = new RobotHardware();

    public void initHW(HardwareMap ahw) {
        myself.init(ahw);
    }

    public void initRobot() {
        Armstart = myself.iam.getCurrentPosition();
        moving = false;
    }

    public void spinWheel(double p) {
        myself.wheelMotor.setPower(p);
    }

    public void Drive(double p) {
        myself.leftFrontDrive.setPower(-p);
        myself.rightFrontDrive.setPower(-p);
        myself.leftBackDrive.setPower(-p);
        myself.rightBackDrive.setPower(-p);
    }

    public void StopDrive() {
        myself.leftFrontDrive.setPower(0);
        myself.rightFrontDrive.setPower(0);
        myself.leftBackDrive.setPower(0);
        myself.rightBackDrive.setPower(0);
    }

    public void SpinRight(double p) {
        myself.leftFrontDrive.setPower(p);
        myself.rightFrontDrive.setPower(-p);
        myself.leftBackDrive.setPower(p);
        myself.rightBackDrive.setPower(-p);
    }

    public void SpinLeft(double p) {
        myself.leftFrontDrive.setPower(-p);
        myself.rightFrontDrive.setPower(p);
        myself.leftBackDrive.setPower(-p);
        myself.rightBackDrive.setPower(p);
    }

    public void RightDrive(double p) {
        myself.rightFrontDrive.setPower(p);
        myself.rightBackDrive.setPower(p);
    }

    public void LeftDrive(double p) {
        myself.leftFrontDrive.setPower(p);
        myself.leftBackDrive.setPower(p);
    }

    public void wait(int sleeptime) {
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < sleeptime) {

        }
    }

    public void ArcRight(double p, double deg, int runTime) {
        final double mP = p - deg;
        myself.leftFrontDrive.setPower(-mP);
        myself.rightFrontDrive.setPower(-p);
        myself.leftBackDrive.setPower(-mP);
        myself.rightBackDrive.setPower(-p);
        wait(runTime);
        StopDrive();

    }

    public void ArcLeft(double p, double deg, int runTime) {
        final double mP = p - deg;
        myself.leftFrontDrive.setPower(-p);
        myself.rightFrontDrive.setPower(-mP);
        myself.leftBackDrive.setPower(-p);
        myself.rightBackDrive.setPower(-mP);
        wait(runTime);
        StopDrive();
    }

    public void spinCarouselLeft(double spin) {
        myself.wheelMotor.setPower(spin);
    }

    public void spinCarouselRight(double spin) {
        myself.wheelMotor.setPower(-spin);
    }

    public void intakeArmUp(double iarm) {
        myself.iam.setPower(iarm);
    }

    public void intakeArmDown(double iarm) {
        myself.iam.setPower(-iarm);
    }

    public void stopIntakeArm() {
        myself.iam.setPower(0);
    }

    public void intakeOn(double intake) {
        myself.im.setPower(intake);
    }

    public void intakeOff() {
        myself.im.setPower(0);
    }

    public void intakeReverse(double intake) {
        myself.im.setPower(-intake);
    }

    public void ArmDrive(double p) {
        myself.iam.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        /*if ((myself.iam.getCurrentPosition() > ArmLimitFW) && (p > 0)){
            myself.iam.setPower(0);
        } else if ((myself.iam.getCurrentPosition() > ArmLimitRV) && (p < 0)){
            myself.iam.setPower(0);
        } else{*/
        myself.iam.setPower(p);
    }

    //}


    public void DriveByInches(int inches) {
        moving = true;
        double power = 1;
        double waitTime = 0.00;

        if (inches > 0) {
            waitTime = inches * InchesPerSecond;
            myself.leftFrontDrive.setPower(power);
            myself.leftBackDrive.setPower(power);
            myself.rightFrontDrive.setPower(power);
            myself.rightBackDrive.setPower(power);
        } else {
            power = power * -1;
            waitTime = -inches * InchesPerSecond;
            myself.leftFrontDrive.setPower(power);
            myself.leftBackDrive.setPower(power);
            myself.rightFrontDrive.setPower(power);
            myself.rightBackDrive.setPower(power);
        }
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime * 100)) {

        }
        myself.leftFrontDrive.setPower(0);
        myself.leftBackDrive.setPower(0);
        myself.rightFrontDrive.setPower(0);
        myself.rightBackDrive.setPower(0);
        moving = false;

    }

    public void TurnByDegrees(int degrees) {
        moving = true;
        double power = 1;
        double waitTime = 0.00;

        if (degrees > 0) {
            waitTime = degrees * DegreesPerSecond;
            myself.leftFrontDrive.setPower(power * .92);
            myself.leftBackDrive.setPower(power * .92);
            myself.rightFrontDrive.setPower(-power * .92);
            myself.rightBackDrive.setPower(-power * .92);
        } else {
            waitTime = -degrees * DegreesPerSecond;
            myself.leftFrontDrive.setPower(-power * .92);
            myself.leftBackDrive.setPower(-power * .92);
            myself.rightFrontDrive.setPower(power * .92);
            myself.rightBackDrive.setPower(power * .92);
        }

        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (timer.milliseconds() < (waitTime * 10)) {

        }
        myself.leftFrontDrive.setPower(0);
        myself.leftBackDrive.setPower(0);
        myself.rightFrontDrive.setPower(0);
        myself.rightBackDrive.setPower(0);
        moving = false;

    }

    public void ResetEncoders(){
        myself.leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        myself.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        myself.rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        myself.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        myself.leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        myself.leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        myself.rightFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        myself.rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void DriveWithEncoders(double left, double right, double power) {
        moving = true;
        if ((myself.leftFrontDrive.getMode() != DcMotor.RunMode.RUN_USING_ENCODER) || (myself.leftBackDrive.getMode() != DcMotor.RunMode.RUN_USING_ENCODER)) {
            myself.leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            myself.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if ((myself.rightFrontDrive.getMode() != DcMotor.RunMode.RUN_USING_ENCODER) || (myself.rightBackDrive.getMode() != (DcMotor.RunMode.RUN_USING_ENCODER))) {
            myself.rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            myself.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if (power < 0) {
            power = -power;
        }
        int leftfrontinc = myself.leftFrontDrive.getCurrentPosition();
        int leftbackinc = myself.leftBackDrive.getCurrentPosition();
        int rightfrontinc = myself.rightFrontDrive.getCurrentPosition();
        int rightbackinc = myself.rightBackDrive.getCurrentPosition();
        int leftfront = (int) (leftfrontinc + left);
        int leftback = (int) (leftbackinc + left);
        int rightfront = (int) (rightfrontinc + right);
        int rightback = (int) (rightbackinc + right);
        myself.leftFrontDrive.setTargetPosition(leftfront);
        myself.leftBackDrive.setTargetPosition(leftback);
        myself.rightFrontDrive.setTargetPosition(rightfront);
        myself.rightBackDrive.setTargetPosition(rightback);
        myself.leftFrontDrive.setPower(power);
        myself.leftBackDrive.setPower(power);
        myself.rightFrontDrive.setPower(power);
        myself.rightBackDrive.setPower(power);
        if (leftfront != myself.leftFrontDrive.getCurrentPosition()) {
            myself.leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }else {
            myself.leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if (leftback != myself.leftBackDrive.getCurrentPosition()) {
            myself.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }else{
            myself.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if (rightfront != myself.rightFrontDrive.getCurrentPosition()) {
            myself.rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }else{
            myself.rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if (rightback != myself.rightBackDrive.getCurrentPosition()) {
            myself.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }else{
            myself.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        moving = false;

    }



    public void DriveForwardEncodersByInches(int inches, double power) {
        int dest = inches * encodercountsperinch;
        DriveWithEncoders(dest, dest, power);
    }

    public void TurnWithEncodersByDegrees(float degrees, double power) {
            DriveWithEncoders(degrees * encperdegree, -degrees * encperdegree, power);
    }

}
/*  */