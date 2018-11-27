package Commands.Games.OsuRequest;

import Commands.Command;
import Util.STATIC;
import com.oopsjpeg.osu4j.GameMode;
import com.oopsjpeg.osu4j.OsuBeatmap;
import com.oopsjpeg.osu4j.OsuScore;
import com.oopsjpeg.osu4j.OsuUser;
import com.oopsjpeg.osu4j.backend.EndpointUsers;
import com.oopsjpeg.osu4j.backend.Osu;
import com.oopsjpeg.osu4j.exception.OsuAPIException;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.net.MalformedURLException;

public class requestGetUser implements Command {

    private static final int TOP_SCORE_LIMIT = 3;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        // Create a new Osu object with an API key
        String USER = args[0];
        if(args[1].contains("mania")) {
            GameMode MODE = GameMode.MANIA;
        }else if(args[1].contains("taiko")) {
            GameMode MODE = GameMode.TAIKO;
        }else if(args[1].contains("ctb")) {
            GameMode MODE = GameMode.CATCH_THE_BEAT;
        }else if(args[1].contains("standard")) {
            GameMode MODE = GameMode.STANDARD;
        }else {
            GameMode MODE = GameMode.STANDARD;
        }
        GameMode MODE = GameMode.STANDARD;
        String key = System.getenv("OSU_KEY");
        Osu osu = Osu.getAPI(key);
        try {
            OsuUser user = osu.users.query(new EndpointUsers.ArgumentsBuilder(USER).setMode(MODE).build());


            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle("Osu profile of " + user.getUsername())
                            .addField("ID", "``" + user.getID() + "``", false)
                            .addField("Country", "``" + user.getCountry() + "``", true)
                            .addField("Accuracy", "``" + user.getAccuracy() + "``", true)
                            .addField("Played Maps", "``" + user.getPlayCount() + "``", true)
                            .addField("Total Score", "``" + user.getTotalScore() + "``", false)
                            .addField("User URL","``" + user.getURL() + "``", false)
                            .addField("Ranking", "``#" + user.getRank() + "(" + user.getPP() + "pp) #" + user.getCountryRank() + "``", false)
                            .addField("Total Score", "``" + user.getTotalScore() + "``", false)
                            .addField("Ranks", "``" + user.getCountRankSSH() + ", " + user.getCountRankSS() + ", " + user.getCountRankSH() + ", " + user.getCountRankS() + ", " + user.getCountRankA() + "``", false)
                            .addField("Best Performances", "``" + user.getTopScores(TOP_SCORE_LIMIT), false)
                            .build()

            ).queue();

        }catch (OsuAPIException e) {
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle("Osu API Exception")
                            .setDescription("It seems like there was an exception while executing this command! Did you type everything correctly?\n" +
                                            "Please try again or contact our staff team with ``" + STATIC.PREFIX + "report <your report description>``")
                            .addField("Error Code", "GenO1", true)
                            .build()

            ).queue();
        } catch (MalformedURLException e) {
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle("Osu API Exception")
                            .setDescription("It seems like there was an exception while executing this command!\n" +
                                    "Please try again or contact our staff team with ``" + STATIC.PREFIX + "report <your report description>``")
                            .addField("Error Code", "GenO2", true)
                            .build()

            ).queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }



}
