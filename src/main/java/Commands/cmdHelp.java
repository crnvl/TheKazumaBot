package Commands;

import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdHelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length == 0) {
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("Commandlist")
                            .setDescription("This is a list of all my current commands! My Prefix is " + STATIC.PREFIX)
                            .addField("Bot Commands", "``about``, ``discordbots``, ``vote``, ``report``, ``invite``", true)
                            .addField("Social", "``daily``, ``redeem``, ``balance``", true)
                            .addField("Moderation Commands", "``setjoinmessage``, ``announcechannel``, ``setleavemessage``, ``setautorole``, ``setcountchannel``, ``setglobalchat``", true)
                            .addField("Fun Commands", "``8ball``, ``ratewaifu``, ``ship``, ``japanese``, ``profile``, ``say``, ``leaderboard``, ``brainfuck``, ``dog``, ``cat``, ``neko``, ``owofy``", true)
                            .addField("Kawaii Commands", "``hug``, ``kiss``, ``cuddle``, ``highfive``, ``lick``, ``hello``, ``nom``, ``pat``, ``slap``, ``tickle``, ``nosebleed``, ``dance``, ``baka``, ``cry``", true)
                            .addField("Games", "``osu``, ``paladins``", true)
                            .addField("Audit Log", "You can create a channel with the name 'kazuma-log' to activate the auditlog", true)
                            .addField("Help Command", "Use ``" + STATIC.PREFIX + "help <command>`` to get information about a specific command! (Don't include ``<`` or ``>``)", true)

                    .build()

            ).queue();
        }else {
            switch (args[0]) {
                case "owofy":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "neko":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "daily":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Social``", false)
                                    .addField("Aliases", "``redeem``", false)
                                    .build()

                    ).queue();
                    break;

                case "redeem":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Social``", false)
                                    .addField("Aliases", "``daily``", false)
                                    .build()

                    ).queue();
                    break;

                case "balance":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Social``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "about":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Bot Commands``", false)
                                    .addField("Aliases", "``/``", false)
                            .build()

                    ).queue();
                    break;

                case "db":
                case "discordbots":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Bot Commands``", false)
                                    .addField("Aliases", "``db``", false)
                                    .build()

                    ).queue();
                    break;
                case "vote":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Bot Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "report":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <description>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Bot Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .setFooter("Warning! The abuse of the bug report command is bannable!", null)
                                    .build()

                    ).queue();
                    break;

                case "invite":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Bot Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "8ball":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <question>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "ratewaifu":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "ship":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "japanese":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <statement>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "profile":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " (status <text>)``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "say":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <text>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "leaderboard":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "brainfuck":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "dog":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "cat":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + "``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Fun Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "hug":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "baka":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "cry":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "cuddle":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "dance":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "hello":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "highfive":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "kiss":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "lick":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "nom":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "nosebleed":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "pat":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "slap":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "tickle":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <mention>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Kawaii Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "setjoinmessage":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <message>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .addField("Attributes", "``%USER%``, ``%SERVER%``, ``%MEMBERCOUNT%``", false)
                                    .build()

                    ).queue();
                    break;

                case "announcechannel":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <#channel>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "setleavemessage":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <message>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .addField("Attributes", "``%USER%``, ``%SERVER%``, ``%MEMBERCOUNT%``", false)
                                    .build()

                    ).queue();
                    break;

                case "setautorole":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <@role>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "setcountchannel":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <#channel>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "setglobalchat":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <#channel>``")
                                    .addField("Required Permission", "``MANAGE_SERVER``", false)
                                    .addField("Category", "``Moderation Commands``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

                case "osu":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <username> <mode (standard, taiko, mania, ctb)>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Games``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;
                case "paladins":
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Command information")
                                    .setDescription("Usage: ``" + STATIC.PREFIX + args[0] + " <username>``")
                                    .addField("Required Permission", "``/``", false)
                                    .addField("Category", "``Games``", false)
                                    .addField("Aliases", "``/``", false)
                                    .build()

                    ).queue();
                    break;

            }
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
