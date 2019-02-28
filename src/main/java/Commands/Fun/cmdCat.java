package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

import static Util.Tools.readJsonArrayFromUrl;

public class cmdCat implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            String url = "";
            JSONArray jsonArray = readJsonArrayFromUrl("https://api.thecatapi.com/v1/images/search");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);
                url = jsonobject.getString("url");
            }
            EmbedBuilder builder = new EmbedBuilder().setColor(STATIC.MAIN).setTitle("A cat for " + event.getMessage().getAuthor().getName()).setImage(url);
            event.getTextChannel().sendMessage(builder.build()).queue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
