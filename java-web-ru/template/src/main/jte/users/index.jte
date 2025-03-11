@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<div>
    <h2>${"USERS:"}</h2>
</div>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h3><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h3>
        </div>
    @endfor
@endif
</body>
</html>

