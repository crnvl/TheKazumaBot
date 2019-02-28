package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class cmdDog implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        URL url;
        try {
            URLConnection con = new URL("https://api.thedogapi.com/v1/images/search?format=src&mime_types=image/jpg").openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            url = con.getURL();
            is.close();
            EmbedBuilder builder = new EmbedBuilder().setColor(STATIC.MAIN).setTitle("a dog for " + event.getMessage().getAuthor().getName()).setImage(url.toString()).setColor(Color.YELLOW);
            event.getTextChannel().sendMessage(builder.build()).queue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
