package engtelecom.poo;

import java.util.Arrays;

public class Counter {
    /**
     * Check if counter is progressive or regressive
     */
    private int isProgressive;
    private final int[] MAX_CLOCK = { 99, 59, 59 };
    private final int[] MIN_CLOCK = { 00, 00, 00 };
    /*
     * clockValue used to keep track of current time
     * clockValue[0] - hour
     * clockValue[1] - minutes
     * clockValue[2] - seconds
     */
    private int[] clockValue = new int[3];
    /*
     * clockValue used to keep track of target time
     * clockValue[0] - hour
     * clockValue[1] - minutes
     * clockValue[2] - seconds
     */
    private int[] clockTarget = new int[3];

    public Counter(int isProgressive, int[] clockParameter) {
        this.isProgressive = setIsProgressive(isProgressive);
        setClock(clockParameterCheck(clockParameter));
    }

    /**
     * Method that will check if array is acceptable
     * 
     * @param clockParameter - method that was passed by user
     * @return - returns the array
     */
    public int[] clockParameterCheck(int[] clockParameter) {
        for (int i = 0; i < clockParameter.length; i++) {
            if (clockParameter[i] < MIN_CLOCK[i] || clockParameter[i] > MAX_CLOCK[i])
                clockParameter[i] = 0;
        }
        return clockParameter;
    }

    /**
     * Method that will set how the counter will progress to the desired time
     * 
     * @param clockValue - time that wants to work with
     */
    private void setClock(int[] clockValue) {
        if (isProgressive == 1) {
            clockTarget = clockValue.clone();
            this.clockValue = new int[] { 0, 0, 0 };
        } else {
            this.clockValue = clockValue;
            clockTarget = new int[] { 0, 0, 0 };
        }
    }

    /**
     * Method that will check if isProgressive is in the desired parameter
     * 
     * @param isProgressive - Value indicating if its progressive or regressive
     * @return - returns result
     */
    private int setIsProgressive(int isProgressive) {
        if (isProgressive != -1 && isProgressive != 1) {
            return 1;
        }
        return isProgressive;
    }

    public int[] getClockValue() {
        return clockValue;
    }

    /**
     * Method that will run the timer 1 unit
     */
    public void runCounter() {
        if (Arrays.equals(this.clockTarget, this.clockValue))
            return;
        seconds();
    }

    /**
     * Method that will work in the hours progress
     */
    private void hours() {
        if (this.clockValue[0] >= 0 && this.clockValue[0] <= 99) {
            if (isProgressive == 1) {
                this.clockValue[1] = 0;
            } else {
                this.clockValue[1] = 59;
            }
            this.clockValue[0] = this.clockValue[0] + isProgressive;
        }
        if (this.clockValue[0] == -1 || this.clockValue[0] == 100) {
            if (isProgressive == 1) {
                this.clockValue[0] = 0;
            } else {
                this.clockValue[0] = 99;
            }
        }
    }

    /**
     * Method that will work in the minutes progress
     */
    private void minutes() {
        if (this.clockValue[1] >= 0 && this.clockValue[1] <= 59) {
            if (isProgressive == 1) {
                this.clockValue[2] = 0;
            } else {
                this.clockValue[2] = 59;
            }
            this.clockValue[1] = this.clockValue[1] + isProgressive;
        }
        if (this.clockValue[1] == -1 || this.clockValue[1] == 60) {
            hours();
        }
    }

    /**
     * Method that will work in the second progress
     */
    private void seconds() {
        if (this.clockValue[2] >= 0 || this.clockValue[2] <= 59) {
            this.clockValue[2] = this.clockValue[2] + isProgressive;
        }
        if (this.clockValue[2] == -1 || this.clockValue[2] == 60) {
            minutes();
        }

    }

}
