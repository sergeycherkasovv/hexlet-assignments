@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>Пользователь</title>
</head>
<body>
<div>
    <h2><a href="/users/${page.getUser().getId()}">${page.getUser().getFirstName()}</a></h2>
    <p>${page.getUser().getFirstName()}</p>
    <p>${page.getUser().getLastName()}</p>
    <p>${page.getUser().getEmail()}</p>
</div>
</body>
</html>