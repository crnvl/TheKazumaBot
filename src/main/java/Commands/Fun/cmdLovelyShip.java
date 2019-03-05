package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Random;

public class cmdLovelyShip implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Random rate = new Random();
        int y = rate.nextInt(101);
      if(event.getMessage().getMentionedMembers().size() == 0) {
          event.getTextChannel().sendMessage("You need to specify your request!").queue();
      }else {
          event.getTextChannel().sendMessage(

                  new EmbedBuilder()
                          .setColor(STATIC.MAIN)
                          .setTitle("Lovely shipping " + event.getMessage().getAuthor().getName() + " and " + event.getMessage().getMentionedMembers().get(0).getEffectiveName())
                          .addField("Shipability", "``" + y + "%``", false)
                  .build()

          ).queue();
      }

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
    }


}
