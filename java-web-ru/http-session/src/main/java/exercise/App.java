package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN

        app.get("/users", ctx -> {
            var page = Math.max(ctx.queryParamAsClass("page", Integer.class).getOrDefault(1), 1);
            var per = Math.max(ctx.queryParamAsClass("per", Integer.class).getOrDefault(5), 1);

            var users = USERS.stream()
                            .skip((page - 1) * per)
                            .limit(per)
                            .toList();

            ctx.json(users);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
