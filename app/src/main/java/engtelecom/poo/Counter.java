package engtelecom.poo;

public class Counter {
    /**
     * Check if counter is progressive or regressive
     */
    private int isProgressive;
    private final int[] MAX_CLOCK = { 99, 59, 59 };
    private final int[] MIN_CLOCK = { 00, 00, 00 };
    /*
     * clockValue used to keep track of time
     * clockValue[0] - hour
     * clockValue[1] - minutes
     * clockValue[2] - seconds
     */
    private int[] clockValue = new int[3];

    public Counter(int isProgressive, int[] clockValue) {
        this.isProgressive = setIsProgressive(isProgressive);
        this.clockValue = clockValue;
    }

    private int setIsProgressive(int isProgressive) {
        if (isProgressive != -1 && isProgressive != 1) {
            return 1;
        }
        return isProgressive;
    }

    public int[] getClockValue() {
        return clockValue;
    }

    private void setTime(int[] time) {
        for (int i = 0; i < time.length; i++) {
            if (clockValue[i] > MAX_CLOCK[i] || clockValue[i] < MIN_CLOCK[i]) {
                clockValue[i] = 0;
            }
        }
    }

    public void runCounter() {
        seconds();
    }

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
            hours();
        }
    }

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

    private void seconds() {
        if (this.clockValue[2] >= 0 || this.clockValue[2] <= 59) {
            this.clockValue[2] = this.clockValue[2] + isProgressive;
        }
        if (this.clockValue[2] == -1 || this.clockValue[2] == 60) {
            minutes();
        }

    }

}
