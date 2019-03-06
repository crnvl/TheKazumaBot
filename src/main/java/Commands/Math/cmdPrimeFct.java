package Commands.Math;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdPrimeFct implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length != 0) {

            int number = Integer.parseInt(args[0]);
            int divider = 2;
            String allDividers = "";

            if (number > 0) {


    
                if (number < 100000000) {

                    while (divider <= number) {
                        if (number % divider == 0) {
                            number = number / divider;
                            allDividers = allDividers + divider + ", ";
                        } else {
                            divider++;
                        }
                    }

                    String factors = allDividers.substring(0, allDividers.length() - 2);

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Prime Factorization")
                                    .setDescription("The prime factors of your Number are: " + factors)
                                    .build()

                    ).queue();
                }else{
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder()
                                    .setTitle("Your number must be smaller than 100000000!")
                                    .setColor(Color.RED)
                                    .setDescription("Please use this command like this: ``/k primefct <integer>``")
                                    .build()
                    ).queue();
                }

            }else{

                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle("Your number must be bigger than 0!")
                                .setColor(Color.RED)
                                .setDescription("Please use this command like this: ``/k primefct <integer>``")
                                .build()
                ).queue();
            }
        } else {

            event.getTextChannel().sendMessage(
                    new EmbedBuilder()
                            .setTitle("Please specify your request!")
                            .setColor(Color.RED)
                            .setDescription("Please use this command like this: ``/k primefct <integer>``")
                            .build()
            ).queue();

        }





    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
