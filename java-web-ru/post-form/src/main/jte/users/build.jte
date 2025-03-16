@import exercise.model.User
@param User page

@template.layout.page(
content = @`
    <form action="/users" method="post"  class="form-floating mb-3">
        <h2>Регистрация</h2>
        <div class="mb-3">
            <label class="form-label">Имя</label>
            <input type="text" name="firsName" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Фамилия</label>
            <input type="text" name="lastName" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" required name="email" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label">Пароль</label>
            <input type="password" required name="password" class="form-control"/>
        </div>
        <button type="submit" value="Зарегистрировать" class="btn btn-primary">Зарегистрировать</button>
    </form>
    `
)