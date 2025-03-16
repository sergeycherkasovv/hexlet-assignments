package exercise;

import io.javalin.Javalin;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var firstName = capitalizeFirstLatter(ctx.formParam("firstName"));
            var lastName = capitalizeFirstLatter(ctx.formParam("lastName"));
            var email = ctx.formParam("email").trim().toLowerCase();

            var password = ctx.formParam("password");
            var encryptedPassword = Security.encrypt(password);

            var user = new User(firstName, lastName, email, encryptedPassword);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    private static String capitalizeFirstLatter(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        str.trim();

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}
