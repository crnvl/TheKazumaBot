package Commands.BotCmds;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdAbout implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        int mb = 1024 * 1024;
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setTitle("Info Card")
                        .setDescription("This Bot has been created by " + event.getJDA().getUserById("265849018662387712").getName() + "#" + event.getJDA().getUserById("265849018662387712").getDiscriminator() + " using Java/JDA.\n")
                        .addField("Developer", "[GitHub](https://www.github.com/shinixsensei-dev/)\n" +
                                "[Twitter](https://www.twitter.com/shinixsensei/)", true)
                        .addField("System", "Available RAM ``" + Runtime.getRuntime().freeMemory() / mb + "/" + Runtime.getRuntime().maxMemory() / mb + "MB``\n" +
                                                        "Threads ``" + Runtime.getRuntime().availableProcessors() + "``", true)
                        .addField("Version", "``" + STATIC.VERSION + "``", true)
                        .addField("API-Latency", event.getJDA().getPing() + "ms", false)
                        .addField(event.getJDA().getGuilds().size() + " Servers","", false)
                        .addField(event.getJDA().getUsers().size() +" Users", "", false)
                        .addField("Database Usage",
                                "**Database 1-WNJM: **``" + event.getJDA().getGuildById("513296609623277599").getTextChannels().size() + "/500``\n" +
                                        "**Database 2-VNLM: **``" + event.getJDA().getGuildById("513297201666064390").getTextChannels().size() + "/500``\n" +
                                        "**Database 3-AA: **``" + event.getJDA().getGuildById("513297363608272896").getTextChannels().size() + "/500``\n" +
                                        "**Database 4-AR: **``" + event.getJDA().getGuildById("513717910414295080").getTextChannels().size() + "/500``\n" +
                                        "**Database 5-PS: **``" + event.getJDA().getGuildById("514431614210670592").getTextChannels().size() + "/500``\n" +
                                        "**Database 6-LXP: **``" + event.getJDA().getGuildById("514460308488716288").getTextChannels().size() + "/500``\n" +
                                        "**Database 7-CC: **``" + event.getJDA().getGuildById("515083259957346304").getTextChannels().size() + "/500``\n" +
                                        "**Database 8-CCH: **``" + event.getJDA().getGuildById("519454815806554112").getTextChannels().size() + "/500``\n" +
                                        "**Database 9-CCN: **``" + event.getJDA().getGuildById("521278542063992832").getTextChannels().size() + "/500``\n" +
                                        "**Database 10-GCP: **``" + event.getJDA().getGuildById("523536808265383937").getTextChannels().size() + "/500``\n" +
                                        "**Database 11-C: **``" + event.getJDA().getGuildById("548636655456747521").getTextChannels().size() + "/500``\n"
                                ,false)
                        .addField("Commandlist", STATIC.PREFIX + "help", false)
                        .addField("Invite me!", "[Add To Your Server](https://bit.ly/kazumabot)", true)
                        .addField("Support Server", "[Click to Join](https://discord.gg/fyJ6PFj)", true)
                        .addField("Vote for me!", "[Vote on discordbots.org](https://discordbots.org/bot/406097711603908621)", false)
                        .addField("GitHub", "https://github.com/shinixsensei-dev/TheKazumaBot", true)
                        .addField("Website", "[kazumabot.rf.gd](http://kazumabot.rf.gd)", true)
                        .setFooter("Kazuma is a project by MIYAKI Development. Copyright Owner is "  + event.getJDA().getUserById("265849018662387712").getName() + "#" + event.getJDA().getUserById("265849018662387712").getDiscriminator(), null)
                        .build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
