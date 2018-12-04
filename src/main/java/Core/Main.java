package Core;

import Commands.*;
import Commands.BotCmds.cmdAbout;
import Commands.BotCmds.cmdReport;
import Commands.BotCmds.cmdVote;
import Commands.DiscordBotsOrg.cmdStatistics;
import Commands.Fun.*;
import Commands.Games.OsuRequest.requestGetUser;
import Commands.Games.PaladinsRequest.requestPaladinsUser;
import Commands.Kawaii.*;
import Commands.Language.cmdJapanese;
import Commands.Moderation.*;
import Commands.Owner.cmdOwnerSet;
import Core.Execute.CommandHandler;
import Listeners.Loader.RegisterListener;
import Util.SECRETS;
import Util.STATIC;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException, InterruptedException {
        builder = new JDABuilder(AccountType.BOT);

        //Important
        builder.setToken(SECRETS.TOKEN);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("http://kazumabot.rf.gd/ | " + STATIC.PREFIX + "help"));


        //Listeners
        builder.addEventListener(new RegisterListener());

        addCommands();


        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
            builder.setStatus(OnlineStatus.IDLE);
            builder.setGame(Game.playing("low processing mode | Kazuma will be back soon!"));
        }   catch (InterruptedException e) {
            e.printStackTrace();
            builder.setStatus(OnlineStatus.IDLE);
            builder.setGame(Game.playing("low processing mode | Kazuma will be back soon!"));
        }

    }
    public static void addCommands() {


        //Bot Commands
        CommandHandler.commands.put("about", new cmdAbout());
        CommandHandler.commands.put("db", new cmdStatistics());
        CommandHandler.commands.put("discordbots", new cmdStatistics());
        CommandHandler.commands.put("help", new cmdHelp());
        CommandHandler.commands.put("vote", new cmdVote());
        CommandHandler.commands.put("report", new cmdReport());

        //Fun
        CommandHandler.commands.put("8ball", new cmdEightBall());
        CommandHandler.commands.put("ratewaifu", new cmdRateWaifu());
        CommandHandler.commands.put("ship", new cmdLovelyShip());
        CommandHandler.commands.put("japanese", new cmdJapanese());
        CommandHandler.commands.put("profile", new cmdProfile());
        CommandHandler.commands.put("say", new cmdSay());

        //Kawaii / Weeb commands lol
        CommandHandler.commands.put("hug", new hug());
        CommandHandler.commands.put("kiss", new kiss());
        CommandHandler.commands.put("cuddle", new cuddle());
        CommandHandler.commands.put("highfive", new highfive());
        CommandHandler.commands.put("lick", new lick());
        CommandHandler.commands.put("hello", new hello());
        CommandHandler.commands.put("nom", new nom());
        CommandHandler.commands.put("pat", new pat());
        CommandHandler.commands.put("slap", new slap());
        CommandHandler.commands.put("tickle", new tickle());
        CommandHandler.commands.put("nosebleed", new nosebleed());
        CommandHandler.commands.put("dance", new dance());
        CommandHandler.commands.put("baka", new baka());
        CommandHandler.commands.put("cry", new cry());

        //Moderation Commands
        CommandHandler.commands.put("setjoinmessage", new cmdSetJoinMessage());
        CommandHandler.commands.put("announcechannel", new cmdSetAnnouncementChannel());
        CommandHandler.commands.put("setleavemessage", new cmdSetLeaveMessage());
        CommandHandler.commands.put("setautorole", new cmdSetAutorole());
        CommandHandler.commands.put("setcountchannel", new cmdSetCountingChannel());
        CommandHandler.commands.put("setcountstart", new setCountStarter());

        //GAMES
        CommandHandler.commands.put("osu", new requestGetUser());
        CommandHandler.commands.put("paladins", new requestPaladinsUser());


        //OWNER
        CommandHandler.commands.put("refresh", new cmdOwnerSet());


    }

}
