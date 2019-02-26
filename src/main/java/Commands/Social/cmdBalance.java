package Commands.Social;

import Commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdBalance implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(event.getMessage().getMentionedMembers().size() == 0) {
            String CREDITS;
            if(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                CREDITS = "0";
            }else {
                CREDITS = event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic();
            }
            event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention() + ", **you currently have a balance of " + CREDITS + " Credits!** :yen:").queue();
        }else {
            if(args.length == 2 && args[0].contains(event.getMessage().getMentionedMembers().get(0).getAsMention())) {
                int cGive, cHave, cNew, cRest, cGivenNew;
                String cMember, cId;
                cId = event.getMessage().getMentionedMembers().get(0).getUser().getId();
                cMember = event.getMessage().getMentionedMembers().get(0).getAsMention();
                cGive = Integer.parseInt(args[1]);
                cHave = Integer.parseInt(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
                if(cGive - cHave > 0) {
                    if(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(cId, true).size() > 0) {
                        cRest = Integer.parseInt(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(cId, true).get(0).getTopic());
                        cNew = cHave - cGive;
                        System.out.println("cHave " + cHave);
                        System.out.println("cGive " + cGive);
                        System.out.println("cNew " + cNew);
                        cGivenNew = cRest + cGive;
                        event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(cNew)).queue();
                        event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(cId, true).get(0).getManager().setTopic(String.valueOf(cGivenNew)).queue();
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", **gave " + cGive + " Credits to " + cMember + "!**").queue();
                    }else {
                        cNew = cHave - cGive;
                        System.out.println("cHave " + cHave);
                        System.out.println("cGive " + cGive);
                        System.out.println("cNew " + cNew);
                        event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(cNew)).queue();
                        event.getJDA().getGuildById("515083259957346304").getController().createTextChannel(cId).setTopic(String.valueOf(cGive)).queue();
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", **gave " + cGive + " Credits to " + cMember + "!**").queue();
                    }
                }else {
                    event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", **you don't have enough credits!**").queue();
                }
            }else {
                event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", **you need to select an amount of credits you want to give the specified user!** :yen:").queue();
            }
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
