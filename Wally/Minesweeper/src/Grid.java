public class Grid {
    private boolean isBomb = false;
    private boolean isOpen = false;
    private int surroundingBombAmount = 0;

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setBomb() {
        isBomb = true;
    }

    public void setOpen() {
        isOpen = true;
    }

    public void setSurroundingBombAmount(int surroundingBombAmount) {
        this.surroundingBombAmount = surroundingBombAmount;
    }

    @Override
    public String toString() {
        if (isOpen) {
            if (isBomb) {
                return "*";
            } else {
                return String.valueOf(surroundingBombAmount);
            }
        } else {
            return "-";
        }
    }
}
