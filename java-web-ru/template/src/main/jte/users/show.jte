@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>Пользователь</title>
</head>
<body>
<div>
    <p>${"ID: "}${page.getUser().getId()}</p>
    <p>${"Name: "}${page.getUser().getFirstName()}</p>
    <p>${"Last name: "}${page.getUser().getLastName()}</p>
    <p>${"Email: "}${page.getUser().getEmail()}</p>
</div>
</body>
</html>