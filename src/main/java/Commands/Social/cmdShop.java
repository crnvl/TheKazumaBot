package Commands.Social;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdShop implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {

            EmbedBuilder builder = new EmbedBuilder();
            builder.setDescription("__**Colors**__");
            builder.setColor(STATIC.MAIN);
            builder.setFooter("Use /k buy <item> to buy a color!", null);
            for (int i = 0; i < event.getJDA().getGuildById("548636655456747521").getEmotes().size(); i++) {
                builder.addField(event.getJDA().getGuildById("548636655456747521").getEmotes().get(i).getName(), event.getJDA().getGuildById("548636655456747521").getEmotes().get(i).getAsMention() + " - Price: 1000 Credits", true);
            }
            event.getTextChannel().sendMessage(builder.build()).queue();
        }else {
            switch(args[0]) {
                case "buy":
                    if(event.getJDA().getGuildById("548636655456747521").getEmotesByName(args[1], true).size() == 1) {
                        int credits, nNew;
                        if (event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                            credits = 0;
                        } else {
                            credits = Integer.parseInt(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
                        }
                        if (credits < 1000) {
                            event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", you don't have enough credits to buy this color!").queue();
                        } else {
                            nNew = credits - 1000;
                            event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(nNew)).queue();
                            if (event.getJDA().getGuildById("552907756622053376").getTextChannelsByName(event.getAuthor().getId(), true).size() == 1) {
                                event.getJDA().getGuildById("552907756622053376").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(args[1]).queue();
                                event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", you successfully bought **" + args[1] + "**").queue();
                            }else {
                                event.getJDA().getGuildById("552907756622053376").getController().createTextChannel(event.getAuthor().getId()).setTopic(args[1]).queue();
                                event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", you successfully bought **" + args[1] + "**").queue();
                            }
                        }
                    }else {
                        event.getTextChannel().sendMessage("This color doesn't exist!").queue();
                    }
                    break;

            }
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
