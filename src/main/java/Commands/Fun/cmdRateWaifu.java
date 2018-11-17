package Commands.Fun;

import Commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class cmdRateWaifu implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length == 0) {
            send(event.getMessage().getAuthor().getName(), event);
        }else {
            List argsList = Arrays.asList(args);
            StringBuilder sb = new StringBuilder();
            argsList.forEach(s -> sb.append(s + " "));
            send(sb.toString(), event);
        }

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }


    private void send(String msg, MessageReceivedEvent event) {
        Random rate = new Random();
        int y = rate.nextInt(11);
        event.getTextChannel().sendMessage(msg + " is a " + y + "/10 Waifu :wink:").queue();

    }
}
