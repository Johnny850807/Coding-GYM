package Landmine;

public class Grid implements Item {

    private boolean isLandmine = false;
    private String status = "-";
    private boolean isStepped =false;

    @Override
    public void print() {
        if(isStepped) {
            System.out.print(status + "\t");
        }else{
            System.out.print("-" + "\t");
        }
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void setStepped(boolean stepped) {
        this.isStepped = stepped;
    }

    public boolean isLandmine() {
        return isLandmine;
    }

    public void setLandmine(boolean hasLanmine) {
        this.isLandmine = hasLanmine;
        if(isLandmine) {
            this.status = "*";
        }
    }


}