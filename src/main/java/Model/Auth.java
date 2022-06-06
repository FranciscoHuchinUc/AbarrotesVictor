package Model;

public class Auth {
    
    private int id;
    private String curp;
    private String pass;

    public Auth() {
    }

    public Auth(int id, String curp, String pass) {
        this.id = id;
        this.curp = curp;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
       
    
    
}
