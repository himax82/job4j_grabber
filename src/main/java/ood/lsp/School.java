package ood.lsp;

public class School {

    private int emergencyExit;
    private int numbersSecurity;
    private int fireExtinguisher;
    private int floor;

    public School(int emergencyExit, int numbersSecurity, int fireExtinguisher, int floor) {
        this.emergencyExit = emergencyExit;
        this.numbersSecurity = numbersSecurity;
        this.fireExtinguisher = fireExtinguisher;
        this.floor = floor;
    }

    public int getEmergencyExit() {
        return emergencyExit;
    }

    public void setEmergencyExit(int emergencyExit) {
        if (emergencyExit < 4) {
            throw new IllegalArgumentException("Количество запасных выходов не может быть меньше 4");
        }
        this.emergencyExit = emergencyExit;
    }

    public int getNumbersSecurity() {
        return numbersSecurity;
    }

    public void setNumbersSecurity(int numbersSecurity) {
        if (numbersSecurity < 2) {
            throw new IllegalArgumentException("Количество охраников не может быть меньше 2");
        }
        this.numbersSecurity = numbersSecurity;
    }

    public int getFireExtinguisher() {
        return fireExtinguisher;
    }

    public void setFireExtinguisher(int fireExtinguisher) {
        if (numbersSecurity < 2 * floor) {
            throw new IllegalArgumentException("Коливество огнетушителей не может быть меньше 2-х на один этаж.");
        }
        this.fireExtinguisher = fireExtinguisher;
    }

    class College extends School {

        public College(int emergencyExit, int numbersSecurity, int fireExtinguisher, int floor) {
            super(emergencyExit, numbersSecurity, fireExtinguisher, floor);
        }

        public int getEmergencyExit() {
            return emergencyExit;
        }

        public void setEmergencyExit(int emergencyExit) {
            if (emergencyExit < 4) {
                throw new IllegalArgumentException("Количество запасных выходов не может быть меньше 4");
            }
            super.emergencyExit = emergencyExit;
        }

        public int getNumbersSecurity() {
            return numbersSecurity;
        }

        public void setNumbersSecurity(int numbersSecurity) {
            if (numbersSecurity < 2) {
                throw new IllegalArgumentException("Количество охраников не может быть меньше 2");
            }
            super.numbersSecurity = numbersSecurity;
        }

        public int getFireExtinguisher() {
            return fireExtinguisher;
        }

        public void setFireExtinguisher(int fireExtinguisher) {
            super.fireExtinguisher = fireExtinguisher;
        }

    }
}
