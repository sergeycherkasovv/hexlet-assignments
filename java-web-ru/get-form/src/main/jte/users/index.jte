@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get" class="row g-3">
            <div class="col-auto">
                <input class="form-control" type="search" name="term" value="${page.getTerm()}" placeholder="Search User">
            </div>
            <div class="col-auto">
                <button type="submit" value="Search" class="btn btn-primary mb-3">Search</button>
            </div>
        </form>
        @if(page.getUsers().isEmpty())
            <p>Users list is empty</p>
        @else
            @for(var user : page.getUsers())
                <div>${user.getFirstName()} ${user.getLastName()}</div>
            @endfor
        @endif
        `
)