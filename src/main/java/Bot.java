import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private JDA jda;

    public Bot(String token) {
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setActivity(Activity.watching("DS Vorlesung"));
        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        if (jda == null)
            return;

        try {
            jda.awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Event Listener
        jda.addEventListener(new JulianListener());
        //Commands
        //jda.getGuildById("885601191487229963").upsertCommand(new CommandData("ping", "test command")).queue();
    }

    public static void main(String[] args) {
        new Bot("ODg1NjAyNjAzOTYxMDQ5MTA5.YTpbsg.8wQTYNd3O3MLvbOwoXy-31YgKrE");
    }
}