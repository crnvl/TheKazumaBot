package Commands.BotCmds;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Random;

public class cmdReport implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

      if(args.length == 0) {
          event.getTextChannel().sendMessage(

                  new EmbedBuilder()
                          .setTitle("Please describe your Problem!")
                          .setDescription("You need to specify your report!")
                          .build()

          ).queue();

      }else {

          Random REPORT_ID = new Random();
          int ID_OUT = REPORT_ID.nextInt(4000) + 1;
          String CONTENT = event.getMessage().getContentRaw().replace(STATIC.PREFIX + "report ", "");

          event.getJDA().getGuildById("513326840665079809").getTextChannelById("513339470775582721").sendMessage(


                          new EmbedBuilder()
                                  .setTitle("New Bug Report | ID: " + ID_OUT)
                                  .setDescription(CONTENT)
                                  .setFooter("This Bug has been reported by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getAvatarUrl())
                                  .build()

                  ).queue();


          event.getTextChannel().sendMessage(

                  new EmbedBuilder()
                          .setTitle("Bug Reported!")
                          .setDescription("Thank you for reporting your bug! Our Team will take care of it as soon as possible.\n" +
                                            "Join [here](https://discord.gg/fyJ6PFj) to see, when your bug is fixed!")
                          .setFooter("Your Report ID is " + ID_OUT, null)
                          .build()

          ).queue();


      }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
