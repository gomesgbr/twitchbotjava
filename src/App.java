import domain.Account;
import domain.SocketModel;
import enums.Command;

public class App {
    public static void main(String[] args) throws Exception {
        SocketModel socketModel = new SocketModel("irc.chat.twitch.tv", 6667, new Account("",""));
        socketModel.connect();
    }
}
