package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import pw.aru.api.nekos4j.Nekos4J;
import pw.aru.api.nekos4j.image.Image;
import pw.aru.api.nekos4j.image.ImageProvider;

public class cmdNeko implements Command {

    Nekos4J api = new Nekos4J.Builder().build();

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        ImageProvider imageProvider = api.getImageProvider();
        Image image = imageProvider.getRandomImage("neko").execute();
        event.getMessage().getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setColor(STATIC.MAIN)
                        .setTitle("A Neko for " + event.getAuthor().getAsTag())
                        .setImage(image.getUrl())
                        .build()
        ).queue();


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
