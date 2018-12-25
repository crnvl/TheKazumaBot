package Listeners.Announcements;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MemberChangeListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        if(event.getJDA().getGuildById("513296609623277599").getTextChannelsByName(event.getGuild().getId(), true).size() == 1 && event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 1) {

            String JOIN_MESSAGE, JOIN_CHANNEL;
            JOIN_MESSAGE = event.getJDA().getGuildById("513296609623277599").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("%USER%", event.getMember().getAsMention()).replace("%SERVER%", event.getGuild().getName()).replace("%MEMBERCOUNT%", event.getGuild().getMembers().size() + "");
            JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("#", "").replace("<", "").replace(">", "");

            event.getGuild().getTextChannelById(JOIN_CHANNEL).sendMessage(JOIN_MESSAGE).queue();

        }
        if(event.getJDA().getGuildById("513717910414295080").getTextChannelsByName(event.getGuild().getId(), true).size() == 1) {
            try{

                String ROLE_ID =  event.getJDA().getGuildById("513717910414295080").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic();
                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById(ROLE_ID)).queue();

            }catch (Exception e) {

            }
        }
    }

    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        if(event.getJDA().getGuildById("513297201666064390").getTextChannelsByName(event.getGuild().getId(), true).size() == 1 && event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 1) {

            String LEAVE_MESSAGE, JOIN_CHANNEL;
            LEAVE_MESSAGE = event.getJDA().getGuildById("513297201666064390").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("%USER%", event.getMember().getName()).replace("%SERVER%", event.getGuild().getName()).replace("%MEMBERCOUNT%", event.getGuild().getMembers().size() + "");
            JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("#", "").replace("<", "").replace(">", "");

            event.getGuild().getTextChannelById(JOIN_CHANNEL).sendMessage(LEAVE_MESSAGE).queue();

        }
    }
}
