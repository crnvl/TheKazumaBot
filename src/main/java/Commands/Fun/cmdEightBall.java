package Commands.Fun;

import Commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

public class cmdEightBall implements Command {

    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {

        String[] answers = {
                "Of course!",
                "Yes, sure!",
                "Yes!",
                "Maybe..",
                "hm.. :thinking:",
                "Never!"
        };

        Integer randInt = new Random().nextInt(6);

        String msg = "";
        for (String a : args) {
            msg += a + " ";
        }

        if(args.length == 0) {
            event.getTextChannel().sendMessage("Please specify your request!").queue();
        }else {
            event.getTextChannel().sendMessage(
                    "Question: " + msg + "\n" +
                            "Answer: " + answers[randInt]
            ).queue();
        }


    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
