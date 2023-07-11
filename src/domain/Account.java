 package domain;

public class Account{

    protected String nick;
    protected String pass;

    public Account(){

    }

    public Account(String nick, String pass){
        this.nick = nick;
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    

 }