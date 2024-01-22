package org.example.webdt.dto.request;

public class ChangePassword {
    private String password;
    private String new_pass;
    private String new1_pass;
    
    public ChangePassword() {
    }

    public ChangePassword(String password, String new_pass, String new1_pass) {
        this.password = password;
        this.new_pass = new_pass;
        this.new1_pass = new1_pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNew_pass() {
        return new_pass;
    }

    public void setNew_pass(String new_pass) {
        this.new_pass = new_pass;
    }

    public String getNew1_pass() {
        return new1_pass;
    }

    public void setNew1_pass(String new1_pass) {
        this.new1_pass = new1_pass;
    }
    
}
