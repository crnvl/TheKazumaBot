package Core;

import Commands.BotCmds.*;
import Commands.DiscordBotsOrg.cmdStatistics;
import Commands.Fun.*;
import Commands.Games.OsuRequest.requestGetUser;
import Commands.Games.PaladinsRequest.requestPaladinsUser;
import Commands.Kawaii.cuddle;
import Commands.Kawaii.hug;
import Commands.Kawaii.kiss;
import Commands.Language.cmdJapanese;
import Commands.Math.cmdPrimeFct;
import Commands.Owner.cmdOwnerSet;
import Commands.Social.cmdBalance;
import Commands.Social.cmdRedeem;
import Commands.Social.cmdShop;
import Commands.cmdHelp;
import Core.Execute.CommandHandler;
import Listeners.Cmd.CommandListener;
import Listeners.Loader.ListRefresh;
import Listeners.Loader.RegisterListener;
import Listeners.Loader.ResetService;
import Util.SECRETS;
import Util.STATIC;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;
import Commands.Kawaii.*;
import Commands.Moderation.*;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) throws LoginException, InterruptedException {
        builder = new JDABuilder(AccountType.BOT);




        //Important
        builder.setToken(SECRETS.TOKEN);

        //Status
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Loading. . . | " + STATIC.PREFIX + "help"));


        //Listeners
        builder.addEventListener(new ResetService());
        builder.addEventListener(new RegisterListener());
        builder.addEventListener(new ListRefresh());

        addCommands();

        try {
            JDA jda = builder.buildBlocking();
            Timer myTimer1 = new Timer();
            TimerTask task = new TimerTask() {
                int secondsPassed = 0;
                @Override
                public void run() {
                    switch(secondsPassed){
                        case 0: jda.getPresence().setGame(Game.playing(STATIC.PREFIX + "help"));
                            secondsPassed++;
                            break;
                        case 1:   jda.getPresence().setGame(Game.playing("with " + jda.getPresence().getJDA().getUsers().size() + " Users! | " + STATIC.PREFIX + "help"));
                            secondsPassed++;
                            break;
                        case 2: jda.getPresence().setGame(Game.playing("on " + jda.getPresence().getJDA().getGuilds().size() + " Guilds! | " + STATIC.PREFIX + "help"));
                            secondsPassed++;
                            break;
                        case 3: jda.getPresence().setGame(Game.playing("already visited the shop? (/k shop) | " + STATIC.PREFIX + "help"));
                            secondsPassed++;
                            secondsPassed = 0;
                            break;
                    }
                }
            };
            myTimer1.schedule(task, 30000, 30000);
        } catch (LoginException e) {
            e.printStackTrace();
        }


    }
    public static void addCommands() {
        //Bot Commands
        CommandHandler.commands.put("randcolor", new cmdRanColor());
        CommandHandler.commands.put("shop", new cmdShop());
        CommandHandler.commands.put("primefct", new cmdPrimeFct());
        CommandHandler.commands.put("about", new cmdAbout());
        CommandHandler.commands.put("db", new cmdStatistics());
        CommandHandler.commands.put("discordbots", new cmdStatistics());
        CommandHandler.commands.put("help", new cmdHelp());
        CommandHandler.commands.put("vote", new cmdVote());
        CommandHandler.commands.put("report", new cmdReport());
        CommandHandler.commands.put("invite", new cmdInvite());

         //Social
        CommandHandler.commands.put("redeem", new cmdRedeem());
        CommandHandler.commands.put("daily", new cmdRedeem());
        CommandHandler.commands.put("balance", new cmdBalance());

        //Fun
        CommandHandler.commands.put("8ball", new cmdEightBall());
        CommandHandler.commands.put("ratewaifu", new cmdRateWaifu());
        CommandHandler.commands.put("ship", new cmdLovelyShip());
        CommandHandler.commands.put("japanese", new cmdJapanese());
        CommandHandler.commands.put("profile", new cmdProfile());
        CommandHandler.commands.put("say", new cmdSay());
        CommandHandler.commands.put("leaderboard", new cmdLeaderboard());
        CommandHandler.commands.put("lb", new cmdLeaderboard());
         CommandHandler.commands.put("brainfuck", new cmdBf());
         CommandHandler.commands.put("dog", new cmdDog());
         CommandHandler.commands.put("cat", new cmdCat());
         CommandHandler.commands.put("neko", new cmdNeko());
         CommandHandler.commands.put("owofy", new cmdOwofy());

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
        //CommandHandler.commands.put("setcountstart", new setCountStarter());
        CommandHandler.commands.put("setglobalchat", new cmdSetGlobalChat());

        //GAMES
        CommandHandler.commands.put("osu", new requestGetUser());
        CommandHandler.commands.put("paladins", new requestPaladinsUser());


        //OWNER
        CommandHandler.commands.put("register", new cmdOwnerSet());
        CommandHandler.commands.put("botban", new cmdBotBan());

        //TEST
        //CommandHandler.commands.put("backup", new cmdBackup());



    }

}
