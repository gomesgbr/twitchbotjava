package enums;

public enum Command {
    PASS(1),
    NICK(2),
    PRIVMSG(3),
    PONG(4),
    JOIN(5);

    private int code;

    private Command(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Command valueOf(int code){
        for(Command cmd: Command.values()){
            if(cmd.getCode() == code){
                return cmd;
            }
        }

        throw new IllegalArgumentException("Invalid command code");
    }
}
