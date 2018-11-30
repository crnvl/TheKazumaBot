package Commands.Games.PaladinsRequest;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.heyzeer0.papi.PaladinsAPI;
import net.heyzeer0.papi.enums.Platform;
import net.heyzeer0.papi.exceptions.UnknowPlayerException;
import net.heyzeer0.papi.profiles.requests.PaladinsPlayer;

import java.awt.*;

public class requestPaladinsUser implements Command {
    String DEV_ID = System.getenv("DEV_ID");
    String AUTH_KEY = System.getenv("AUTH_KEY");
    public PaladinsAPI api = new PaladinsAPI(DEV_ID, AUTH_KEY, Platform.PC);
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try{
            PaladinsPlayer p = api.getRequestManager().requestPlayer(args[0]);
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.CYAN)
                            .setTitle("User: " + p.getName() + " | ID: " + p.getID() + " | Level: " + p.getLevel())
                            .addField("Wins", " " + p.getWins(), true)
                            .addField("Losses", " " + p.getLosses(), true)
                            .addField("Leaves", " " + p.getLeaves(), true)
                            .addField("Join date", " " + p.getJoinDate(), true)
                            .addField("Last Login", " " + p.getLastLogin(), true)
                            .addField("Total Achievements", " " + p.getTotalArchievements() + "/58", true)
                            .addField("Region", " " + p.getRegion(), true)
                            .setThumbnail("https://i.pinimg.com/originals/e4/df/a2/e4dfa24b1b0c57472ffec4a0a99ef59b.jpg")
                            .setFooter("All rights reserved to HiRez and the Paladins Team", "https://i.pinimg.com/originals/e4/df/a2/e4dfa24b1b0c57472ffec4a0a99ef59b.jpg")
                            .build()).queue();
            /// and others
        }catch (UnknowPlayerException e) {
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.RED)
                            .setTitle("ERROR")
                            .setDescription("There is no player with that nick").build()).queue();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
