package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Scanner;

public class cmdBf implements Command {

    public StringBuilder evaluateBrainfuck(String code) {
        Scanner scanner = new Scanner(System.in);
        final int length = 65535;
        byte[] memory = new byte[length];
        int dataPointer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '>')
                dataPointer = (dataPointer == length - 1) ? 0 : dataPointer + 1;
            else if (code.charAt(i) == '<')
                dataPointer = (dataPointer == 0) ? length - 1 : dataPointer - 1;
            else if (code.charAt(i) == '+')
                memory[dataPointer]++;
            else if (code.charAt(i) == '-')
                memory[dataPointer]--;
            else if (code.charAt(i) == '.')
                stringBuilder.append((char) memory[dataPointer]);
            else if (code.charAt(i) == ',')
                memory[dataPointer] = (byte) scanner.next().charAt(0);
            else if (code.charAt(i) == '[') {
                if (memory[dataPointer] == 0) {
                    i++;
                    while (l > 0 || code.charAt(i) != ']') {
                        if (code.charAt(i) == '[') l++;
                        if (code.charAt(i) == ']') l--;
                        i++;
                    }
                }
            } else if (code.charAt(i) == ']') {
                if (memory[dataPointer] != 0) {
                    i--;
                    while (l > 0 || code.charAt(i) != '[') {
                        if (code.charAt(i) == ']') l++;
                        if (code.charAt(i) == '[') l--;
                        i--;
                    }
                    i--;
                }
            }

        }
        return stringBuilder;
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length == 0) {

            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setColor(Color.RED)
                            .setTitle("ERROR")
                            .setDescription("You need to add some **Brainfuck Code** to the command!")
                            .addField("Usage", "``" + STATIC.PREFIX + "brainfuck ++++[-]``", false)
                            .build()

            ).queue();

        }else {
            try {
                if (evaluateBrainfuck(args[0]).length() == 0) {
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(Color.CYAN)
                                    .setTitle("Brainfuck code has been compiled!")
                                    .addField("Input", "```md\n" +
                                            args[0] + "```", false)
                                    .addField("Output", "``` <No Output> ```", false)
                                    .build()

                    ).queue();
                } else {

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(Color.CYAN)
                                    .setTitle("Brainfuck code has been compiled!")
                                    .addField("Input", "```md\n" +
                                            args[0] + "```", false)
                                    .addField("Output", "```" + evaluateBrainfuck(args[0]) + "```", false)
                                    .build()

                    ).queue();
                }
            }catch (Exception e) {
                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setColor(Color.RED)
                                .setTitle("ERROR")
                                .setDescription("Sorry, I wasn't able to compile this properly. Please try again!")
                                .build()

                ).queue();
            }
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
